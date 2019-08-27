package com.lj.cc.service.impl;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import com.lj.cc.clientintf.IJob;
import com.lj.cc.domain.SystemInfo;
import com.lj.cc.service.IHolidayService;
import com.lj.cc.service.ISystemInfoService;
import com.lj.base.mvc.remote.hession.HessianInvoke;

/****
 * hessian直接调用
 * 但业务系统使用需要用
 * 
   <!-- 客户端Hessian代理工厂Bean -->   
   <bean id="clientSpring" class="org.springframework.remoting.caucho.HessianProxyFactoryBean">   
         <!-- 请求代理Servlet路径 -->           
         <property name="serviceUrl">  
              <value>http://localhost:8080/HessianSpring/remote/helloSpring</value>   
         </property>
         <!-- 接口定义 -->   
         <property name="serviceInterface">   
             <value>com.wtang.isay.Isay</value>  
         </property>
     </bean> 
     
 * @author 彭阳
 *
 */
public class HessianTest {
	private static final String HESSIAN_URL = "http://localhost:8080/cc/hessian";
    
    /**
     * The main method.
     *
     * @param args the args
     */
    public static void main(String []args){
    	callHolidayInfo();
    }
    
    
    
    /**
     * Call execute system info.
     */
    public static void callExecuteSystemInfo(){
    	HessianInvoke hi = new HessianInvoke(HESSIAN_URL);
    	ISystemInfoService isis = (ISystemInfoService) hi.getImpl(ISystemInfoService.class,"systemInfoService");
    	SystemInfo si = isis.findSystemInfo("cc");
    	System.out.println(si);
    }
    
    /**
     * Call execute system info.
     */
    public static void callHolidayInfo(){
    	HessianInvoke hi = new HessianInvoke(HESSIAN_URL);
    	IHolidayService isis = (IHolidayService) hi.getImpl(IHolidayService.class,"holidayService");
    	
    	System.out.println(isis.findDayType_str("20170206"));
    }
}
