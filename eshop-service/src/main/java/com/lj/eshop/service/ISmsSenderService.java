package com.lj.eshop.service;

import java.util.Map;

import com.lj.base.exception.TsfaServiceException;

/**
 * 
 * 
 * 类说明：短信发送服务
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年9月4日
 */
public interface ISmsSenderService {
	
	/**
	 * 
	 *
	 * 方法说明：发送短信
	 *
	 * @param mobile		接收人号码
	 * @param content		内容
	 * @param map			
	 * @param bizType		业务类型 0:注册验证码 1:密码修改验证 2:提现验证码 3:B端用户登录
	 * @throws TsfaServiceException
	 *
	 * @author 段志鹏 CreateDate: 2017年9月4日
	 *
	 */
	public void sendTemplateSms(String mobile,String content,Map<String, String> map,String bizType) throws TsfaServiceException;
	

}
