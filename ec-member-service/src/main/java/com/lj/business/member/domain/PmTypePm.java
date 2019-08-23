package com.lj.business.member.domain;

import java.util.Date;
// TODO: Auto-generated Javadoc

/**
 * 类说明：客户分类关联表
 *  
 * 
 * <p>
 * 详细描述：
 *   
 *
 * @author 邹磊
 *   
 * CreateDate: 2017年7月12日
 * @Company: 领居科技有限公司
 */
public class PmTypePm {
    /**
     * CODE .
     */
    private String code;

    /**
     * 客户表CODE .
     */
    private String codePm;

    /**
     * 客户分类CODE .
     */
    private String pmTypeCode;

    /**
     * 创建时间 .
     */
    private Date createDate;

    /**
     * 备注 .
     */
    private String remark;

    /**
     * 备注 .
     */
    private String remark2;

    /**
     * 备注 .
     */
    private String remark3;

    /**
     * 备注 .
     */
    private String remark4;

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
     * 客户表CODE .
     *
     * @return the code pm
     */
    public String getCodePm() {
        return codePm;
    }

    /**
     * 客户表CODE .
     *
     * @param codePm the new code pm
     */
    public void setCodePm(String codePm) {
        this.codePm = codePm == null ? null : codePm.trim();
    }

    /**
     * 客户分类CODE .
     *
     * @return the pm type code
     */
    public String getPmTypeCode() {
        return pmTypeCode;
    }

    /**
     * 客户分类CODE .
     *
     * @param pmTypeCode the new pm type code
     */
    public void setPmTypeCode(String pmTypeCode) {
        this.pmTypeCode = pmTypeCode == null ? null : pmTypeCode.trim();
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
     * 备注 .
     *
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注 .
     *
     * @param remark the new remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 备注 .
     *
     * @return the remark 2
     */
    public String getRemark2() {
        return remark2;
    }

    /**
     * 备注 .
     *
     * @param remark2 the new remark 2
     */
    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    /**
     * 备注 .
     *
     * @return the remark 3
     */
    public String getRemark3() {
        return remark3;
    }

    /**
     * 备注 .
     *
     * @param remark3 the new remark 3
     */
    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    /**
     * 备注 .
     *
     * @return the remark 4
     */
    public String getRemark4() {
        return remark4;
    }

    /**
     * 备注 .
     *
     * @param remark4 the new remark 4
     */
    public void setRemark4(String remark4) {
        this.remark4 = remark4 == null ? null : remark4.trim();
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
		builder.append("PmTypePm [code=").append(code).append(", codePm=")
				.append(codePm).append(", pmTypeCode=").append(pmTypeCode)
				.append(", createDate=").append(createDate).append(", remark=")
				.append(remark).append(", remark2=").append(remark2)
				.append(", remark3=").append(remark3).append(", remark4=")
				.append(remark4).append("]");
		return builder.toString();
	}
}