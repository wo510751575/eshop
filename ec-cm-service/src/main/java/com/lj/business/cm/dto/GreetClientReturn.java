package com.lj.business.cm.dto;

import java.io.Serializable;
import java.util.Date;

import com.lj.business.cm.emus.SendType;

public class GreetClientReturn implements Serializable{

	 /**
	     * Generate cron.
	     *
	     * @param
	     * @param
	     * @throws 
	     */
	private static final long serialVersionUID = -7609849286014975582L;
	

    /**
     * 消息标题 .
     */
    private String title;

    /**
     * 发送类型
             SINGLE：单人
             MULTI：多人 暂作废
             ALL：所有人 .
     */
    private SendType sendType;
    
    /**
     * 消息内容 .
     */
    private String content;


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public SendType getSendType() {
		return sendType;
	}

	public void setSendType(SendType sendType) {
		this.sendType = sendType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GreetClientReturn [title=").append(title)
				.append(", sendType=").append(sendType).append(", content=")
				.append(content).append("]");
		return builder.toString();
	}
}
