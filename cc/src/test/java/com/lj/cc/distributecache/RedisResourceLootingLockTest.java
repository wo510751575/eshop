package com.lj.cc.distributecache;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市杨恩科技 License, Version 1.0 (the "License");
 * 
 */
import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.lj.distributecache.RedisCache;
import com.lj.distributelock.IResourceLootingLock;
import com.lj.distributelock.RedisResourceLootingLock;
import com.lj.distributelock.ResourceLootingReturnVO;

/**
 * *
 * redis 清理：redis-cli命令
 * del TIMESSHARING_RESOURCE_LOOTING_IDXperformanceTestResourmanceTestResource TIMESSHARING_RESOURCE_LOOTING_IDXmaps.
 * @deprecated  该测试类在REDIS3/4的版本下有问题，请使用其他测试类如：RedisPool RedisTest TestRedis
 * @author 彭阳
 */
public class RedisResourceLootingLockTest implements Runnable{
	
	/** The Constant LOCK_NAME. */
	private static  final String LOCK_NAME = "performanceTestResource";
	
	/** The Constant MAX_RESOURCE_VALUE. */
	private static  final long MAX_RESOURCE_VALUE  = 10000;//10000000l;//1000w
	
	/** The Constant RESOURCE_TIMEOUT. */
	private static final long RESOURCE_TIMEOUT = 30000;//30s
	
	/** The Constant MAX_SINGLE_LOOT_RESOUECE. */
	private static final int MAX_SINGLE_LOOT_RESOUECE = 500;//单次最大抢的金额 [1-MAX_SINGLE_LOOT_RESOUECE]随机 
	
	/** The resource looting lock. */
	private IResourceLootingLock resourceLootingLock ;
	
	/**
	 * The Constructor.
	 */
	public RedisResourceLootingLockTest(){
		//redis config
		RedisCache redisCache = new RedisCache();
		redisCache.setRedisPort(6379);
		redisCache.setRedisServer("192.168.6.63");
		redisCache.setTimeout(1000);
		//resource loot lock config
		RedisResourceLootingLock  redisLootingLock = new RedisResourceLootingLock();
		redisLootingLock.setRedisCache(redisCache);
		redisLootingLock.setResourceLootingCntMap(LOCK_NAME, MAX_RESOURCE_VALUE, RESOURCE_TIMEOUT);
		//
		this.resourceLootingLock  =  redisLootingLock;
	}
	 
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		Random rnd = new Random(System.currentTimeMillis());
		int applyResource = 1+rnd.nextInt(MAX_SINGLE_LOOT_RESOUECE);
		applyResource = 1;
		ResourceLootingReturnVO vo = resourceLootingLock.getLockNoWait(LOCK_NAME, applyResource);
		if(vo.getAppliedResource() == 0){
			System.out.println("sorry,not got");
			//test timeout
//			try {
//				Thread.sleep(RESOURCE_TIMEOUT);
//			} catch (InterruptedException e) { 
//			}
//			resourceLootingLock.getLockNoWait(LOCK_NAME, applyResource);
//			System.out.println("timeout test:"+vo);
		}
		else if(vo.getAppliedResource() == applyResource)
			System.out.println("congulatulations, got all:"+vo.getAppliedResource());
		else if(vo.getAppliedResource() < applyResource){
			System.out.println("ok, got part:"+vo.getAppliedResource()+" wanted:"+vo.getApplyResource());
//			resourceLootingLock.confirmPartResource(LOCK_NAME, vo);
			//test timeout
			try {
				Thread.sleep(RESOURCE_TIMEOUT);
			} catch (InterruptedException e) { 
				e.printStackTrace();
			}
			System.out.println("timeout not confirmed:"+resourceLootingLock.getLockNoWait(LOCK_NAME, applyResource));
		}
	}
	
	/**
	 * Main1.
	 *
	 * @param args the args
	 */
	public static void main1(String []args){		
		RedisResourceLootingLockTest test = new RedisResourceLootingLockTest();
		test.run();
	}
	
	/**
	 * The main method.
	 *
	 * @param args the args
	 */
	public static void main(String []args){
		int threadSize = 1;
		List<Thread> threads = new ArrayList<Thread>();
		 for(int i=0;i<threadSize;i++){
			 Thread t = new Thread(new RedisResourceLootingLockTest());
			 t.start(); 
			 threads.add(t);//保存实例
		 }
		 //current thread sleep to wait all thread end.
		 boolean hasAlived = true;
		 while(hasAlived){					
				try {	
					 Thread.sleep(1000*60);//1minute  report status					 
					} catch (InterruptedException e) { 
						e.printStackTrace();
					}
				int ended = 0;
				 for(int i=0;i<threadSize;i++){
					 if(  threads.get(i).getState().equals(State.TERMINATED)) ended++;
					 
				 }
				 System.out.println("now alived:"+(threadSize-ended)+" end:"+ended);
				 if(ended ==threadSize  )
					 hasAlived = false;//
		
		 }
		 System.out.println("now all finished");
	}

}
