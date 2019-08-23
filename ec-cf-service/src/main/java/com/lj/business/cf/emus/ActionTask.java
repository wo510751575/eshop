package com.lj.business.cf.emus;

/**
 * 
 * 
 * 类说明：任务动作
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 领居科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月25日
 */
public enum ActionTask {
	
	
	/**
	 * 去评论
	 */
	COMMENTING("去评论"),
	/**
	 * 已评论
	 */
	COMMENTED("已评论"),
	/**
	 * 去回复
	 */
	REPLY("去回复"),
	;
	
	ActionTask(String name){
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
