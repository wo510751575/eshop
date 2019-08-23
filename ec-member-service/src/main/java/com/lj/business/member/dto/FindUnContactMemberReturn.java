package com.lj.business.member.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 类说明：查询客户提醒
 * <p>
 * <p>
 * <p>
 * 详细描述：
 *
 * @author 武鹏飞
 * <p>
 * CreateDate: 2017年7月22日
 * @Company: 领居科技有限公司
 */
public class FindUnContactMemberReturn implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 5278547443592756621L;

    /**
     * 会员号 .
     */
    private String memberNo;

    /**
     * 会员名称 .
     */
    private String memberName;

    /**
     * 会员图像
     */
    private String imgAddr;

    /**
     * 微信号
     */
    private String noWx;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 动态描述
     */
    private String behaviorDesc;

    /**
     * 行为时间
     */
    private Date behaviorDate;

    /**
     * 昵称备注_微信
     */
    private String nickNameRemarkWx;
    /**
     * 昵称备注_本地
     */
    private String nickNameRemarkLocal;
    

    /**
     * 昵称_微信
     */
    private String nickNameWx;

    
    
    
    @Override
	public String toString() {
		return "FindUnContactMemberReturn [memberNo=" + memberNo
				+ ", memberName=" + memberName + ", imgAddr=" + imgAddr
				+ ", noWx=" + noWx + ", mobile=" + mobile + ", behaviorDesc="
				+ behaviorDesc + ", behaviorDate=" + behaviorDate
				+ ", nickNameRemarkWx=" + nickNameRemarkWx
				+ ", nickNameRemarkLocal=" + nickNameRemarkLocal
				+ ", nickNameWx=" + nickNameWx + "]";
	}

	public String getNickNameRemarkLocal() {
		return nickNameRemarkLocal;
	}

	public void setNickNameRemarkLocal(String nickNameRemarkLocal) {
		this.nickNameRemarkLocal = nickNameRemarkLocal;
	}

	public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getImgAddr() {
        return imgAddr;
    }

    public void setImgAddr(String imgAddr) {
        this.imgAddr = imgAddr;
    }

    public String getNoWx() {
        return noWx;
    }

    public void setNoWx(String noWx) {
        this.noWx = noWx;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBehaviorDesc() {
        return behaviorDesc;
    }

    public void setBehaviorDesc(String behaviorDesc) {
        this.behaviorDesc = behaviorDesc;
    }

    public Date getBehaviorDate() {
        return behaviorDate;
    }

    public void setBehaviorDate(Date behaviorDate) {
        this.behaviorDate = behaviorDate;
    }

    public String getNickNameRemarkWx() {
        return nickNameRemarkWx;
    }

    public void setNickNameRemarkWx(String nickNameRemarkWx) {
        this.nickNameRemarkWx = nickNameRemarkWx;
    }

    public String getNickNameWx() {
        return nickNameWx;
    }

    public void setNickNameWx(String nickNameWx) {
        this.nickNameWx = nickNameWx;
    }
}
