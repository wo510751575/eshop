/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.lj.eoms.common;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ape.common.web.Servlets;
import com.google.common.collect.Sets;

import redis.clients.jedis.Jedis;

/**
 * 自定义授权缓存管理类
 * 
 * @author ThinkGem
 * @version 2014-7-20
 */
public class JedisCacheManager implements CacheManager {

	private String cacheKeyPrefix = "shiro_cache_";
	@Autowired
	private com.lj.distributecache.RedisCache redisCache;

	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		return new JedisCache<K, V>(cacheKeyPrefix + name);
	}

	public String getCacheKeyPrefix() {
		return cacheKeyPrefix;
	}

	public void setCacheKeyPrefix(String cacheKeyPrefix) {
		this.cacheKeyPrefix = cacheKeyPrefix;
	}

	/**
	 * 自定义授权缓存管理类
	 * 
	 * @author ThinkGem
	 * @version 2014-7-20
	 */
	public class JedisCache<K, V> implements Cache<K, V> {

		private Logger logger = LoggerFactory.getLogger(getClass());

		private String cacheKeyName = null;

		public JedisCache(String cacheKeyName) {
			this.cacheKeyName = cacheKeyName;
//			if (!redisCache.exists(cacheKeyName)){
//				Map<String, Object> map = Maps.newHashMap();
//				redisCache.setObjectMap(cacheKeyName, map, 60 * 60 * 24);
//			}
//			logger.debug("Init: cacheKeyName {} ", cacheKeyName);
		}

		@SuppressWarnings("unchecked")
		@Override
		public V get(K key) throws CacheException {
			if (key == null) {
				return null;
			}

			V v = null;
			HttpServletRequest request = Servlets.getRequest();
			if (request != null) {
				v = (V) request.getAttribute(cacheKeyName);
				if (v != null) {
					return v;
				}
			}

			V value = null;
			Jedis jedis = null;
			try {
				jedis = redisCache.getJedis();
				value = (V) redisCache
						.toObject(jedis.hget(redisCache.getBytesKey(cacheKeyName), redisCache.getBytesKey(key)));
				logger.debug("get {} {} {}", cacheKeyName, key, request != null ? request.getRequestURI() : "");
			} catch (Exception e) {
				logger.error("get {} {} {}", cacheKeyName, key, request != null ? request.getRequestURI() : "", e);
			} finally {
				redisCache.returnResource(redisCache.getPool(), jedis);
			}

			if (request != null && value != null) {
				request.setAttribute(cacheKeyName, value);
			}

			return value;
		}

		@Override
		public V put(K key, V value) throws CacheException {
			if (key == null) {
				return null;
			}

			Jedis jedis = null;
			try {
				jedis = redisCache.getJedis();
				jedis.hset(redisCache.getBytesKey(cacheKeyName), redisCache.getBytesKey(key),
						redisCache.toBytes(value));
				logger.debug("put {} {} = {}", cacheKeyName, key, value);
			} catch (Exception e) {
				logger.error("put {} {}", cacheKeyName, key, e);
			} finally {
				redisCache.returnResource(redisCache.getPool(), jedis);
			}
			return value;
		}

		@SuppressWarnings("unchecked")
		@Override
		public V remove(K key) throws CacheException {
			V value = null;
			Jedis jedis = null;
			try {
				jedis = redisCache.getJedis();
				value = (V) redisCache
						.toObject(jedis.hget(redisCache.getBytesKey(cacheKeyName), redisCache.getBytesKey(key)));
				jedis.hdel(redisCache.getBytesKey(cacheKeyName), redisCache.getBytesKey(key));
				logger.debug("remove {} {}", cacheKeyName, key);
			} catch (Exception e) {
				logger.warn("remove {} {}", cacheKeyName, key, e);
			} finally {
				redisCache.returnResource(redisCache.getPool(), jedis);
			}
			return value;
		}

		@Override
		public void clear() throws CacheException {
			Jedis jedis = null;
			try {
				jedis = redisCache.getJedis();
				jedis.hdel(redisCache.getBytesKey(cacheKeyName));
				logger.debug("clear {}", cacheKeyName);
			} catch (Exception e) {
				logger.error("clear {}", cacheKeyName, e);
			} finally {
				redisCache.returnResource(redisCache.getPool(), jedis);
			}
		}

		@Override
		public int size() {
			int size = 0;
			Jedis jedis = null;
			try {
				jedis = redisCache.getJedis();
				size = jedis.hlen(redisCache.getBytesKey(cacheKeyName)).intValue();
				logger.debug("size {} {} ", cacheKeyName, size);
				return size;
			} catch (Exception e) {
				logger.error("clear {}", cacheKeyName, e);
			} finally {
				redisCache.returnResource(redisCache.getPool(), jedis);
			}
			return size;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Set<K> keys() {
			Set<K> keys = Sets.newHashSet();
			Jedis jedis = null;
			try {
				jedis = redisCache.getJedis();
				Set<byte[]> set = jedis.hkeys(redisCache.getBytesKey(cacheKeyName));
				for (byte[] key : set) {
					Object obj = (K) redisCache.getObjectKey(key);
					if (obj != null) {
						keys.add((K) obj);
					}
				}
				logger.debug("keys {} {} ", cacheKeyName, keys);
				return keys;
			} catch (Exception e) {
				logger.error("keys {}", cacheKeyName, e);
			} finally {
				redisCache.returnResource(redisCache.getPool(), jedis);
			}
			return keys;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Collection<V> values() {
			Collection<V> vals = Collections.emptyList();
			;
			Jedis jedis = null;
			try {
				jedis = redisCache.getJedis();
				Collection<byte[]> col = jedis.hvals(redisCache.getBytesKey(cacheKeyName));
				for (byte[] val : col) {
					Object obj = redisCache.toObject(val);
					if (obj != null) {
						vals.add((V) obj);
					}
				}
				logger.debug("values {} {} ", cacheKeyName, vals);
				return vals;
			} catch (Exception e) {
				logger.error("values {}", cacheKeyName, e);
			} finally {
				redisCache.returnResource(redisCache.getPool(), jedis);
			}
			return vals;
		}
	}
}
