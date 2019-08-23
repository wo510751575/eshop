package com.lj.eoms.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUtils {

	private static long maxSize = 10485760;// 10M文件大小
	private static org.slf4j.Logger logger = LoggerFactory.getLogger(FileUtils.class);
	private static Map<String, String> extMap = new HashMap<String, String>();
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
	 * @param type
	 *            文件类型
	 * @param fileName
	 *            文件名
	 * @return
	 */
	public static Boolean fileTypeVaild(String type, String fileName) {
		if (!extMap.keySet().contains(type)) {
			return false;
		}
		if (!Arrays.<String> asList(extMap.get(type).split(",")).contains(
				FilenameUtils.getExtension(fileName.toLowerCase()))) {// 检查扩展名
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

	public static String imgScale(String dirName, MultipartFile file,
			int height, int width, boolean flag) {
		logger.info("height:{},width:{}",height,width);
		if (!fileTypeVaild("image", file.getOriginalFilename())
				|| !fileSizeVaild(file)) {
			return null;
		}
		logger.info("height:{},width:{} valid.",height,width);
		try {
			double ratio = 0.0; // 缩放比例
			BufferedImage bi = ImageIO.read(file.getInputStream());
			if(height==0){
				height=bi.getHeight();
			}
			if(width==0){
				width=bi.getWidth();
			}
			Image itemp = bi.getScaledInstance(width, height,
					Image.SCALE_SMOOTH);
			// 计算比例
            if (bi.getHeight() > height || bi.getWidth() > width) {
                if (bi.getHeight() > bi.getWidth()) {
                    ratio = new Integer(height).doubleValue()
                            / bi.getHeight();
                } else {
                    ratio = new Integer(width).doubleValue() / bi.getWidth();
                }
                AffineTransformOp op = new AffineTransformOp(AffineTransform
                        .getScaleInstance(ratio, ratio), null);
                itemp = op.filter(bi, null);
            }

			if (flag) {// 补白
				BufferedImage image = new BufferedImage(width, height,
						BufferedImage.TYPE_INT_RGB);
				Graphics2D g = image.createGraphics();
				g.setColor(Color.white);
				g.fillRect(0, 0, width, height);
				if (width == itemp.getWidth(null)) {
					g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
							itemp.getWidth(null), itemp.getHeight(null),
							Color.white, null);
				} else {
					g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
							itemp.getWidth(null), itemp.getHeight(null),
							Color.white, null);
				}
				g.dispose();
				itemp = image;
			}

			ResourceBundle upload = ResourceBundle.getBundle("upload");
			String extension = FilenameUtils.getExtension(file
					.getOriginalFilename());
			String key = "image/" + dirName + "/" + UUID.randomUUID() + "."
					+ extension;
			File dirFile = new File(upload.getString("rootPath") + key);
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
			logger.error("缩略图失败",e);
			e.printStackTrace();
		} finally {
		}
		return null;
	}

	public static String upload(String type, String dirName, MultipartFile file) {
		if (!fileTypeVaild(type, file.getOriginalFilename())
				|| !fileSizeVaild(file)) {
			return null;
		}
		try {
			ResourceBundle upload = ResourceBundle.getBundle("upload");
			String key = type + "/" + dirName + "/" + UUID.randomUUID() + "."
					+ FilenameUtils.getExtension(file.getOriginalFilename());
			File dirFile = new File(upload.getString("rootPath") + key);
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
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		try {
//			int transparency = Transparency.OPAQUE;
			int transparency = Transparency.TRANSLUCENT;
			
			GraphicsDevice gs = ge.getDefaultScreenDevice();
			GraphicsConfiguration gc = gs.getDefaultConfiguration();
			bimage = gc.createCompatibleImage(image.getWidth(null),image.getHeight(null), transparency);
		} catch (HeadlessException e) {
		}

		if (bimage == null) {
			int type = BufferedImage.TYPE_INT_RGB;
			bimage = new BufferedImage(image.getWidth(null),image.getHeight(null), type);
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
	public static String download(HttpServletRequest request,
			HttpServletResponse response, String realpath) throws Exception {

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
			java.io.FileInputStream fileInputStream = new java.io.FileInputStream(
					file);
			// 下载文件
			// 设置响应头和下载保存的文件名
			response.setContentType("application/x-msdownload");// 弹出下载的框
			response.setContentLength((int) file.length());// 下载统计文件大小的进度
			response.setHeader("Content-Disposition",
					"attachment; filename="
							+ new String(file.getName().getBytes("UTF-8"),
									"ISO-8859-1"));// fileName
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
}
