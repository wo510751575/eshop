package com.lj.business.cm.dto.activity;

import java.io.Serializable;

public class UpdateActivityForReadDto implements Serializable{

	 /**
	     * Generate cron.
	     *
	     * @param
	     * @param
	     * @throws 
	     */
	private static final long serialVersionUID = -1557097773854022491L;
	
	/**
     *  网址链接.(必传)
     */
    private String linkUrl;

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UpdateActivityForReadDto [linkUrl=").append(linkUrl)
				.append("]");
		return builder.toString();
	}
}
