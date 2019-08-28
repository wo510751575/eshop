package com.lj.eshop.eis.redis.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.util.Pool;

/**
 * 
 * 类说明：AbstractRedistClient
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 *   
 * CreateDate: 2017年9月2日
 */

@SuppressWarnings("rawtypes")
public abstract class AbstractRedisClient<T extends Pool, R extends Jedis> {

	private static Logger logger = LoggerFactory
			.getLogger(AbstractRedisClient.class);
	ThreadLocal<T> redisPool = new ThreadLocal<T>();

	abstract public void initPool();

	public T getRedisPool() {
		logger.info("Get Redis Pool Instant:{}", redisPool.get());
		return redisPool.get();
	}

	public void setRedisPool(T pool) {
		logger.info("Set Redis Pool Instant:{}", pool);
		redisPool.set(pool);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public void returnResource(Jedis jedis) {
		// try {
		logger.info("Get Redis Pool Instant (returnResource):{}",
				redisPool.get());
		if (jedis != null) {
//			redisPool.get().returnResource(jedis);
			jedis.close();
		}
		// } catch (Exception e) {
		// if (jedis != null) {
		// redisPool.get().returnBrokenResource(jedis);
		// }
		// }

	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public void returnBrokeRedis(Jedis jedis) {
		// TODO: pending
		// try {
		logger.info("Get Redis Pool Instant (returnResource):{}",
				redisPool.get());
		if (jedis != null) {
//			redisPool.get().returnResource(jedis);
			jedis.close();
		}
		// } catch (Exception e) {
		// if (jedis != null) {
		// redisPool.get().returnBrokenResource(jedis);
		// }
		// }

	}

	/**
	 * 获取一个jedis 客户端
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public R getJedis() {
		return (R) redisPool.get().getResource();
	}


}
