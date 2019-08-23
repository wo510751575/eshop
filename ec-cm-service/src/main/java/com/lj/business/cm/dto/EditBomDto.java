package com.lj.business.cm.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * The Class EditBomDto.
 */
public class EditBomDto implements Serializable{
	
		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = 5778507816737307566L;
		
	    /** The code. */
    	private String code;	//主键编号
	    
    	/** The bom code. */
    	private String bomCode;	//产品编号
	    
    	/** The bom name. */
    	private String bomName;	//产品名称
	    
    	/** The create id. */
    	private String createId;//创建人
	    
    	/** The create date. */
    	private Date createDate;//创建时间
	    
    	/** The remark. */
    	private String remark;	//备注
	    
    	/** The remark2. */
    	private String remark2;	//备注2
	    
    	/** The remark3. */
    	private String remark3;	//备注3
	    
    	/** The remark4. */
    	private String remark4;	//备注4
		
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
		 * @param code the code
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
		 * @param bomCode the bom code
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
		 * @param bomName the bom name
		 */
		public void setBomName(String bomName) {
			this.bomName = bomName;
		}
		
		/**
		 * Gets the create id.
		 *
		 * @return the creates the id
		 */
		public String getCreateId() {
			return createId;
		}
		
		/**
		 * Sets the create id.
		 *
		 * @param createId the creates the id
		 */
		public void setCreateId(String createId) {
			this.createId = createId;
		}
		
		/**
		 * Gets the create date.
		 *
		 * @return the creates the date
		 */
		public Date getCreateDate() {
			return createDate;
		}
		
		/**
		 * Sets the create date.
		 *
		 * @param createDate the creates the date
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
		 * @param remark the remark
		 */
		public void setRemark(String remark) {
			this.remark = remark;
		}
		
		/**
		 * Gets the remark2.
		 *
		 * @return the remark2
		 */
		public String getRemark2() {
			return remark2;
		}
		
		/**
		 * Sets the remark2.
		 *
		 * @param remark2 the remark2
		 */
		public void setRemark2(String remark2) {
			this.remark2 = remark2;
		}
		
		/**
		 * Gets the remark3.
		 *
		 * @return the remark3
		 */
		public String getRemark3() {
			return remark3;
		}
		
		/**
		 * Sets the remark3.
		 *
		 * @param remark3 the remark3
		 */
		public void setRemark3(String remark3) {
			this.remark3 = remark3;
		}
		
		/**
		 * Gets the remark4.
		 *
		 * @return the remark4
		 */
		public String getRemark4() {
			return remark4;
		}
		
		/**
		 * Sets the remark4.
		 *
		 * @param remark4 the remark4
		 */
		public void setRemark4(String remark4) {
			this.remark4 = remark4;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Bom [code=" + code + ", bomCode=" + bomCode + ", bomName="
					+ bomName + ", createId=" + createId + ", createDate="
					+ createDate + ", remark=" + remark + ", remark2=" + remark2
					+ ", remark3=" + remark3 + ", remark4=" + remark4 + "]";
		}
	    
	    
}
