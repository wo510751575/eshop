package com.lj.eshop.eis.redis.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.BitPosParams;
import redis.clients.jedis.GeoCoordinate;
import redis.clients.jedis.GeoRadiusResponse;
import redis.clients.jedis.GeoUnit;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.Tuple;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.params.geo.GeoRadiusParam;
import redis.clients.jedis.params.sortedset.ZAddParams;
import redis.clients.jedis.params.sortedset.ZIncrByParams;
import redis.clients.util.Pool;

import com.lj.eshop.eis.redis.RedisCallback;
import com.lj.eshop.eis.redis.RedisClient;

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
@SuppressWarnings("rawtypes")
public abstract class RedisCommands<T extends Pool, R extends Jedis> extends AbstractRedisClient implements
		RedisClient {

	private static Logger logger = LoggerFactory.getLogger(RedisCommands.class);

	protected <K> K execute(RedisCallback<K> callback, Object... args) {
		Jedis jedis = null;
		try {
			//Object index = ((Object[]) args)[0];
			//logger.debug("-------------------index ------------" + index);
//			if (null != index && Integer.parseInt(index.toString()) > 0
//					&& Integer.parseInt(index.toString()) < 16) {
//				jedis = getJedis(Integer.parseInt(index.toString()));
//			} else {
				jedis = getJedis();
//			}
			return callback.call(jedis, args);
		} catch (JedisConnectionException e) {
			if (jedis != null){
				returnBrokeRedis(jedis);
			}
			jedis = getJedis();
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		} finally {
			if (jedis != null) {
				returnResource(jedis);
			}
		}
		return null;
		
	}

	/*
	 * redis commands
	 */

	@Override
	public java.lang.String get(java.lang.String arg0) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.get(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.String type(java.lang.String arg0) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.type(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.Long append(java.lang.String arg0, java.lang.String arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];

				return jedis.append(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.String set(java.lang.String arg0, java.lang.String arg1) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];

				return jedis.set(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.util.List<java.lang.String> sort(java.lang.String arg0,
			redis.clients.jedis.SortingParams arg1) {
		return execute(new RedisCallback<java.util.List<java.lang.String>>() {
			@Override
			public java.util.List<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				redis.clients.jedis.SortingParams arg1 = (redis.clients.jedis.SortingParams) parms[1];

				return jedis.sort(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.util.List<java.lang.String> sort(java.lang.String arg0) {
		return execute(new RedisCallback<java.util.List<java.lang.String>>() {
			@Override
			public java.util.List<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.sort(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.Boolean exists(java.lang.String arg0) {
		return execute(new RedisCallback<java.lang.Boolean>() {
			@Override
			public java.lang.Boolean call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.exists(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.Long lrem(java.lang.String arg0, long arg1,
			java.lang.String arg2) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				long arg1 = (Long) parms[1];
				java.lang.String arg2 = (java.lang.String) parms[2];

				return jedis.lrem(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.lang.Long persist(java.lang.String arg0) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.persist(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.Long expire(java.lang.String arg0, int arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				int arg1 = (Integer) parms[1];

				return jedis.expire(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.Long expireAt(java.lang.String arg0, long arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				long arg1 = (Long) parms[1];

				return jedis.expireAt(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.Long ttl(java.lang.String arg0) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.ttl(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.Boolean setbit(java.lang.String arg0, long arg1,
			boolean arg2) {
		return execute(new RedisCallback<java.lang.Boolean>() {
			@Override
			public java.lang.Boolean call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				long arg1 = (Long) parms[1];
				boolean arg2 = (Boolean) parms[2];

				return jedis.setbit(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.lang.Boolean setbit(java.lang.String arg0, long arg1,
			java.lang.String arg2) {
		return execute(new RedisCallback<java.lang.Boolean>() {
			@Override
			public java.lang.Boolean call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				long arg1 = (Long) parms[1];
				java.lang.String arg2 = (java.lang.String) parms[2];

				return jedis.setbit(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.lang.Boolean getbit(java.lang.String arg0, long arg1) {
		return execute(new RedisCallback<java.lang.Boolean>() {
			@Override
			public java.lang.Boolean call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				long arg1 = (Long) parms[1];

				return jedis.getbit(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.Long setrange(java.lang.String arg0, long arg1,
			java.lang.String arg2) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				long arg1 = (Long) parms[1];
				java.lang.String arg2 = (java.lang.String) parms[2];

				return jedis.setrange(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.lang.String getrange(java.lang.String arg0, long arg1, long arg2) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				long arg1 = (Long) parms[1];
				long arg2 = (Long) parms[2];

				return jedis.getrange(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.lang.String getSet(java.lang.String arg0, java.lang.String arg1) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];

				return jedis.getSet(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.Long setnx(java.lang.String arg0, java.lang.String arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];

				return jedis.setnx(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.String setex(java.lang.String arg0, int arg1,
			java.lang.String arg2) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				int arg1 = (Integer) parms[1];
				java.lang.String arg2 = (java.lang.String) parms[2];

				return jedis.setex(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.lang.Long decrBy(java.lang.String arg0, long arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				long arg1 = (Long) parms[1];

				return jedis.decrBy(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.Long decr(java.lang.String arg0) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.decr(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.Long incrBy(java.lang.String arg0, long arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				long arg1 = (Long) parms[1];

				return jedis.incrBy(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.Long incr(java.lang.String arg0) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.incr(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.String substr(java.lang.String arg0, int arg1, int arg2) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				int arg1 = (Integer) parms[1];
				int arg2 = (Integer) parms[2];

				return jedis.substr(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.lang.Long hset(java.lang.String arg0, java.lang.String arg1,
			java.lang.String arg2) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];
				java.lang.String arg2 = (java.lang.String) parms[2];

				return jedis.hset(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.lang.String hget(java.lang.String arg0, java.lang.String arg1) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];

				return jedis.hget(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.Long hsetnx(java.lang.String arg0, java.lang.String arg1,
			java.lang.String arg2) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];
				java.lang.String arg2 = (java.lang.String) parms[2];

				return jedis.hsetnx(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.lang.String hmset(java.lang.String arg0,
			java.util.Map<java.lang.String, java.lang.String> arg1) {
		return execute(new RedisCallback<java.lang.String>() {
			@SuppressWarnings("unchecked")
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.util.Map<java.lang.String, java.lang.String> arg1 = (java.util.Map<java.lang.String, java.lang.String>) parms[1];

				return jedis.hmset(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.util.List<java.lang.String> hmget(java.lang.String arg0,
			java.lang.String... arg1) {
		return execute(new RedisCallback<java.util.List<java.lang.String>>() {
			@Override
			public java.util.List<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String[] arg1 = (java.lang.String[]) parms[1];

				return jedis.hmget(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.Long hincrBy(java.lang.String arg0, java.lang.String arg1,
			long arg2) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];
				long arg2 = (Long) parms[2];

				return jedis.hincrBy(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.lang.Boolean hexists(java.lang.String arg0,
			java.lang.String arg1) {
		return execute(new RedisCallback<java.lang.Boolean>() {
			@Override
			public java.lang.Boolean call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];

				return jedis.hexists(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.Long hdel(java.lang.String arg0, java.lang.String... arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String[] arg1 = (java.lang.String[]) parms[1];

				return jedis.hdel(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.Long hlen(java.lang.String arg0) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.hlen(arg0);
			}
		}, arg0);
	}

	@Override
	public java.util.Set<java.lang.String> hkeys(java.lang.String arg0) {
		return execute(new RedisCallback<java.util.Set<java.lang.String>>() {
			@Override
			public java.util.Set<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.hkeys(arg0);
			}
		}, arg0);
	}

	@Override
	public java.util.List<java.lang.String> hvals(java.lang.String arg0) {
		return execute(new RedisCallback<java.util.List<java.lang.String>>() {
			@Override
			public java.util.List<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.hvals(arg0);
			}
		}, arg0);
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> hgetAll(
			java.lang.String arg0) {
		return execute(
				new RedisCallback<java.util.Map<java.lang.String, java.lang.String>>() {
					@Override
					public java.util.Map<java.lang.String, java.lang.String> call(
							Jedis jedis, Object... parms) {
						java.lang.String arg0 = (java.lang.String) parms[0];

						return jedis.hgetAll(arg0);
					}
				}, arg0);
	}

	@Override
	public java.lang.Long rpush(java.lang.String arg0, java.lang.String... arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String[] arg1 = (java.lang.String[]) parms[1];

				return jedis.rpush(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.Long lpush(java.lang.String arg0, java.lang.String... arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String[] arg1 = (java.lang.String[]) parms[1];

				return jedis.lpush(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.Long llen(java.lang.String arg0) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.llen(arg0);
			}
		}, arg0);
	}

	@Override
	public java.util.List<java.lang.String> lrange(java.lang.String arg0,
			long arg1, long arg2) {
		return execute(new RedisCallback<java.util.List<java.lang.String>>() {
			@Override
			public java.util.List<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				long arg1 = (Long) parms[1];
				long arg2 = (Long) parms[2];

				return jedis.lrange(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.lang.String ltrim(java.lang.String arg0, long arg1, long arg2) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				long arg1 = (Long) parms[1];
				long arg2 = (Long) parms[2];

				return jedis.ltrim(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.lang.String lindex(java.lang.String arg0, long arg1) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				long arg1 = (Long) parms[1];

				return jedis.lindex(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.String lset(java.lang.String arg0, long arg1,
			java.lang.String arg2) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				long arg1 = (Long) parms[1];
				java.lang.String arg2 = (java.lang.String) parms[2];

				return jedis.lset(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.util.Set<redis.clients.jedis.Tuple> zrevrangeWithScores(
			java.lang.String arg0, long arg1, long arg2) {
		return execute(
				new RedisCallback<java.util.Set<redis.clients.jedis.Tuple>>() {
					@Override
					public java.util.Set<redis.clients.jedis.Tuple> call(
							Jedis jedis, Object... parms) {
						java.lang.String arg0 = (java.lang.String) parms[0];
						long arg1 = (Long) parms[1];
						long arg2 = (Long) parms[2];

						return jedis.zrevrangeWithScores(arg0, arg1, arg2);
					}
				}, arg0, arg1, arg2);
	}

	@Override
	public java.util.Set<redis.clients.jedis.Tuple> zrangeByScoreWithScores(
			java.lang.String arg0, double arg1, double arg2, int arg3, int arg4) {
		return execute(
				new RedisCallback<java.util.Set<redis.clients.jedis.Tuple>>() {
					@Override
					public java.util.Set<redis.clients.jedis.Tuple> call(
							Jedis jedis, Object... parms) {
						java.lang.String arg0 = (java.lang.String) parms[0];
						double arg1 = (Double) parms[1];
						double arg2 = (Double) parms[2];
						int arg3 = (Integer) parms[3];
						int arg4 = (Integer) parms[4];

						return jedis.zrangeByScoreWithScores(arg0, arg1, arg2,
								arg3, arg4);
					}
				}, arg0, arg1, arg2, arg3, arg4);
	}

	@Override
	public java.util.Set<redis.clients.jedis.Tuple> zrangeByScoreWithScores(
			java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) {
		return execute(
				new RedisCallback<java.util.Set<redis.clients.jedis.Tuple>>() {
					@Override
					public java.util.Set<redis.clients.jedis.Tuple> call(
							Jedis jedis, Object... parms) {
						java.lang.String arg0 = (java.lang.String) parms[0];
						java.lang.String arg1 = (java.lang.String) parms[1];
						java.lang.String arg2 = (java.lang.String) parms[2];

						return jedis.zrangeByScoreWithScores(arg0, arg1, arg2);
					}
				}, arg0, arg1, arg2);
	}

	@Override
	public java.util.Set<redis.clients.jedis.Tuple> zrangeByScoreWithScores(
			java.lang.String arg0, double arg1, double arg2) {
		return execute(
				new RedisCallback<java.util.Set<redis.clients.jedis.Tuple>>() {
					@Override
					public java.util.Set<redis.clients.jedis.Tuple> call(
							Jedis jedis, Object... parms) {
						java.lang.String arg0 = (java.lang.String) parms[0];
						double arg1 = (Double) parms[1];
						double arg2 = (Double) parms[2];

						return jedis.zrangeByScoreWithScores(arg0, arg1, arg2);
					}
				}, arg0, arg1, arg2);
	}

	@Override
	public java.util.Set<redis.clients.jedis.Tuple> zrangeByScoreWithScores(
			java.lang.String arg0, java.lang.String arg1,
			java.lang.String arg2, int arg3, int arg4) {
		return execute(
				new RedisCallback<java.util.Set<redis.clients.jedis.Tuple>>() {
					@Override
					public java.util.Set<redis.clients.jedis.Tuple> call(
							Jedis jedis, Object... parms) {
						java.lang.String arg0 = (java.lang.String) parms[0];
						java.lang.String arg1 = (java.lang.String) parms[1];
						java.lang.String arg2 = (java.lang.String) parms[2];
						int arg3 = (Integer) parms[3];
						int arg4 = (Integer) parms[4];

						return jedis.zrangeByScoreWithScores(arg0, arg1, arg2,
								arg3, arg4);
					}
				}, arg0, arg1, arg2, arg3, arg4);
	}

	@Override
	public java.util.Set<redis.clients.jedis.Tuple> zrevrangeByScoreWithScores(
			java.lang.String arg0, java.lang.String arg1,
			java.lang.String arg2, int arg3, int arg4) {
		return execute(
				new RedisCallback<java.util.Set<redis.clients.jedis.Tuple>>() {
					@Override
					public java.util.Set<redis.clients.jedis.Tuple> call(
							Jedis jedis, Object... parms) {
						java.lang.String arg0 = (java.lang.String) parms[0];
						java.lang.String arg1 = (java.lang.String) parms[1];
						java.lang.String arg2 = (java.lang.String) parms[2];
						int arg3 = (Integer) parms[3];
						int arg4 = (Integer) parms[4];

						return jedis.zrevrangeByScoreWithScores(arg0, arg1,
								arg2, arg3, arg4);
					}
				}, arg0, arg1, arg2, arg3, arg4);
	}

	@Override
	public java.util.Set<redis.clients.jedis.Tuple> zrevrangeByScoreWithScores(
			java.lang.String arg0, double arg1, double arg2) {
		return execute(
				new RedisCallback<java.util.Set<redis.clients.jedis.Tuple>>() {
					@Override
					public java.util.Set<redis.clients.jedis.Tuple> call(
							Jedis jedis, Object... parms) {
						java.lang.String arg0 = (java.lang.String) parms[0];
						double arg1 = (Double) parms[1];
						double arg2 = (Double) parms[2];

						return jedis.zrevrangeByScoreWithScores(arg0, arg1,
								arg2);
					}
				}, arg0, arg1, arg2);
	}

	@Override
	public java.util.Set<redis.clients.jedis.Tuple> zrevrangeByScoreWithScores(
			java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) {
		return execute(
				new RedisCallback<java.util.Set<redis.clients.jedis.Tuple>>() {
					@Override
					public java.util.Set<redis.clients.jedis.Tuple> call(
							Jedis jedis, Object... parms) {
						java.lang.String arg0 = (java.lang.String) parms[0];
						java.lang.String arg1 = (java.lang.String) parms[1];
						java.lang.String arg2 = (java.lang.String) parms[2];

						return jedis.zrevrangeByScoreWithScores(arg0, arg1,
								arg2);
					}
				}, arg0, arg1, arg2);
	}

	@Override
	public java.util.Set<redis.clients.jedis.Tuple> zrevrangeByScoreWithScores(
			java.lang.String arg0, double arg1, double arg2, int arg3, int arg4) {
		return execute(
				new RedisCallback<java.util.Set<redis.clients.jedis.Tuple>>() {
					@Override
					public java.util.Set<redis.clients.jedis.Tuple> call(
							Jedis jedis, Object... parms) {
						java.lang.String arg0 = (java.lang.String) parms[0];
						double arg1 = (Double) parms[1];
						double arg2 = (Double) parms[2];
						int arg3 = (Integer) parms[3];
						int arg4 = (Integer) parms[4];

						return jedis.zrevrangeByScoreWithScores(arg0, arg1,
								arg2, arg3, arg4);
					}
				}, arg0, arg1, arg2, arg3, arg4);
	}

	@Override
	public java.lang.String lpop(java.lang.String arg0) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.lpop(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.String rpop(java.lang.String arg0) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.rpop(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.Long sadd(java.lang.String arg0, java.lang.String... arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String[] arg1 = (java.lang.String[]) parms[1];

				return jedis.sadd(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.util.Set<java.lang.String> smembers(java.lang.String arg0) {
		return execute(new RedisCallback<java.util.Set<java.lang.String>>() {
			@Override
			public java.util.Set<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.smembers(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.Long srem(java.lang.String arg0, java.lang.String... arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String[] arg1 = (java.lang.String[]) parms[1];

				return jedis.srem(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.String spop(java.lang.String arg0) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.spop(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.Long scard(java.lang.String arg0) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.scard(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.Boolean sismember(java.lang.String arg0,
			java.lang.String arg1) {
		return execute(new RedisCallback<java.lang.Boolean>() {
			@Override
			public java.lang.Boolean call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];

				return jedis.sismember(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.String srandmember(java.lang.String arg0) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.srandmember(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.Long strlen(java.lang.String arg0) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.strlen(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.Long zadd(java.lang.String arg0,
			java.util.Map<java.lang.String, java.lang.Double> arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@SuppressWarnings("unchecked")
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.util.Map<java.lang.String, java.lang.Double> arg1 = (java.util.Map<java.lang.String, java.lang.Double>) parms[1];

				return jedis.zadd(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.Long zadd(java.lang.String arg0, double arg1,
			java.lang.String arg2) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				double arg1 = (Double) parms[1];
				java.lang.String arg2 = (java.lang.String) parms[2];

				return jedis.zadd(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.util.Set<java.lang.String> zrange(java.lang.String arg0,
			long arg1, long arg2) {
		return execute(new RedisCallback<java.util.Set<java.lang.String>>() {
			@Override
			public java.util.Set<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				long arg1 = (Long) parms[1];
				long arg2 = (Long) parms[2];

				return jedis.zrange(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.lang.Long zrem(java.lang.String arg0, java.lang.String... arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String[] arg1 = (java.lang.String[]) parms[1];

				return jedis.zrem(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.Double zincrby(java.lang.String arg0, double arg1,
			java.lang.String arg2) {
		return execute(new RedisCallback<java.lang.Double>() {
			@Override
			public java.lang.Double call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				double arg1 = (Double) parms[1];
				java.lang.String arg2 = (java.lang.String) parms[2];

				return jedis.zincrby(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.lang.Long zrank(java.lang.String arg0, java.lang.String arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];

				return jedis.zrank(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.Long zrevrank(java.lang.String arg0, java.lang.String arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];

				return jedis.zrevrank(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.util.Set<java.lang.String> zrevrange(java.lang.String arg0,
			long arg1, long arg2) {
		return execute(new RedisCallback<java.util.Set<java.lang.String>>() {
			@Override
			public java.util.Set<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				long arg1 = (Long) parms[1];
				long arg2 = (Long) parms[2];

				return jedis.zrevrange(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.util.Set<redis.clients.jedis.Tuple> zrangeWithScores(
			java.lang.String arg0, long arg1, long arg2) {
		return execute(
				new RedisCallback<java.util.Set<redis.clients.jedis.Tuple>>() {
					@Override
					public java.util.Set<redis.clients.jedis.Tuple> call(
							Jedis jedis, Object... parms) {
						java.lang.String arg0 = (java.lang.String) parms[0];
						long arg1 = (Long) parms[1];
						long arg2 = (Long) parms[2];

						return jedis.zrangeWithScores(arg0, arg1, arg2);
					}
				}, arg0, arg1, arg2);
	}

	@Override
	public java.lang.Long zcard(java.lang.String arg0) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.zcard(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.Double zscore(java.lang.String arg0, java.lang.String arg1) {
		return execute(new RedisCallback<java.lang.Double>() {
			@Override
			public java.lang.Double call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];

				return jedis.zscore(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.Long zcount(java.lang.String arg0, double arg1, double arg2) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				double arg1 = (Double) parms[1];
				double arg2 = (Double) parms[2];

				return jedis.zcount(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.lang.Long zcount(java.lang.String arg0, java.lang.String arg1,
			java.lang.String arg2) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];
				java.lang.String arg2 = (java.lang.String) parms[2];

				return jedis.zcount(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.util.Set<java.lang.String> zrangeByScore(java.lang.String arg0,
			java.lang.String arg1, java.lang.String arg2) {
		return execute(new RedisCallback<java.util.Set<java.lang.String>>() {
			@Override
			public java.util.Set<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];
				java.lang.String arg2 = (java.lang.String) parms[2];

				return jedis.zrangeByScore(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.util.Set<java.lang.String> zrangeByScore(java.lang.String arg0,
			double arg1, double arg2) {
		return execute(new RedisCallback<java.util.Set<java.lang.String>>() {
			@Override
			public java.util.Set<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				double arg1 = (Double) parms[1];
				double arg2 = (Double) parms[2];

				return jedis.zrangeByScore(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.util.Set<java.lang.String> zrangeByScore(java.lang.String arg0,
			java.lang.String arg1, java.lang.String arg2, int arg3, int arg4) {
		return execute(new RedisCallback<java.util.Set<java.lang.String>>() {
			@Override
			public java.util.Set<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];
				java.lang.String arg2 = (java.lang.String) parms[2];
				int arg3 = (Integer) parms[3];
				int arg4 = (Integer) parms[4];

				return jedis.zrangeByScore(arg0, arg1, arg2, arg3, arg4);
			}
		}, arg0, arg1, arg2, arg3, arg4);
	}

	@Override
	public java.util.Set<java.lang.String> zrangeByScore(java.lang.String arg0,
			double arg1, double arg2, int arg3, int arg4) {
		return execute(new RedisCallback<java.util.Set<java.lang.String>>() {
			@Override
			public java.util.Set<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				double arg1 = (Double) parms[1];
				double arg2 = (Double) parms[2];
				int arg3 = (Integer) parms[3];
				int arg4 = (Integer) parms[4];

				return jedis.zrangeByScore(arg0, arg1, arg2, arg3, arg4);
			}
		}, arg0, arg1, arg2, arg3, arg4);
	}

	@Override
	public java.util.Set<java.lang.String> zrevrangeByScore(
			java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) {
		return execute(new RedisCallback<java.util.Set<java.lang.String>>() {
			@Override
			public java.util.Set<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];
				java.lang.String arg2 = (java.lang.String) parms[2];

				return jedis.zrevrangeByScore(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.util.Set<java.lang.String> zrevrangeByScore(
			java.lang.String arg0, double arg1, double arg2, int arg3, int arg4) {
		return execute(new RedisCallback<java.util.Set<java.lang.String>>() {
			@Override
			public java.util.Set<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				double arg1 = (Double) parms[1];
				double arg2 = (Double) parms[2];
				int arg3 = (Integer) parms[3];
				int arg4 = (Integer) parms[4];

				return jedis.zrevrangeByScore(arg0, arg1, arg2, arg3, arg4);
			}
		}, arg0, arg1, arg2, arg3, arg4);
	}

	@Override
	public java.util.Set<java.lang.String> zrevrangeByScore(
			java.lang.String arg0, double arg1, double arg2) {
		return execute(new RedisCallback<java.util.Set<java.lang.String>>() {
			@Override
			public java.util.Set<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				double arg1 = (Double) parms[1];
				double arg2 = (Double) parms[2];

				return jedis.zrevrangeByScore(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.util.Set<java.lang.String> zrevrangeByScore(
			java.lang.String arg0, java.lang.String arg1,
			java.lang.String arg2, int arg3, int arg4) {
		return execute(new RedisCallback<java.util.Set<java.lang.String>>() {
			@Override
			public java.util.Set<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];
				java.lang.String arg2 = (java.lang.String) parms[2];
				int arg3 = (Integer) parms[3];
				int arg4 = (Integer) parms[4];

				return jedis.zrevrangeByScore(arg0, arg1, arg2, arg3, arg4);
			}
		}, arg0, arg1, arg2, arg3, arg4);
	}

	@Override
	public java.lang.Long zremrangeByRank(java.lang.String arg0, long arg1,
			long arg2) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				long arg1 = (Long) parms[1];
				long arg2 = (Long) parms[2];

				return jedis.zremrangeByRank(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.lang.Long zremrangeByScore(java.lang.String arg0, double arg1,
			double arg2) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				double arg1 = (Double) parms[1];
				double arg2 = (Double) parms[2];

				return jedis.zremrangeByScore(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.lang.Long zremrangeByScore(java.lang.String arg0,
			java.lang.String arg1, java.lang.String arg2) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];
				java.lang.String arg2 = (java.lang.String) parms[2];

				return jedis.zremrangeByScore(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.lang.Long linsert(java.lang.String arg0,
			redis.clients.jedis.BinaryClient.LIST_POSITION arg1,
			java.lang.String arg2, java.lang.String arg3) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				redis.clients.jedis.BinaryClient.LIST_POSITION arg1 = (redis.clients.jedis.BinaryClient.LIST_POSITION) parms[1];
				java.lang.String arg2 = (java.lang.String) parms[2];
				java.lang.String arg3 = (java.lang.String) parms[3];

				return jedis.linsert(arg0, arg1, arg2, arg3);
			}
		}, arg0, arg1, arg2, arg3);
	}

	@Override
	public java.lang.Long lpushx(java.lang.String arg0, java.lang.String... arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String[] arg1 = (java.lang.String[]) parms[1];

				return jedis.lpushx(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.Long rpushx(java.lang.String arg0, java.lang.String... arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String[] arg1 = (java.lang.String[]) parms[1];

				return jedis.rpushx(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.util.List<java.lang.String> blpop(java.lang.String arg0) {
		return execute(new RedisCallback<java.util.List<java.lang.String>>() {
			@Override
			public java.util.List<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.blpop(arg0);
			}
		}, arg0);
	}

	@Override
	public java.util.List<java.lang.String> brpop(java.lang.String arg0) {
		return execute(new RedisCallback<java.util.List<java.lang.String>>() {
			@Override
			public java.util.List<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.brpop(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.Long del(java.lang.String arg0) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.del(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.String echo(java.lang.String arg0) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.echo(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.Long move(java.lang.String arg0, int arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				int arg1 = (Integer) parms[1];

				return jedis.move(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.Long bitcount(java.lang.String arg0, long arg1, long arg2) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				long arg1 = (Long) parms[1];
				long arg2 = (Long) parms[2];

				return jedis.bitcount(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.lang.Long bitcount(java.lang.String arg0) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.bitcount(arg0);
			}
		}, arg0);
	}

	@Override
	public redis.clients.jedis.ScanResult<java.util.Map.Entry<java.lang.String, java.lang.String>> hscan(
			java.lang.String arg0, java.lang.String arg1) {
		return execute(
				new RedisCallback<redis.clients.jedis.ScanResult<java.util.Map.Entry<java.lang.String, java.lang.String>>>() {
					@Override
					public redis.clients.jedis.ScanResult<java.util.Map.Entry<java.lang.String, java.lang.String>> call(
							Jedis jedis, Object... parms) {
						java.lang.String arg0 = (java.lang.String) parms[0];
						java.lang.String arg1 = (java.lang.String) parms[1];

						return jedis.hscan(arg0, arg1);
					}
				}, arg0, arg1);
	}


	@Override
	public redis.clients.jedis.ScanResult<java.lang.String> sscan(
			java.lang.String arg0, java.lang.String arg1) {
		return execute(
				new RedisCallback<redis.clients.jedis.ScanResult<java.lang.String>>() {
					@Override
					public redis.clients.jedis.ScanResult<java.lang.String> call(
							Jedis jedis, Object... parms) {
						java.lang.String arg0 = (java.lang.String) parms[0];
						java.lang.String arg1 = (java.lang.String) parms[1];

						return jedis.sscan(arg0, arg1);
					}
				}, arg0, arg1);
	}


	@Override
	public redis.clients.jedis.ScanResult<redis.clients.jedis.Tuple> zscan(
			java.lang.String arg0, java.lang.String arg1) {
		return execute(
				new RedisCallback<redis.clients.jedis.ScanResult<redis.clients.jedis.Tuple>>() {
					@Override
					public redis.clients.jedis.ScanResult<redis.clients.jedis.Tuple> call(
							Jedis jedis, Object... parms) {
						java.lang.String arg0 = (java.lang.String) parms[0];
						java.lang.String arg1 = (java.lang.String) parms[1];

						return jedis.zscan(arg0, arg1);
					}
				}, arg0, arg1);
	}


	// multi

	@Override
	public java.util.Set<java.lang.String> keys(java.lang.String arg0) {
		return execute(new RedisCallback<java.util.Set<java.lang.String>>() {
			@Override
			public java.util.Set<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.keys(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.Long sort(java.lang.String arg0,
			redis.clients.jedis.SortingParams arg1, java.lang.String arg2) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				redis.clients.jedis.SortingParams arg1 = (redis.clients.jedis.SortingParams) parms[1];
				java.lang.String arg2 = (java.lang.String) parms[2];

				return jedis.sort(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.lang.Long sort(java.lang.String arg0, java.lang.String arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];

				return jedis.sort(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.String rename(java.lang.String arg0, java.lang.String arg1) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];

				return jedis.rename(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.Long del(java.lang.String... arg0) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String[] arg0 = (java.lang.String[]) parms[0];

				return jedis.del(arg0);
			}
		}, arg0);
	}

	@Override
	public java.util.List<java.lang.String> blpop(int arg0,
			java.lang.String... arg1) {
		return execute(new RedisCallback<java.util.List<java.lang.String>>() {
			@Override
			public java.util.List<java.lang.String> call(Jedis jedis,
					Object... parms) {
				int arg0 = (Integer) parms[0];
				java.lang.String[] arg1 = (java.lang.String[]) parms[1];

				return jedis.blpop(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.util.List<java.lang.String> blpop(java.lang.String... arg0) {
		return execute(new RedisCallback<java.util.List<java.lang.String>>() {
			@Override
			public java.util.List<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String[] arg0 = (java.lang.String[]) parms[0];

				return jedis.blpop(arg0);
			}
		}, arg0);
	}

	@Override
	public java.util.List<java.lang.String> brpop(int arg0,
			java.lang.String... arg1) {
		return execute(new RedisCallback<java.util.List<java.lang.String>>() {
			@Override
			public java.util.List<java.lang.String> call(Jedis jedis,
					Object... parms) {
				int arg0 = (Integer) parms[0];
				java.lang.String[] arg1 = (java.lang.String[]) parms[1];

				return jedis.brpop(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.util.List<java.lang.String> brpop(java.lang.String... arg0) {
		return execute(new RedisCallback<java.util.List<java.lang.String>>() {
			@Override
			public java.util.List<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String[] arg0 = (java.lang.String[]) parms[0];

				return jedis.brpop(arg0);
			}
		}, arg0);
	}

	@Override
	public java.util.List<java.lang.String> mget(java.lang.String... arg0) {
		return execute(new RedisCallback<java.util.List<java.lang.String>>() {
			@Override
			public java.util.List<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String[] arg0 = (java.lang.String[]) parms[0];

				return jedis.mget(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.String mset(java.lang.String... arg0) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String[] arg0 = (java.lang.String[]) parms[0];

				return jedis.mset(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.Long msetnx(java.lang.String... arg0) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String[] arg0 = (java.lang.String[]) parms[0];

				return jedis.msetnx(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.Long renamenx(java.lang.String arg0, java.lang.String arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];

				return jedis.renamenx(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.String rpoplpush(java.lang.String arg0,
			java.lang.String arg1) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];

				return jedis.rpoplpush(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.util.Set<java.lang.String> sdiff(java.lang.String... arg0) {
		return execute(new RedisCallback<java.util.Set<java.lang.String>>() {
			@Override
			public java.util.Set<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String[] arg0 = (java.lang.String[]) parms[0];

				return jedis.sdiff(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.Long sdiffstore(java.lang.String arg0,
			java.lang.String... arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String[] arg1 = (java.lang.String[]) parms[1];

				return jedis.sdiffstore(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.util.Set<java.lang.String> sinter(java.lang.String... arg0) {
		return execute(new RedisCallback<java.util.Set<java.lang.String>>() {
			@Override
			public java.util.Set<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String[] arg0 = (java.lang.String[]) parms[0];

				return jedis.sinter(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.Long sinterstore(java.lang.String arg0,
			java.lang.String... arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String[] arg1 = (java.lang.String[]) parms[1];

				return jedis.sinterstore(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.Long smove(java.lang.String arg0, java.lang.String arg1,
			java.lang.String arg2) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];
				java.lang.String arg2 = (java.lang.String) parms[2];

				return jedis.smove(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.util.Set<java.lang.String> sunion(java.lang.String... arg0) {
		return execute(new RedisCallback<java.util.Set<java.lang.String>>() {
			@Override
			public java.util.Set<java.lang.String> call(Jedis jedis,
					Object... parms) {
				java.lang.String[] arg0 = (java.lang.String[]) parms[0];

				return jedis.sunion(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.Long sunionstore(java.lang.String arg0,
			java.lang.String... arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String[] arg1 = (java.lang.String[]) parms[1];

				return jedis.sunionstore(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.String watch(java.lang.String... arg0) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String[] arg0 = (java.lang.String[]) parms[0];

				return jedis.watch(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.String unwatch() {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {

				return jedis.unwatch();
			}
		});
	}

	@Override
	public java.lang.Long zinterstore(java.lang.String arg0,
			redis.clients.jedis.ZParams arg1, java.lang.String... arg2) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				redis.clients.jedis.ZParams arg1 = (redis.clients.jedis.ZParams) parms[1];
				java.lang.String[] arg2 = (java.lang.String[]) parms[2];

				return jedis.zinterstore(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.lang.Long zinterstore(java.lang.String arg0,
			java.lang.String... arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String[] arg1 = (java.lang.String[]) parms[1];

				return jedis.zinterstore(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.Long zunionstore(java.lang.String arg0,
			redis.clients.jedis.ZParams arg1, java.lang.String... arg2) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				redis.clients.jedis.ZParams arg1 = (redis.clients.jedis.ZParams) parms[1];
				java.lang.String[] arg2 = (java.lang.String[]) parms[2];

				return jedis.zunionstore(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.lang.Long zunionstore(java.lang.String arg0,
			java.lang.String... arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String[] arg1 = (java.lang.String[]) parms[1];

				return jedis.zunionstore(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.String brpoplpush(java.lang.String arg0,
			java.lang.String arg1, int arg2) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];
				int arg2 = (Integer) parms[2];

				return jedis.brpoplpush(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public java.lang.Long publish(java.lang.String arg0, java.lang.String arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];

				return jedis.publish(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public void subscribe(redis.clients.jedis.JedisPubSub arg0,
			java.lang.String... arg1) {
		execute(new RedisCallback<Object>() {
			@Override
			public Object call(Jedis jedis, Object... parms) {
				redis.clients.jedis.JedisPubSub arg0 = (redis.clients.jedis.JedisPubSub) parms[0];
				java.lang.String[] arg1 = (java.lang.String[]) parms[1];

				jedis.subscribe(arg0, arg1);
				return null;
			}
		}, arg0, arg1);
	}

	@Override
	public void psubscribe(redis.clients.jedis.JedisPubSub arg0,
			java.lang.String... arg1) {
		execute(new RedisCallback<Object>() {
			@Override
			public Object call(Jedis jedis, Object... parms) {
				redis.clients.jedis.JedisPubSub arg0 = (redis.clients.jedis.JedisPubSub) parms[0];
				java.lang.String[] arg1 = (java.lang.String[]) parms[1];

				jedis.psubscribe(arg0, arg1);
				return null;
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.String randomKey() {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {

				return jedis.randomKey();
			}
		});
	}

	@Override
	public java.lang.Long bitop(redis.clients.jedis.BitOP arg0,
			java.lang.String arg1, java.lang.String... arg2) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				redis.clients.jedis.BitOP arg0 = (redis.clients.jedis.BitOP) parms[0];
				java.lang.String arg1 = (java.lang.String) parms[1];
				java.lang.String[] arg2 = (java.lang.String[]) parms[2];

				return jedis.bitop(arg0, arg1, arg2);
			}
		}, arg0, arg1, arg2);
	}

	@Override
	public redis.clients.jedis.ScanResult<java.lang.String> scan(
			java.lang.String arg0) {
		return execute(
				new RedisCallback<redis.clients.jedis.ScanResult<java.lang.String>>() {
					@Override
					public redis.clients.jedis.ScanResult<java.lang.String> call(
							Jedis jedis, Object... parms) {
						java.lang.String arg0 = (java.lang.String) parms[0];

						return jedis.scan(arg0);
					}
				}, arg0);
	}

	// base commands

	@Override
	public java.lang.String shutdown() {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {

				return jedis.shutdown();
			}
		});
	}

	@Override
	public java.lang.String debug(redis.clients.jedis.DebugParams arg0) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				redis.clients.jedis.DebugParams arg0 = (redis.clients.jedis.DebugParams) parms[0];

				return jedis.debug(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.String save() {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {

				return jedis.save();
			}
		});
	}

	@Override
	public java.lang.String slaveof(java.lang.String arg0, int arg1) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];
				int arg1 = (Integer) parms[1];

				return jedis.slaveof(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.String slaveofNoOne() {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {

				return jedis.slaveofNoOne();
			}
		});
	}

	@Override
	public java.lang.Long getDB() {
	  return execute(new RedisCallback<java.lang.Long>() {
		  @Override
	    public java.lang.Long call(Jedis jedis, Object... parms) {

	      return jedis.getDB();
	    }
		});
	}

	@Override
	public java.lang.String configResetStat() {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {

				return jedis.configResetStat();
			}
		});
	}

	@Override
	public java.lang.Long waitReplicas(int arg0, long arg1) {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {
				int arg0 = (Integer) parms[0];
				long arg1 = (Long) parms[1];

				return jedis.waitReplicas(arg0, arg1);
			}
		}, arg0, arg1);
	}

	@Override
	public java.lang.String ping() {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {

				return jedis.ping();
			}
		});
	}

	@Override
	public java.lang.String quit() {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {

				return jedis.quit();
			}
		});
	}

	@Override
	public java.lang.String flushDB() {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {

				return jedis.flushDB();
			}
		});
	}

	@Override
	public java.lang.Long dbSize() {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {

				return jedis.dbSize();
			}
		});
	}

	@Override
	public java.lang.String select(int arg0) {
//		return execute(new RedisCallback<java.lang.String>() {
//			public java.lang.String call(Jedis jedis, Object... parms) {
//				int arg0 = (Integer) parms[0];

		Jedis jedis = getJedis();
				return jedis.select(arg0);
//			}
//		}, arg0);
	}

	
	@Override
	public java.lang.String flushAll() {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {

				return jedis.flushAll();
			}
		});
	}

	@Override
	public java.lang.String auth(java.lang.String arg0) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.auth(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.String bgsave() {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {

				return jedis.bgsave();
			}
		});
	}

	@Override
	public java.lang.String bgrewriteaof() {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {

				return jedis.bgrewriteaof();
			}
		});
	}

	@Override
	public java.lang.Long lastsave() {
		return execute(new RedisCallback<java.lang.Long>() {
			@Override
			public java.lang.Long call(Jedis jedis, Object... parms) {

				return jedis.lastsave();
			}
		});
	}

	@Override
	public java.lang.String info(java.lang.String arg0) {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {
				java.lang.String arg0 = (java.lang.String) parms[0];

				return jedis.info(arg0);
			}
		}, arg0);
	}

	@Override
	public java.lang.String info() {
		return execute(new RedisCallback<java.lang.String>() {
			@Override
			public java.lang.String call(Jedis jedis, Object... parms) {

				return jedis.info();
			}
		});
	}


	@Override
	public String set(String key, String value, String nxxx, String expx,
			long time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String set(String key, String value, String nxxx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long pexpire(String key, long milliseconds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long pexpireAt(String key, long millisecondsTimestamp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long pttl(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String psetex(String key, long milliseconds, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double incrByFloat(String key, double value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double hincrByFloat(String key, String field, double value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> spop(String key, long count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> srandmember(String key, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long zadd(String key, double score, String member, ZAddParams params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long zadd(String key, Map<String, Double> scoreMembers,
			ZAddParams params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double zincrby(String key, double score, String member,
			ZIncrByParams params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long zlexcount(String key, String min, String max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> zrangeByLex(String key, String min, String max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> zrangeByLex(String key, String min, String max,
			int offset, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> zrevrangeByLex(String key, String max, String min) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> zrevrangeByLex(String key, String max, String min,
			int offset, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long zremrangeByLex(String key, String min, String max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> blpop(int timeout, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> brpop(int timeout, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long bitpos(String key, boolean value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long bitpos(String key, boolean value, BitPosParams params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScanResult<Entry<String, String>> hscan(String key, int cursor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScanResult<String> sscan(String key, int cursor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScanResult<Tuple> zscan(String key, int cursor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScanResult<Entry<String, String>> hscan(String key, String cursor,
			ScanParams params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScanResult<String> sscan(String key, String cursor, ScanParams params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScanResult<Tuple> zscan(String key, String cursor, ScanParams params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long pfadd(String key, String... elements) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long pfcount(String key) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Long geoadd(String key, double longitude, double latitude,
			String member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long geoadd(String key,
			Map<String, GeoCoordinate> memberCoordinateMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double geodist(String key, String member1, String member2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double geodist(String key, String member1, String member2,
			GeoUnit unit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> geohash(String key, String... members) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GeoCoordinate> geopos(String key, String... members) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GeoRadiusResponse> georadius(String key, double longitude,
			double latitude, double radius, GeoUnit unit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GeoRadiusResponse> georadius(String key, double longitude,
			double latitude, double radius, GeoUnit unit, GeoRadiusParam param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GeoRadiusResponse> georadiusByMember(String key, String member,
			double radius, GeoUnit unit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GeoRadiusResponse> georadiusByMember(String key, String member,
			double radius, GeoUnit unit, GeoRadiusParam param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long exists(String... keys) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScanResult<String> scan(int cursor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScanResult<String> scan(String cursor, ScanParams params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String pfmerge(String destkey, String... sourcekeys) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long pfcount(String... keys) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Long> bitfield(String arg0, String... arg1) {
		// TODO Auto-generated method stub
		return null;
	}	
}
