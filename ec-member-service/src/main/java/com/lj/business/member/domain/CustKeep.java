package com.lj.business.member.domain;

import java.util.Date;
/**
 * 
 * 
 * 类说明：客户关注操作表
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
public class CustKeep {
    /**
     * CODE .
     */
    private String code;

    /**
     * 会员号  .
     */
    private String merchantNo;

    /**
     * 客户标签名称 .
     */
    private String memberNo;

    /**
     * 创建时间 .
     */
    private Date createDate;

    /**
     * 0：关注  1：取消关注 .
     */
    private String status;

    /**
     * CODE .
     *
     */
    public String getCode() {
        return code;
    }

    /**
     * CODE .
     *
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 会员号  .
     *
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 会员号  .
     *
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /**
     * 客户标签名称 .
     *
     */
    public String getMemberNo() {
        return memberNo;
    }

    /**
     * 客户标签名称 .
     *
     */
    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo == null ? null : memberNo.trim();
    }

    /**
     * 创建时间 .
     *
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间 .
     *
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 0：关注  1：取消关注 .
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * 0：关注  1：取消关注 .
     *
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 输出BEAN数据信息
     * @author LeoPeng
     */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustKeep [code=").append(code).append(", merchantNo=")
				.append(merchantNo).append(", memberNo=").append(memberNo)
				.append(", createDate=").append(createDate).append(", status=")
				.append(status).append("]");
		return builder.toString();
	}
}