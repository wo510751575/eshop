package com.lj.eshop.eis.dto;


/**
 * 类说明：
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @Company: 深圳扬恩科技有限公司
 * @author 彭阳
 * 
 * CreateDate: 2017年7月1日
 */
public class MobileVersionDto {
	
	/** * 是否需要更新. */
	private boolean needUpdate;
	
	/** * 更新地址. */
	private String updateUrl;
	
	/** * 服务器最新版本号. */
	private String serverVersion;

	/** * 是否强制更新. */
	private boolean forceUpdate;
	
	/** * 更新文件大小. */
	private String fileSize;
	
	/** * 更新说明. */
	private String updateRemark;
	
	/** * 微信更新地址. */
	private String wxUpdateUrl;
	
	/**
	 * 当前客户端功能列表，且判断所有功能是否支持当前客户端版本.
	 *
	 * @return the * 是否强制更新
	 */
//	Map<String, Boolean> functionMap;

	/**
	 * Checks if is force update.
	 *
	 * @return true, if is force update
	 */
	public boolean isForceUpdate() {
		return forceUpdate;
	}

	/**
	 * Sets the force update.
	 *
	 * @param isForceUpdate the new force update
	 */
	public void setForceUpdate(boolean isForceUpdate) {
		this.forceUpdate = isForceUpdate;
	}

	/**
	 * Checks if is * 是否需要更新.
	 *
	 * @return the * 是否需要更新
	 */
	public boolean isNeedUpdate() {
		return needUpdate;
	}

	/**
	 * Sets the * 是否需要更新.
	 *
	 * @param needUpdate the new * 是否需要更新
	 */
	public void setNeedUpdate(boolean needUpdate) {
		this.needUpdate = needUpdate;
	}

	/**
	 * Gets the * 更新地址.
	 *
	 * @return the * 更新地址
	 */
	public String getUpdateUrl() {
		return updateUrl;
	}

	/**
	 * Sets the * 更新地址.
	 *
	 * @param updateUrl the new * 更新地址
	 */
	public void setUpdateUrl(String updateUrl) {
		this.updateUrl = updateUrl;
	}

	/**
	 * Gets the * 服务器最新版本号.
	 *
	 * @return the * 服务器最新版本号
	 */
	public String getServerVersion() {
		return serverVersion;
	}

	/**
	 * Sets the * 服务器最新版本号.
	 *
	 * @param serverVersion the new * 服务器最新版本号
	 */
	public void setServerVersion(String serverVersion) {
		this.serverVersion = serverVersion;
	}

	/**
	 * Gets the * 更新文件大小.
	 *
	 * @return the * 更新文件大小
	 */
	public String getFileSize() {
		return fileSize;
	}

	/**
	 * Sets the * 更新文件大小.
	 *
	 * @param fileSize the new * 更新文件大小
	 */
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * Gets the * 更新说明.
	 *
	 * @return the * 更新说明
	 */
	public String getUpdateRemark() {
		return updateRemark;
	}

	/**
	 * Sets the * 更新说明.
	 *
	 * @param updateRemark the new * 更新说明
	 */
	public void setUpdateRemark(String updateRemark) {
		this.updateRemark = updateRemark;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MobileVersion [needUpdate=").append(needUpdate)
				.append(", updateUrl=").append(updateUrl)
				.append(", serverVersion=").append(serverVersion)
				.append(", forceUpdate=").append(forceUpdate)
				.append(", fileSize=").append(fileSize)
				.append(", updateRemark=").append(updateRemark)
				.append(", wxUpdateUrl=").append(wxUpdateUrl).append("]");
		return builder.toString();
	}

	/**
	 * Gets the * 微信更新地址.
	 *
	 * @return the * 微信更新地址
	 */
	public String getWxUpdateUrl() {
		return wxUpdateUrl;
	}

	/**
	 * Sets the * 微信更新地址.
	 *
	 * @param wxUpdateUrl the new * 微信更新地址
	 */
	public void setWxUpdateUrl(String wxUpdateUrl) {
		this.wxUpdateUrl = wxUpdateUrl;
	}
}
