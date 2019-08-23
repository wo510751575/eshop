package com.lj.business.member.dto;

import java.util.Date;

import com.lj.base.core.pagination.PageParamEntity;

/**
 * The Class FindInterestPmPageDto.
 */
public class FindInterestPmPageDto extends PageParamEntity{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6428184491130888355L;
		
		/** The code. */
		private String code;//唯一code
	    
    	/** The merchant no. */
    	private String merchantNo;//会员号
	    
    	/** The name. */
    	private String name;//名称
	    
    	/** The remark. */
    	private String remark;//备注
	    
    	/** The create date. */
    	private Date createDate;//创建时间
		
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
		 * Gets the merchant no.
		 *
		 * @return the merchant no
		 */
		public String getMerchantNo() {
			return merchantNo;
		}
		
		/**
		 * Sets the merchant no.
		 *
		 * @param merchantNo the merchant no
		 */
		public void setMerchantNo(String merchantNo) {
			this.merchantNo = merchantNo;
		}
		
		/**
		 * Gets the name.
		 *
		 * @return the name
		 */
		public String getName() {
			return name;
		}
		
		/**
		 * Sets the name.
		 *
		 * @param name the name
		 */
		public void setName(String name) {
			this.name = name;
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
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "InterestPm [code=" + code + ", merchantNo=" + merchantNo
					+ ", name=" + name + ", remark=" + remark + ", createDate="
					+ createDate + "]";
		}
}
