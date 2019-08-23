package com.lj.business.cm.domain;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Bom.
 */
/**
 * 
 * 
 * 类说明：产品表
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 邹磊
 *   
 * CreateDate: 2017年7月12日
 */
public class Bom{
	
	/** 主键编号. */
    private String code;
    
    /** 产品名称. */
    private String bomCode;
    
    /** 产品名称. */
    private String bomName;
    
    /** 创建人. */
    private String createId;
    
    /** 创建时间. */
    private Date createDate;
    
    /** 备注. */
    private String remark;
    
    /** 备注2. */
    private String remark2;
    
    /** 备注3. */
    private String remark3;
    
    /** 备注4. */
    private String remark4;
	
	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Gets the bom code.
	 *
	 * @return the bom code
	 */
	public String getBomCode() {
		return bomCode;
	}
	
	/**
	 * Sets the bom code.
	 *
	 * @param bomCode the new bom code
	 */
	public void setBomCode(String bomCode) {
		this.bomCode = bomCode;
	}
	
	/**
	 * Gets the bom name.
	 *
	 * @return the bom name
	 */
	public String getBomName() {
		return bomName;
	}
	
	/**
	 * Sets the bom name.
	 *
	 * @param bomName the new bom name
	 */
	public void setBomName(String bomName) {
		this.bomName = bomName;
	}
	
	/**
	 * Gets the creates the id.
	 *
	 * @return the creates the id
	 */
	public String getCreateId() {
		return createId;
	}
	
	/**
	 * Sets the creates the id.
	 *
	 * @param createId the new creates the id
	 */
	public void setCreateId(String createId) {
		this.createId = createId;
	}
	
	/**
	 * Gets the creates the date.
	 *
	 * @return the creates the date
	 */
	public Date getCreateDate() {
		return createDate;
	}
	
	/**
	 * Sets the creates the date.
	 *
	 * @param createDate the new creates the date
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	/**
	 * Gets the remark.
	 *
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	
	/**
	 * Sets the remark.
	 *
	 * @param remark the new remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Gets the remark 2.
	 *
	 * @return the remark 2
	 */
	public String getRemark2() {
		return remark2;
	}
	
	/**
	 * Sets the remark 2.
	 *
	 * @param remark2 the new remark 2
	 */
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	
	/**
	 * Gets the remark 3.
	 *
	 * @return the remark 3
	 */
	public String getRemark3() {
		return remark3;
	}
	
	/**
	 * Sets the remark 3.
	 *
	 * @param remark3 the new remark 3
	 */
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}
	
	/**
	 * Gets the remark 4.
	 *
	 * @return the remark 4
	 */
	public String getRemark4() {
		return remark4;
	}
	
	/**
	 * Sets the remark 4.
	 *
	 * @param remark4 the new remark 4
	 */
	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Bom [code=").append(code).append(", bomCode=")
				.append(bomCode).append(", bomName=").append(bomName)
				.append(", createId=").append(createId).append(", createDate=")
				.append(createDate).append(", remark=").append(remark)
				.append(", remark2=").append(remark2).append(", remark3=")
				.append(remark3).append(", remark4=").append(remark4)
				.append("]");
		return builder.toString();
	}
}