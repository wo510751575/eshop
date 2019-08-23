package com.lj.business.cf.emus;

/**
 * 
 * 
 * 类说明：跟踪状态
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
public enum Status {
	
    NORMAL("正常"),
    
    DEAL("成单"),
    
    CHECKING("审批中"),
    
    ABANDON("放弃");
	private String name;
    
    Status(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
     
}
