package com.lj.eoms.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lj.eoms.utils.FileUtils;


/**
 * 
 * 
 * 类说明：文件工具处理层
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年7月14日
 */
@Controller
@RequestMapping({"${adminPath}/file" })
public class FileController {

	private static ObjectMapper objectMapper = new ObjectMapper();
	
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
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	 @RequestMapping(value={"/upload"}, method=RequestMethod.POST)
	 public void upload(String fileType,String dirName,Integer width,Integer height, MultipartFile file, HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException{
		response.setContentType("text/html; charset=UTF-8");
	    if (file==null || !FileUtils.fileTypeVaild(fileType, file.getOriginalFilename()) || !FileUtils.fileSizeVaild(file)){
	    	objectMapper.writeValue(response.getWriter(), "上传文件格式或大小不正确！");
	    }else{
	      String str = null;	
	      if("image".equals(fileType)&&(width!=null || height!=null) ){
	    	  if(height==null){
	    		  height=0;
	    	  }
	    	  if(width==null){
	    		  width=0;
	    	  }
	    	  str = FileUtils.imgScale(dirName, file, height, width, false);
	      }else{
	    	  str = FileUtils.upload(fileType, dirName, file);
	      }	
	      if (str == null) {
	    	objectMapper.writeValue(response.getWriter(), "上传失败！");
	      }
	      HashMap localHashMap = new HashMap();
	      localHashMap.put("url", str);
	      localHashMap.put("message", "上传成功");
	      objectMapper.writeValue(response.getWriter(), localHashMap);
	    }
	  }
}
