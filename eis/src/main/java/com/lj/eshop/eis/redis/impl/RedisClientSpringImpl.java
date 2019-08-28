package com.lj.eshop.eis.redis.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月2日
 */
public class RedisClientSpringImpl extends RedisCommands<JedisPool, Jedis> {

	
	@Autowired
	JedisPool pool;
    
	public RedisClientSpringImpl() {
	}

	@Override
	public void initPool() {
		this.setRedisPool(pool);
		
	}
	@Override
    public Jedis getJedis(){
    	if(getRedisPool()==null) {
    		initPool();
    	}
    	return (Jedis)getRedisPool().getResource();
    }
   
}
