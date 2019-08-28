/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市深圳扬恩科技 License, Version 1.0 (the "License");
 * 
 */
package com.lj.eshop.eis.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

import javax.imageio.ImageIO;

import com.lj.base.core.util.StringUtils;
import com.swetake.util.Qrcode;

/**
 * 
 * 类说明：商品分享二维码生成。
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年8月31日
 */
public class ProductQRcodeUtil {
	
	/**
	 * 方法说明：给产品生成二维码图片。
	 *
	 * @param url 分享URL
	 * @param imgurl 商品封面图 ,相对路径
	 * @param name 商品名称
	 * @param price 售价 
	 * @return
	 *
	 * @author lhy  2017年8月31日
	 *
	 */
	public static String createShareQRcode(String url ,String imgurl,String name,BigDecimal price){
		//保留2位小数
		if(price==null){
			price=new BigDecimal(0);
		}
		   price   =   price.setScale(2,   BigDecimal.ROUND_HALF_UP); 
		try {
			
			 
			String key = imgurl;
			String productPic=null;
			ResourceBundle upload = ResourceBundle.getBundle("properties/upload");
			/*if(StringUtils.isNotEmpty(imgurl)){ 服务器本机目录
				productPic=upload.getString("rootPath") + key;
			}*/
			productPic=upload.getString("uploadUrl") + key;
			return graphicsGeneration(url, productPic, name, "￥"+String.valueOf(price));
		} catch (Exception e) {
			throw new RuntimeException("制作分享图片错误。",e);
		}
	}

	private static String graphicsGeneration(String url ,String imgurl,String name,String price) throws Exception {
		int imageWidth = 300; // 图片的宽度
		int imageHeight = 700; // 图片的高度
		
	    int picImgHeight=300;//商品图片的高
        int picImgWidth=300;
        int qcImgHeight=300;//二维码图片的高
        int qcImgWidth=300;
        
        int lineHeight=3;
        int headHeight =10;
        int nameHeight=50;
      //  int priceHeigh=30;
        int paddingHeight=2;
        
        int qcX=(imageWidth-qcImgWidth)/2;
        int qcY=headHeight;
        int lineX=0;
        int lineY=qcY+paddingHeight+qcImgHeight;
        int picX=0;
        int picY=lineY+lineHeight+paddingHeight;
        int nameX=10;
        int nameY=picY+picImgHeight+paddingHeight+12;
        int priceX=10;
       // int priceY=nameY+nameHeight+paddingHeight;
		
		
			BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
	        //设置图片的背景色
	        Graphics2D main = image.createGraphics();
	        main.setColor(Color.white);
	        main.fillRect(0, 0, imageWidth, imageHeight);
	        
	        //***********************插入二维码
	        Graphics qcPic = image.getGraphics();
	        BufferedImage qcBimg = null;
	        try {
	        	qcBimg = createQRCode(url, 15,  null);
	        } catch (Exception e) {
	        	throw e;
	        }
	        if(qcBimg!=null){
	        	qcPic.drawImage(qcBimg, qcX, qcY, qcImgWidth, qcImgHeight, null);
	        	qcPic.dispose();
	        }
	        String fontStyle="宋体";//;
	        //***********************按钮
	        Font btnFont = new Font(fontStyle, Font.BOLD, 14);
	        Graphics2D btn1 = image.createGraphics();
	        btn1.setColor(Color.BLACK);//#29C65A
	        btn1.fillRect(lineX,lineY, imageWidth, paddingHeight);
	        btn1.setColor(Color.BLACK);
	        btn1.drawRect(lineX,lineY, imageWidth, paddingHeight);
	        //btn1 文本
	        btn1.setColor(Color.white);
	        btn1.setFont(btnFont);
	        
	        //***********************插入产品图片
	        if(StringUtils.isNotEmpty(imgurl)){
		        Graphics mainPic = image.getGraphics();
		        BufferedImage bimg = null;
		        try {
		           //BufferedReader reader = new BufferedReader(new InputStreamReader(wwwUrl.openStream()));  
		           //bimg = javax.imageio.ImageIO.read(new java.io.File(imgurl));
		        	URL wwwUrl = new URL(imgurl);  
		        	bimg = javax.imageio.ImageIO.read(wwwUrl);
		        } catch (Exception e) {
		        	throw new RuntimeException("file maybe not find:"+imgurl,e);
		        }
		        if(bimg!=null){
		            mainPic.drawImage(bimg, picX, picY, picImgWidth, picImgHeight, null);
		            mainPic.dispose();
		        }
	        }
	        
	        //***********************插入产品名称
	        Graphics title = image.createGraphics();
	        //设置区域颜色
	        title.setColor(Color.white);
	        //填充区域并确定区域大小位置
	        title.fillRect(nameX, nameY, imageWidth, nameHeight);
	        //设置字体颜色，先设置颜色，再填充内容
	        title.setColor(Color.black);
	        //设置字体
	        Font titleFont = new Font(fontStyle, Font.PLAIN, 14);
	        title.setFont(titleFont);
	        //换行写字
	        int lineW=0;
	        StringBuilder sb=new StringBuilder();
	        int row=0;
	        int y=nameY;
	        int fontHeight=17;
	        //按一个双字节15像素，单字节8像素算
	        for (int i = 0; i < name.length(); i++) {
				char tempChar = name.charAt(i);
				sb.append(tempChar);
				lineW += getCharLen(tempChar+"");
				if(lineW>=imageWidth){
					 y= y+(fontHeight)*row;
					 title.drawString(sb.toString(), nameX, y);
					 lineW=0;
				     sb=new StringBuilder();
				     row++;
				}
	        }
	        if(sb.length()>0){
	        	 y= y+(fontHeight);
				 title.drawString(sb.toString(), nameX, y);
	        }
	        y= y+(fontHeight)+paddingHeight*2;
	        //***********************插入产品价格
	        title.drawString(price, priceX, y);
	        
	        ResourceBundle upload = ResourceBundle.getBundle("properties/upload");
			String key = "image/product/qccode/" + UUID.randomUUID() + ".jpg";
	        String outPath=upload.getString("rootPath") + key;
	        createImage(outPath,image);
	        return upload.getString("eomsPath") + key;
	}
	
	private static int getCharLen(String a){
		if(a.getBytes().length>0){
			return 14;
		}else{
			return 7;
		}
	}
	
	/** 
   * <span style="font-size:18px;font-weight:blod;">QRCode 方式生成二维码</span> 
   * @param content    二维码内容 
   * @param version    二维码版本 
   * @param isFlag    是否生成Logo图片    为NULL不生成 
 * @throws Exception 
   */  
  private static BufferedImage createQRCode(String content,int version, String logoPath) throws Exception{  
       try {    
          Qrcode qrcodeHandler = new Qrcode();    
          //设置二维码排错率，可选L(7%) M(15%) Q(25%) H(30%)，排错率越高可存储的信息越少，但对二维码清晰度的要求越小      
          qrcodeHandler.setQrcodeErrorCorrect('H');    
          //N代表数字,A代表字符a-Z,B代表其他字符    
          qrcodeHandler.setQrcodeEncodeMode('B');    
        //  content= URLEncoder.encode(content, "UTF-8");
          //版本1为21*21矩阵，版本每增1，二维码的两个边长都增4；所以版本7为45*45的矩阵；最高版本为是40，是177*177的矩阵    
          qrcodeHandler.setQrcodeVersion(version);  
          //根据版本计算尺寸  
          int imgSize = 67 + 12 * (version - 1) ;    
          byte[] contentBytes = content.getBytes();    
          BufferedImage bufImg = new BufferedImage(imgSize , imgSize ,BufferedImage.TYPE_INT_RGB);    
          Graphics2D gs = bufImg.createGraphics();    
          gs.setBackground(Color.WHITE);    
          gs.clearRect(0, 0, imgSize , imgSize);    
          // 设定图像颜色 > BLACK  
          gs.setColor(Color.BLACK);  
          // 设置偏移量 不设置可能导致解析出错    
          int pixoff = 2;  
          // 输出内容 > 二维码    
          //if (contentBytes.length > 0 && contentBytes.length < 130) {  
              boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);  
              for (int i = 0; i < codeOut.length; i++) {  
                  for (int j = 0; j < codeOut.length; j++) {  
                      if (codeOut[j][i]) {    
                          gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);  
                      }    
                  }    
              }    
//          } else {    
//              System.err.println("QRCode content bytes length = " + contentBytes.length + " not in [ 0,130 ]. ");    
//          }  
         /* 判断是否需要添加logo图片 */  
          if(logoPath != null){  
              File icon = new File(logoPath);  
              if(icon.exists()){  
                  int width_4 = imgSize / 4;  
                  int width_8 = width_4 / 2;  
                  int height_4 = imgSize / 4;  
                  int height_8 = height_4 / 2;  
                  Image img = ImageIO.read(icon);  
                  gs.drawImage(img, width_4 + width_8, height_4 + height_8,width_4,height_4, null);  
                  gs.dispose();  
                  bufImg.flush();  
              }else{  
                  System.out.println("Error: login图片还在在！");  
              }  

          }  
          gs.dispose();  
          bufImg.flush();  
          return bufImg;
       } catch (Exception e) {    
           throw e;
       }  
       
  }  
  
	//生成图片文件
	private static void createImage(String fileLocation, BufferedImage image) throws Exception {
		File dirFile = new File(fileLocation);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		ImageIO.write(image, "JPEG", dirFile);
    }
 
	
	public static void main(String[] args) throws Exception {
		String url="http://dv.uxuan.info/dist-em/goodDetail?menu=0&code=LJ_356b0556fdc94fea9ff52a45b3b47c42&shopCode=LJ_0e0a461585fa493794cc1368b87ec324";
		String name="施华洛世奇Frisson时间简约戒指指环女经典百搭配饰施华洛世奇Frisson时间简约戒指指环女经典百搭配饰";
		//String price="￥6000";
		BigDecimal price=new BigDecimal(8888.4432);
		String key=ProductQRcodeUtil.createShareQRcode(url,"/eoms/image/product/b89f8cc8-ff43-44d7-8d5b-35f310baa5ba.png",name,price);
		System.out.println(key);
	}
}
