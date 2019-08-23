package com.lj.business.cm.domain;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class TextInfo.
 */
/**
 * 
 * 
 * 类说明：话术信息表
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
public class TextInfo {
    /**
     * CODE .
     */
    private String code;

    /**
     * 商户编号 .
     */
    private String merchantNo;

    /**
     * 商户名称 .
     */
    private String merchantName;

    /**
     * 话术类型 .
     */
    private String textType;

    /**
     * 话术内容 .
     */
    private String content;

    /**
     * 话术维度开始 .
     */
    private String dimStart;

    /**
     * 话术维度结束 .
     */
    private String dimEnd;

    /**
     * 话术维度关键字 .
     */
    private String dimKeyWord;

    /**
     * 创建时间 .
     */
    private Date createDate;

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
     * 商户名称 .
     *
     * @return the merchant name
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * 商户名称 .
     *
     * @param merchantName the new merchant name
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    /**
     * 话术类型 .
     *
     * @return the text type
     */
    public String getTextType() {
        return textType;
    }

    /**
     * 话术类型 .
     *
     * @param textType the new text type
     */
    public void setTextType(String textType) {
        this.textType = textType == null ? null : textType.trim();
    }

    /**
     * 话术内容 .
     *
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * 话术内容 .
     *
     * @param content the new content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 话术维度开始 .
     *
     * @return the dim start
     */
    public String getDimStart() {
        return dimStart;
    }

    /**
     * 话术维度开始 .
     *
     * @param dimStart the new dim start
     */
    public void setDimStart(String dimStart) {
        this.dimStart = dimStart == null ? null : dimStart.trim();
    }

    /**
     * 话术维度结束 .
     *
     * @return the dim end
     */
    public String getDimEnd() {
        return dimEnd;
    }

    /**
     * 话术维度结束 .
     *
     * @param dimEnd the new dim end
     */
    public void setDimEnd(String dimEnd) {
        this.dimEnd = dimEnd == null ? null : dimEnd.trim();
    }

    /**
     * 话术维度关键字 .
     *
     * @return the dim key word
     */
    public String getDimKeyWord() {
        return dimKeyWord;
    }

    /**
     * 话术维度关键字 .
     *
     * @param dimKeyWord the new dim key word
     */
    public void setDimKeyWord(String dimKeyWord) {
        this.dimKeyWord = dimKeyWord == null ? null : dimKeyWord.trim();
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
     * 输出BEAN数据信息.
     *
     * @author LeoPeng
     * @return the string
     */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TextInfo [code=").append(code).append(", merchantNo=")
				.append(merchantNo).append(", merchantName=")
				.append(merchantName).append(", textType=").append(textType)
				.append(", content=").append(content).append(", dimStart=")
				.append(dimStart).append(", dimEnd=").append(dimEnd)
				.append(", dimKeyWord=").append(dimKeyWord)
				.append(", createDate=").append(createDate).append("]");
		return builder.toString();
	}
}