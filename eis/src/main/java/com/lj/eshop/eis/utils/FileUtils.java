package com.lj.eshop.eis.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.ape.common.utils.StringUtils;
import com.lj.base.core.util.GUID;
import com.lj.cc.clientintf.LocalCacheSystemParamsFromCC;
import com.lj.cc.enums.GroupName;
import com.lj.cc.enums.SysParamName;
import com.lj.cc.enums.SystemAliasName;
import com.lj.eshop.eis.spring.SpringContextUtil;

public class FileUtils {

	private static long maxSize = 10485760;// 10M文件大小
	private static Logger logger = Logger.getLogger(FileUtils.class);

	private static Map<String, String> extMap = new HashMap<String, String>();
	private static LocalCacheSystemParamsFromCC localCacheSystemParams = SpringContextUtil
			.getBean(LocalCacheSystemParamsFromCC.class);
	static {
		extMap.put("image", "gif,jpg,jpeg,png,bmp");
		extMap.put("flash", "swf,flv");
		extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
		extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
		extMap.put("video", "mp4,avi,Ogg,ogg");
	}

	/**
	 * 文件验证格式
	 * 
	 * @param type     文件类型
	 * @param fileName 文件名
	 * @return
	 */
	public static Boolean fileTypeVaild(String type, String fileName) {
		if (!extMap.keySet().contains(type)) {
			return false;
		}
		if (!Arrays.<String>asList(extMap.get(type).split(","))
				.contains(FilenameUtils.getExtension(fileName.toLowerCase()))) {// 检查扩展名
			return false;
		}
		return true;
	}

	/**
	 * 验证文件大小
	 * 
	 * @param file
	 * @return
	 */
	public static Boolean fileSizeVaild(MultipartFile file) {
		if (file.getSize() > maxSize) {
			return false;
		}
		return true;
	}

	/**
	 * 压缩图片 方法说明：
	 * 
	 * @param @param dirName 目录名
	 * @param @param file 上传文件
	 * @param @param height 压缩高
	 * @param @param width 压缩宽
	 * @param @param flag
	 * @param @param reloate 旋转角度
	 * @param @return 设定文件
	 * @return String 返回类型
	 */
	public static String imgScale(String dirName, MultipartFile file, Integer height, Integer width, boolean flag,
			Integer reloate) {
		if (!fileTypeVaild("image", file.getOriginalFilename()) || !fileSizeVaild(file)) {
			return null;
		}
		try {
			double ratio = 0.0; // 缩放比例
			BufferedImage bi = ImageIO.read(file.getInputStream());

			// TODO 新增转角度方法，如果有问题，请注释这行进行恢复就可以 by linjinquan
			if (null != reloate) {
				logger.debug("reloate>>" + reloate);
				// bi = reloateBufferedImage(file.getInputStream(), bi);
				bi = rotateImage(bi, reloate);
			}

			Image itemp = null;
			/* 不传宽高，不进行压缩 */
			if (width != null && height != null) {
				itemp = bi.getScaledInstance(width, height, Image.SCALE_SMOOTH);
				// 计算比例
				if (bi.getHeight() > height || bi.getWidth() > width) {
					if (bi.getHeight() > bi.getWidth()) {
						ratio = new Integer(height).doubleValue() / bi.getHeight();
					} else {
						ratio = new Integer(width).doubleValue() / bi.getWidth();
					}
					AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
					itemp = op.filter(bi, null);
				}
			} else {
				itemp = bi.getScaledInstance(bi.getWidth(), bi.getHeight(), Image.SCALE_SMOOTH);
			}

			if (flag) {// 补白
				BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics2D g = image.createGraphics();
				g.setColor(Color.white);
				g.fillRect(0, 0, width, height);
				if (width == itemp.getWidth(null)) {
					g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2, itemp.getWidth(null),
							itemp.getHeight(null), Color.white, null);
				} else {
					g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0, itemp.getWidth(null),
							itemp.getHeight(null), Color.white, null);
				}
				g.dispose();

				itemp = image;
			}

			String extension = FilenameUtils.getExtension(file.getOriginalFilename());
			String key = "image/" + dirName + "/" + UUID.randomUUID() + "." + extension;
			File dirFile = new File(getUploadPath() + key);
			if (!dirFile.exists()) {
				dirFile.mkdirs();
			}
			if ("png".equals(extension) || "PNG".equals(extension)) {
				ImageIO.write(toBufferedImage(itemp), "png", dirFile);
			} else {
				ImageIO.write(toBufferedImage(itemp), "JPEG", dirFile);
			}
			return "/" + key;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
		return null;
	}

	public static String upload(String type, String dirName, MultipartFile file) {
		if (!fileTypeVaild(type, file.getOriginalFilename()) || !fileSizeVaild(file)) {
			return null;
		}
		try {
//			ResourceBundle upload = ResourceBundle.getBundle("properties/upload");
			String key = type + "/" + dirName + "/" + UUID.randomUUID() + "."
					+ FilenameUtils.getExtension(file.getOriginalFilename());
			File dirFile = new File(getUploadPath() + key);
			if (!dirFile.exists()) {
				dirFile.mkdirs();
			}
			file.transferTo(dirFile);
			return "/" + key;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return null;
	}

	public static BufferedImage toBufferedImage(Image image) {
		if (image instanceof BufferedImage) {
			return (BufferedImage) image;
		}
		image = new ImageIcon(image).getImage();
		BufferedImage bimage = null;
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try {
			// int transparency = Transparency.OPAQUE;
			int transparency = Transparency.TRANSLUCENT;

			GraphicsDevice gs = ge.getDefaultScreenDevice();
			GraphicsConfiguration gc = gs.getDefaultConfiguration();
			bimage = gc.createCompatibleImage(image.getWidth(null), image.getHeight(null), transparency);
		} catch (HeadlessException e) {
		}

		if (bimage == null) {
			int type = BufferedImage.TYPE_INT_RGB;
			bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
		}
		Graphics g = bimage.createGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		return bimage;
	}

	/**
	 * 对文件进行下载操作新增
	 * 
	 * @param request
	 * @throws Exception
	 */
	public static String download(HttpServletRequest request, HttpServletResponse response, String realpath)
			throws Exception {

		ServletOutputStream ou = null;
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			ou = response.getOutputStream();
			File file = new File(realpath);
			if (!file.exists()) {
				logger.info("路径:" + file.getAbsolutePath() + " 文件不存在!");
				return (file.getAbsolutePath() + " 文件不存在!");
			}
			// 读取文件流
			java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
			// 下载文件
			// 设置响应头和下载保存的文件名
			response.setContentType("application/x-msdownload");// 弹出下载的框
			response.setContentLength((int) file.length());// 下载统计文件大小的进度
			response.setHeader("Content-Disposition",
					"attachment; filename=" + new String(file.getName().getBytes("UTF-8"), "ISO-8859-1"));// fileName
			// 下载框的信息
			if (fileInputStream != null) {
				int filelen = fileInputStream.available();
				// 文件太大时内存不能一次读出,要循环
				byte a[] = new byte[filelen];
				fileInputStream.read(a);
				ou.write(a);
			}
			fileInputStream.close();
			ou.flush();
			ou.close();
		} catch (Exception e) {
			logger.info("下载文档出错：" + e);
			e.printStackTrace();
			return e.getMessage();
		} finally {
			ou = null;
			response.flushBuffer();
		}
		return "";
		// 解决完成后使用一切正常,但是总抛出java.lang.IllegalStateException异常主要是流还存在
	}

	/**
	 * 方法说明：保存图片 copy for api
	 * 
	 * @author 林进权 CreateDate: 2017年9月22日
	 *
	 */
	public static String saveFile(String filePath, MultipartFile fileTemp) throws IOException {
		String fileName = fileTemp.getOriginalFilename();
		logger.debug("【添加图片】上传文件，filePath : " + filePath + ",fileName:" + fileName);
		String postfix = fileName.indexOf(".") == -1 ? "" : fileName.substring(fileName.indexOf("."));
		String fileInputName = GUID.generateByIP() + postfix;
		logger.debug("【添加图片】保存到本地，fileInputName:" + fileInputName);
		File fileInput = new File(filePath + fileInputName);
		if (fileInput.getParentFile() != null && fileInput.getParentFile().exists() == false) {
			if (fileInput.getParentFile().mkdirs() == false) {
				throw new IOException("Destination '" + fileInput + "' directory cannot be created");
			}
		}
		fileTemp.transferTo(fileInput);
		return fileInputName;
	}

	/**
	 * 旋转图片为指定角度
	 * 
	 * @param bufferedimage 目标图像
	 * @param degree        旋转角度
	 * @return
	 */
	public static BufferedImage rotateImage(final BufferedImage bufferedimage, final int degree) {
		int src_width = bufferedimage.getWidth(null);
		int src_height = bufferedimage.getHeight(null);
		// calculate the new image size
		Rectangle rect_des = CalcRotatedSize(new Rectangle(new Dimension(src_width, src_height)), degree);

		BufferedImage res = null;
		res = new BufferedImage(rect_des.width, rect_des.height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = res.createGraphics();
		// transform
		g2.translate((rect_des.width - src_width) / 2, (rect_des.height - src_height) / 2);
		g2.rotate(Math.toRadians(degree), src_width / 2, src_height / 2);

		g2.drawImage(bufferedimage, null, null);
		return res;

	}

	public static Rectangle CalcRotatedSize(Rectangle src, int angel) {
		// if angel is greater than 90 degree, we need to do some conversion
		if (angel >= 90) {
			if (angel / 90 % 2 == 1) {
				int temp = src.height;
				src.height = src.width;
				src.width = temp;
			}
			angel = angel % 90;
		}

		double r = Math.sqrt(src.height * src.height + src.width * src.width) / 2;
		double len = 2 * Math.sin(Math.toRadians(angel) / 2) * r;
		double angel_alpha = (Math.PI - Math.toRadians(angel)) / 2;
		double angel_dalta_width = Math.atan((double) src.height / src.width);
		double angel_dalta_height = Math.atan((double) src.width / src.height);

		int len_dalta_width = (int) (len * Math.cos(Math.PI - angel_alpha - angel_dalta_width));
		int len_dalta_height = (int) (len * Math.cos(Math.PI - angel_alpha - angel_dalta_height));
		int des_width = src.width + len_dalta_width * 2;
		int des_height = src.height + len_dalta_height * 2;
		return new java.awt.Rectangle(new Dimension(des_width, des_height));
	}

	// 测试
	public static void main(String[] args) throws Exception {
		System.gc();
		Runtime startRt = Runtime.getRuntime();
		long start = startRt.freeMemory();

		String path = "C:\\Users\\dell\\Pictures\\Camera Roll\\tmp1";
		File files = new File(path);
		for (String filename : files.list()) {
			File source = new File(path + "\\" + filename);
			File target = new File(path + "\\1-" + filename);
			createFile(source, target);
//			break;
		}

		long end = startRt.freeMemory();
		System.out.println((end - start) / (1024 * 1024));
	}

	public static void createFile(File source, File target) throws Exception {
		InputStream ins = new FileInputStream(source);
		BufferedImage bi = ImageIO.read(source);
		bi = rotateImage(bi, 90); // 0/90/180/270
		ImageIO.write(bi, "jpg", target);
		if (null != ins) {
			ins.close();
		}
	}

	/**
	 * base64图片处理 方法说明：
	 *
	 * @param @param dirName
	 * @param @param file
	 * @param @param height
	 * @param @param width
	 * @param @param b
	 * @param @param reloate
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws Exception
	 *
	 * @author 林进权 CreateDate: 2017年10月12日
	 * @throws IOException
	 */
	public static String imgScale64(String dirName, Integer height, Integer width, boolean b, Integer reloate,
			String img64Str) throws IOException {
		if (img64Str == null) {// 图像数据为空
			return null;
		}

		if (img64Str.startsWith("data:image/jpeg;base64,")) {
			img64Str = img64Str.replace("data:image/jpeg;base64,", "");
		}

		Base64 base64 = new Base64();
		byte[] bb = base64.decode(img64Str);
		for (int i = 0; i < bb.length; ++i) {
			if (bb[i] < 0) {// 调整异常数据
				bb[i] += 256;
			}
		}

//		ResourceBundle upload = ResourceBundle.getBundle("properties/upload");
		String imgPath = getUploadPath() + "image/" + dirName;
		File dirFile = new File(imgPath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		String key = UUID.randomUUID() + ".jpeg";
		File imgFile = new File(imgPath + "/" + key);

		// 生成图片
		OutputStream out = new FileOutputStream(imgFile);
		out.write(bb);
		out.flush();
		out.close();

		MultipartFile multipartFile = new MockMultipartFile(key, key, null, new FileInputStream(imgFile));

		if (imgFile.exists()) {
			imgFile.delete();
		}

		return imgScale(dirName, multipartFile, height, width, b, reloate);
	}

	private static String getUploadPath() {
		String uploadPath = localCacheSystemParams.getSystemParam(SystemAliasName.ms.toString(),
				GroupName.upload.toString(), SysParamName.UPLOADPATH.getText());
		if (StringUtils.isBlank(uploadPath)) {
			logger.error("配置的文件上传路径为空 ！！！！！！！！！");
			return null;
		}
		return uploadPath;
	}

}
