package com.lj.eshop.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * 
 * 类说明：商品分类DTO
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 段志鹏
 *   
 * CreateDate: 2017年8月23日
 */
public class CatalogDto implements Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = 4844718672053973927L;

	/** */
    private String code;

    /** 分类名称*/
    private String catalogName;

    /** 父分类*/
    private String parentCatalogCode;

    /** 父分类名称*/
    private String parentCatalogName;

    /** 二级分类图片*/
    private String imageUrl;

    /** 排序（数值越大越后）*/
    private Integer orderNo;

    /** 创建人*/
    private String creater;

    /** 创建时间*/
    private Date createTime;

    /** 是否删除（0未删除 1删除）*/
    private String delFlag;
    /**
     * 是否推荐（0否 1是）
     */
    private String recommend;
    
    /**
	 * @return the recommend
	 */
	public String getRecommend() {
		return recommend;
	}

	/**
	 * @param recommend the recommend to set
	 */
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName == null ? null : catalogName.trim();
    }

    public String getParentCatalogCode() {
        return parentCatalogCode;
    }

    public void setParentCatalogCode(String parentCatalogCode) {
        this.parentCatalogCode = parentCatalogCode == null ? null : parentCatalogCode.trim();
    }

    public String getParentCatalogName() {
        return parentCatalogName;
    }

    public void setParentCatalogName(String parentCatalogName) {
        this.parentCatalogName = parentCatalogName == null ? null : parentCatalogName.trim();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    /**
     * 
     *
     * 方法说明：分类顶级Code
     *
     * @return
     *
     * @author 段志鹏 CreateDate: 2017年8月24日
     *
     */
	public static String getRootId() {
		return "1";
	}
	/**
	 * 
	 *
	 * 方法说明：排序
	 *
	 * @param list
	 * @param sourcelist
	 * @param parentId
	 * @param cascade
	 *
	 * @author 段志鹏 CreateDate: 2017年8月24日
	 *
	 */
	public static void sortList(List<CatalogDto> list, List<CatalogDto> sourcelist, String parentId, boolean cascade){
		for (int i=0; i<sourcelist.size(); i++){
			CatalogDto e = sourcelist.get(i);
			if (e.getParentCatalogCode()!=null&& e.getParentCatalogCode().equals(parentId)){
				list.add(e);
				if (cascade){
					// 判断是否还有子节点, 有则继续获取子节点
					for (int j=0; j<sourcelist.size(); j++){
						CatalogDto child = sourcelist.get(j);
						if (child.getParentCatalogCode()!=null && child.getParentCatalogCode().equals(e.getCode())){
							sortList(list, sourcelist, e.getCode(), true);
							break;
						}
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		return "CatalogDto [code=" + code + ", catalogName=" + catalogName + ", parentCatalogCode=" + parentCatalogCode
				+ ", parentCatalogName=" + parentCatalogName + ", imageUrl=" + imageUrl + ", orderNo=" + orderNo
				+ ", creater=" + creater + ", createTime=" + createTime + ", delFlag=" + delFlag + ", recommend="
				+ recommend + "]";
	}
	
	
}
