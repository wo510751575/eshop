package com.lj.eshop.dto;

import java.io.Serializable;
import java.util.Date;

public class MessageDto implements Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = -5318195198296424567L;

	/** 自增长ID*/
    private String code;

    /** 消息类型： 0、系统消息 1、通知*/
    private String type;

    /** 标题*/
    private String title;

    /** 发送者CODE*/
    private String sender;

    /** 接受者CODE*/
    private String recevier;

    /** 0、未读 1、已读*/
    private String isRead;

    /** 修改时间*/
    private Date updateTime;

    /** 创建时间*/
    private Date createTime;

    /** 删除标记*/
    private String senderDel;

    /** 删除标记*/
    private String recevierDel;

    /** 业务类型*/
    private String bizType;

    /** 业务编码*/
    private String bizCode;

    /** 店铺编号*/
    private String shopCode;

    /** 消息内容*/
    private String content;
    
    
    
//    未付款订单 内容：您的客户xxx(客户昵称)提交了一笔未付款的订单。买家：苏阳，金额：756.00元，商品：HELLO KITTY，订单编号：3232145444。
    //临时变量
    /** 昵稱*/
    private String cClientName; 
    /** 收貨人名稱*/
    private String cClientReceiveName; 
    /** 金额*/
    private String cClientMoney;
    /** 商品*/
    private String cClientCommodity;
    /** 订单编号*/
    private String cClientOrderNo;
    /** 客户手机号*/
    private String cClientMobilePhone;
    
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender == null ? null : sender.trim();
    }

    public String getRecevier() {
        return recevier;
    }

    public void setRecevier(String recevier) {
        this.recevier = recevier == null ? null : recevier.trim();
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead == null ? null : isRead.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSenderDel() {
        return senderDel;
    }

    public void setSenderDel(String senderDel) {
        this.senderDel = senderDel == null ? null : senderDel.trim();
    }

    public String getRecevierDel() {
        return recevierDel;
    }

    public void setRecevierDel(String recevierDel) {
        this.recevierDel = recevierDel == null ? null : recevierDel.trim();
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType == null ? null : bizType.trim();
    }

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode == null ? null : bizCode.trim();
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode == null ? null : shopCode.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	public String getcClientName() {
		return cClientName;
	}

	public void setcClientName(String cClientName) {
		this.cClientName = cClientName;
	}

	public String getcClientReceiveName() {
		return cClientReceiveName;
	}

	public void setcClientReceiveName(String cClientReceiveName) {
		this.cClientReceiveName = cClientReceiveName;
	}

	public String getcClientMoney() {
		return cClientMoney;
	}

	public void setcClientMoney(String cClientMoney) {
		this.cClientMoney = cClientMoney;
	}

	public String getcClientCommodity() {
		return cClientCommodity;
	}

	public void setcClientCommodity(String cClientCommodity) {
		this.cClientCommodity = cClientCommodity;
	}

	public String getcClientOrderNo() {
		return cClientOrderNo;
	}

	public void setcClientOrderNo(String cClientBillCode) {
		this.cClientOrderNo = cClientBillCode;
	}

	public String getcClientMobilePhone() {
		return cClientMobilePhone;
	}

	public void setcClientMobilePhone(String cClientMobilePhone) {
		this.cClientMobilePhone = cClientMobilePhone;
	}

	
    
    
}
