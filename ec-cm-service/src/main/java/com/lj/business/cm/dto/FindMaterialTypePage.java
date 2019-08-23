package com.lj.business.cm.dto;

import java.io.Serializable;
import java.util.Date;

import com.lj.base.core.pagination.PageParamEntity; 

// TODO: Auto-generated Javadoc
/**
 * 类说明：
 * 
 * 
 * <p>
 * 详细描述：.
 *
 * @Company: 领居科技有限公司
 * @author 罗书明
 * 
 * CreateDate: 2017年6月21日
 */
public class FindMaterialTypePage extends PageParamEntity implements Serializable{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 713502206690530855L; 
    /**
     * CODE .
     */
    private String code;

    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 导购编号  .
     */
    private String memberNoGm;

    /**
     * 导购姓名 .
     */
    private String memberNameGm;

    /**
     * 类型名称 .
     */
    private String typeName;

    /**
     * 创建人 .
     */
    private String createId;
    
    /** 备注. */
    private String remark;
    

    /**
     * 创建时间 .
     */
    private Date createDate;
    
    
    /** 公用素材类型. */
    private Boolean isPublic;
    
    /** 网址链接. */
    private String  linkUrl;
    
    
    
    
    /**
     * Gets the link url.
     *
     * @return the link url
     */
    public String getLinkUrl() {
		return linkUrl;
	}

	/**
	 * Sets the link url.
	 *
	 * @param linkUrl the link url
	 */
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
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
     * Gets the 公用素材类型.
     *
     * @return the isPublic
     */
	public Boolean getIsPublic() {
		return isPublic;
	}

	/**
	 * Sets the 公用素材类型.
	 *
	 * @param isPublic the isPublic to set
	 */
	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	/**
	 * CODE .
	 *
	 * @return the cODE 
	 */
    public String getCode() {
        return code;
    }

    /**
     * CODE .
     *
     * @param code the new cODE 
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 商户编号 .
     *
     * @return the 商户编号 
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 商户编号 .
     *
     * @param merchantNo the new 商户编号 
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * 导购编号  .
     *
     * @return the 导购编号  
     */
    public String getMemberNoGm() {
        return memberNoGm;
    }

    /**
     * 导购编号  .
     *
     * @param memberNoGm the new 导购编号  
     */
    public void setMemberNoGm(String memberNoGm) {
        this.memberNoGm = memberNoGm == null ? null : memberNoGm.trim();
    }

    /**
     * 导购姓名 .
     *
     * @return the 导购姓名 
     */
    public String getMemberNameGm() {
        return memberNameGm;
    }

    /**
     * 导购姓名 .
     *
     * @param memberNameGm the new 导购姓名 
     */
    public void setMemberNameGm(String memberNameGm) {
        this.memberNameGm = memberNameGm == null ? null : memberNameGm.trim();
    }

    /**
     * 类型名称 .
     *
     * @return the 类型名称 
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 类型名称 .
     *
     * @param typeName the new 类型名称 
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * 创建人 .
     *
     * @return the 创建人 
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 创建人 .
     *
     * @param createId the new 创建人 
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    /**
     * 创建时间 .
     *
     * @return the 创建时间 
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间 .
     *
     * @param createDate the new 创建时间 
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
	public String toString() {
		return "FindMaterialTypePage [code=" + code + ", merchantNo="
				+ merchantNo + ", memberNoGm=" + memberNoGm + ", memberNameGm="
				+ memberNameGm + ", typeName=" + typeName + ", createId="
				+ createId + ", remark=" + remark + ", createDate="
				+ createDate + ", isPublic=" + isPublic + ", linkUrl="
				+ linkUrl + "]";
	}

}
