package com.lj.business.cm.domain;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Material.
 */
/**
 * 
 * 
 * 类说明：素材中心表
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
public class Material {
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
     * 类型ID .
     */
    private String materialTypeCode;

    /**
     * 类型名称 .
     */
    private String materialTypeName;

    /**
     * 标题 .
     */
    private String title;

    /**
     * 内容 .
     */
    private String content;
    
    /**
     * 简介 .
     */
    private String brief;

    /**
     * 图片地址 .
     */
    private String imgAddr;
    
    /**
     * 回应量 .
     */
    private int respondNum;

    /**
     * 创建人 .
     */
    private String createId;

    /**
     * 创建时间 .
     */
    private Date createDate;
    
    /** 网址链接. */
    private String linkUrl;
    
    /** The remark. */
    private String remark;
    
    /** The remark. */
    private String remark2;
    
    /** The remark. */
    private String remark3;
    
    /** The remark. */
    private String remark4;
    
    
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
	 * @param linkUrl the new link url
	 */
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	/**
     * CODE .
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * CODE .
     *
     * @param code the new code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 商户编号 .
     *
     * @return the merchant no
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 商户编号 .
     *
     * @param merchantNo the new merchant no
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * 导购编号  .
     *
     * @return the member no gm
     */
    public String getMemberNoGm() {
        return memberNoGm;
    }

    /**
     * 导购编号  .
     *
     * @param memberNoGm the new member no gm
     */
    public void setMemberNoGm(String memberNoGm) {
        this.memberNoGm = memberNoGm == null ? null : memberNoGm.trim();
    }

    /**
     * 导购姓名 .
     *
     * @return the member name gm
     */
    public String getMemberNameGm() {
        return memberNameGm;
    }

    /**
     * 导购姓名 .
     *
     * @param memberNameGm the new member name gm
     */
    public void setMemberNameGm(String memberNameGm) {
        this.memberNameGm = memberNameGm == null ? null : memberNameGm.trim();
    }

    /**
     * 类型ID .
     *
     * @return the material type code
     */
    public String getMaterialTypeCode() {
        return materialTypeCode;
    }

    /**
     * 类型ID .
     *
     * @param materialTypeCode the new material type code
     */
    public void setMaterialTypeCode(String materialTypeCode) {
        this.materialTypeCode = materialTypeCode == null ? null : materialTypeCode.trim();
    }

    /**
     * 类型名称 .
     *
     * @return the material type name
     */
    public String getMaterialTypeName() {
        return materialTypeName;
    }

    /**
     * 类型名称 .
     *
     * @param materialTypeName the new material type name
     */
    public void setMaterialTypeName(String materialTypeName) {
        this.materialTypeName = materialTypeName == null ? null : materialTypeName.trim();
    }

    /**
     * 标题 .
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题 .
     *
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 内容 .
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容 .
     *
     * @param content the new content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 图片地址 .
     *
     * @return the img addr
     */
    public String getImgAddr() {
        return imgAddr;
    }

    /**
     * 图片地址 .
     *
     * @param imgAddr the new img addr
     */
    public void setImgAddr(String imgAddr) {
        this.imgAddr = imgAddr == null ? null : imgAddr.trim();
    }

    /**
     * Gets the respond num.
     *
     * @return the respond num
     */
    public int getRespondNum() {
		return respondNum;
	}

	/**
	 * Sets the respond num.
	 *
	 * @param respondNum the new respond num
	 */
	public void setRespondNum(int respondNum) {
		this.respondNum = respondNum;
	}

	/**
     * 创建人 .
     *
     * @return the creates the id
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 创建人 .
     *
     * @param createId the new creates the id
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    /**
     * 创建时间 .
     *
     * @return the creates the date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间 .
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
		builder.append("Material [code=").append(code).append(", merchantNo=")
				.append(merchantNo).append(", memberNoGm=").append(memberNoGm)
				.append(", memberNameGm=").append(memberNameGm)
				.append(", materialTypeCode=").append(materialTypeCode)
				.append(", materialTypeName=").append(materialTypeName)
				.append(", title=").append(title).append(", content=")
				.append(content).append(", brief=").append(brief)
				.append(", imgAddr=").append(imgAddr).append(", respondNum=")
				.append(respondNum).append(", createId=").append(createId)
				.append(", createDate=").append(createDate)
				.append(", linkUrl=").append(linkUrl).append(", remark=")
				.append(remark).append(", remark2=").append(remark2)
				.append(", remark3=").append(remark3).append(", remark4=")
				.append(remark4).append("]");
		return builder.toString();
	}

	/**
	 * Gets the 简介 .
	 *
	 * @return the 简介 
	 */
	public String getBrief() {
		return brief;
	}

	/**
	 * Sets the 简介 .
	 *
	 * @param brief the new 简介 
	 */
	public void setBrief(String brief) {
		this.brief = brief;
	}

}