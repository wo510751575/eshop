package com.lj.eshop.dto;

/**
 * 
 * 类说明：
 * 	分类统计
 * <p>
 * @Company: 领居科技有限公司
 * @author 林进权
 * 
 *         CreateDate: 2017年9月13日
 */
public class CatalogSummaryDto {
	//商品分类code
	private String cataLogCode;
	//父类商品分类code
	private String parentCataLogCode;
	//数量
	private int cnt;
	public String getCataLogCode() {
		return cataLogCode;
	}
	public void setCataLogCode(String cataLogCode) {
		this.cataLogCode = cataLogCode;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public void setCnt(String cnt) {
		if(null!=cnt && cnt.length()>0) {
			this.cnt = Integer.valueOf(cnt);
		}
	}
	public void addCnt(String cnt) {
		if(null!=cnt && cnt.length()>0) {
			addCnt(Integer.valueOf(cnt));
		}
	}
	public void addCnt(int cnt) {
		this.cnt += this.cnt + cnt;
	}
	public String getParentCataLogCode() {
		return parentCataLogCode;
	}
	public void setParentCataLogCode(String parentCataLogCode) {
		this.parentCataLogCode = parentCataLogCode;
	}
	@Override
	public String toString() {
		return "CatalogSummaryDto [cataLogCode=" + cataLogCode + ", parentCataLogCode=" + parentCataLogCode + ", cnt="
				+ cnt + "]";
	}
	
	
	
}
