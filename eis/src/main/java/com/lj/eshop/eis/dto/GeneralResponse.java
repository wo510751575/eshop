package com.lj.eshop.eis.dto;

import java.io.Serializable;

import com.lj.base.mvc.base.json.JsonUtils;

/**
 * 
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月1日
 */
public class GeneralResponse implements Serializable {

	private static final long serialVersionUID = -2924560860709094403L;

	/*** 操作是否成功. */
	private boolean result; 

	/** * 返回结果Code. */
	private String errorCode;

	/** * 返回结果信息. */
	private String errorMessage;

	/** * 返回数据的对象（操作成功才有）. */
	private Object returnObject;

	/**
	 * @return the result
	 */
	public boolean isResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(boolean result) {
		this.result = result;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the returnObject
	 */
	public Object getReturnObject() {
		return returnObject;
	}

	/**
	 * @param returnObject the returnObject to set
	 */
	public void setReturnObject(Object returnObject) {
		this.returnObject = returnObject;
	}

	/**
	 * 
	 *
	 * 方法说明：将对象转为json格式字符串
	 *
	 * @author 彭阳
	 *   
	 * CreateDate: 2017-7-1
	 * 
	 * @return
	 */
	public String toJson() {
		return JsonUtils.jsonFromObject_LongToString(this);
	}

	/**
	 * 
	 *
	 * 方法说明：
	 *
	 * @author 彭阳
	 *   
	 * CreateDate: 2017-7-1
	 * 
	 * @param isSucess
	 * @param errorCode
	 * @param errorMessage
	 * @param returnObject
	 * @return
	 */
	public static GeneralResponse generateResponse(boolean isSucess, String errorCode, String errorMessage, Object returnObject) {
		GeneralResponse gr = new GeneralResponse();
		gr.setResult(isSucess);
		gr.setErrorCode(errorCode);
		gr.setErrorMessage(errorMessage);
		gr.setReturnObject(returnObject);
		return gr;
	}

	/**
	 * 
	 *
	 * 方法说明：操作成功返回
	 *
	 * @author 彭阳
	 *   
	 * CreateDate: 2017-7-1
	 * 
	 * @return
	 */
	public static GeneralResponse generateSuccessResponse(){
		return generateResponse(Boolean.TRUE, "", "", "");
	} 

	/**
	 * 
	 *
	 * 方法说明：操作成功返回
	 *
	 * @author 彭阳
	 *   
	 * CreateDate: 2017-7-1
	 * 
	 * @param returnObject
	 * @return
	 */
	public static GeneralResponse generateSuccessResponse(Object returnObject){
		return generateResponse(Boolean.TRUE, "", "", returnObject);
	}

	/**
	 * 
	 *
	 * 方法说明：操作失败返回
	 *
	 * @author 彭阳
	 *   
	 * CreateDate: 2017-7-1
	 * 
	 * @return
	 */
	public static GeneralResponse generateFailureResponse() {
		return generateResponse(Boolean.FALSE, "", "", null);
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GeneralResponse [result=");
		builder.append(result);
		builder.append(", errorCode=");
		builder.append(errorCode);
		builder.append(", errorMessage=");
		builder.append(errorMessage);
		builder.append(", returnObject=");
		builder.append(returnObject);
		builder.append("]");
		return builder.toString();
	}

}
