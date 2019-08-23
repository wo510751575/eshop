package com.lj.eshop.eis.redis;

import redis.clients.jedis.BasicCommands;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCommands;
import redis.clients.jedis.MultiKeyCommands;
import redis.clients.util.Pool;

//public interface RedisClient extends JedisCommands, MultiKeyCommands,
//		AdvancedJedisCommands, ScriptingCommands, BasicCommands,
//		ClusterCommands {

public interface RedisClient<R extends Jedis> extends JedisCommands, MultiKeyCommands, BasicCommands{
	/**
	 * 获取一个jedis 客户端
	 * 
	 * @return
	 */
	public R getJedis() ;
	public void returnResource(Jedis jedis);
	public void returnBrokeRedis(Jedis jedis);

}