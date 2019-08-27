package com.lj.cc.distributecache;

import javax.annotation.Resource;

import org.junit.Test;

import com.lj.base.mvc.web.test.SpringTestCase;
import com.lj.distributecache.IDistributeCache;
import com.lj.distributecache.RedisCache;

public class RedisTest extends SpringTestCase{

	@Resource 
	private IDistributeCache distributeCache;
	
	@Resource 
	private RedisCache redisCache;
	
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
		distributeCache.set("test", "123456");
    }
	
	@Test
	public void testHashMap() {
		final String KEY = "hashMapRedisTest";
		redisCache.hset(KEY, "field1", "value1");
		redisCache.hset(KEY, "field2", "value2");
		System.out.println(redisCache.hget(KEY, "field1"));
		System.out.println(redisCache.hgetAll(KEY));
		System.out.println(redisCache.hlen(KEY));
		System.out.println(redisCache.hdel(KEY, "field1"));
	}

}
