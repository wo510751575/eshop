package com.lj.eshop.eis.redis.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

/**
 * 
 * 
 * 类说明：主从。
 *  
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月2日
 */
public class RedisClientSentinelImpl extends RedisCommands<JedisSentinelPool, Jedis> {

	private static Logger logger = LoggerFactory.getLogger(RedisClientSentinelImpl.class);
	
	@Autowired
	JedisSentinelPool pool;

	public RedisClientSentinelImpl() {
	}

	@Override
	public void initPool() {
		logger.info("initPool ...");
		this.setRedisPool(pool);
		
	}
	@Override
    public Jedis getJedis(){
    	if(getRedisPool()==null) {
    		initPool();
    	}
    	return (Jedis) getRedisPool().getResource();
    }
	
}
