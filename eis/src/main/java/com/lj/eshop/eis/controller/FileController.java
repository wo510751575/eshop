package com.lj.eshop.eis.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.lj.eshop.eis.dto.ResponseCode;
import com.lj.eshop.eis.dto.ResponseDto;
import com.lj.eshop.eis.utils.FileUtils;


/**
 * 
 * 
 * 类说明：文件工具处理层
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年7月14日
 */
@Controller
@RequestMapping({"/file" })
public class FileController{

	/**
	 * 
	 *
	 * 方法说明：上传文件公共处理
	 *
	 * @param fileType
	 * @param dirName
	 * @param width
	 * @param height
	 * @param file
	 * @param response
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 *
	 * @author 段志鹏 CreateDate: 2017年7月14日
	 *
	 */
	 @RequestMapping(value={"/upload"},method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	 @ResponseBody
	 public ResponseDto upload(String fileType,String dirName,Integer width,Integer height, MultipartFile file, HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException{
		response.setContentType("text/html; charset=UTF-8");
	    if (file==null || !FileUtils.fileTypeVaild(fileType, file.getOriginalFilename()) || !FileUtils.fileSizeVaild(file)){
	    	return ResponseDto.createResp(false, ResponseCode.UPLOAD_TYPE_ERROR.getCode(), ResponseCode.UPLOAD_TYPE_ERROR.getMsg(), null);
	    }
	    
	      String str = null;	
	      if("image".equals(fileType)){
	    	  str = FileUtils.imgScale(dirName, file, height, width, false);
	      }else{
	    	  str = FileUtils.upload(fileType, dirName, file);
	      }	
	      if (str == null) {
	    	  return ResponseDto .createResp(false, ResponseCode.UPLOAD_ERROR.getCode(), ResponseCode.UPLOAD_ERROR.getMsg(), null);
	      }
		return ResponseDto.successResp(str);
	  }
}
