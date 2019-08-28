package com.lj.business.weixin.service.impl;

import javax.annotation.Resource;

import org.junit.Test;

import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.distributecache.IDistributeCache;
import com.lj.distributecache.RedisCache;
import com.lj.distributelock.RedisResourceLootingLock;

public class RedisTest extends SpringTestCase{

	@Resource 
	private IDistributeCache distributeCache;
	
	
	public static void main(String args []){
		RedisCache redisCache = new RedisCache();
		redisCache.setRedisPort(6379);
		redisCache.setRedisServer("192.168.6.60");
		redisCache.setTimeout(1000);
		redisCache.set("test", "1234");
	}

	@Test
	public void redisCacheTest(){
    	/*RedisCache redisCache = new RedisCache();
		redisCache.setRedisPort(6379);
		redisCache.setRedisServer("192.168.6.63");
		redisCache.setTimeout(1000);
		redisCache.set("test", "1234");*/
		for (int i = 0; i < 1000; i++) {
			distributeCache.set("test_" + i, "test_valuet_" + i);
			//distributeCache.set("test", "1234567");
			System.out.println(distributeCache.get("test_" + i));
		}
		
    }

}
