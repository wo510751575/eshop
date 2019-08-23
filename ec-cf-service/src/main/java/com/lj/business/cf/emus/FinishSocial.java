package com.lj.business.cf.emus;

/**
 * 
 * 
 * 类说明：工作完成状态
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 冯辉
 *   
 * CreateDate: 2017年7月14日
 */
public enum FinishSocial {
	
	ING("评论中"),
	Y("已完成"),
	N("去评论")
	;
	
	FinishSocial(String name){
		this.name = name;
	}
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
