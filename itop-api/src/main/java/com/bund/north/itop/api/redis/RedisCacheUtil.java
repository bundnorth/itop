package com.bund.north.itop.api.redis;


import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.params.SetParams;

import java.util.ArrayList;
import java.util.List;

@Component
public class RedisCacheUtil {
	@Autowired
	private static StringRedisTemplate stringRedisTemplate;

	@Autowired
	private static RedisTemplate<String, Object> redisTemplate;

	@Autowired
	JedisPool jedisPool;

	public <T> T get(String prefix, String key, Class<T> clazz) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String realKey = prefix + key;
			String str = jedis.get(realKey);
			T t = stringToBean(str, clazz);
			return t;
		} finally {
			release(jedis);
		}
	}

	private void release(Jedis jedis) {
		if (jedis != null) {
			jedis.close();
		}
	}

	public <T> boolean set(String prefix, String key, T value, int seconds) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String str = beanToString(value);
			if (str == null || str.length() <= 0) {
				return false;
			}
			//生成真正的key
			String realKey = prefix + key;
			if (seconds <= 0) {
				jedis.set(realKey, str);
			} else {
				jedis.setex(realKey, seconds, str);
			}
			return true;
		} finally {
			release(jedis);
		}
	}

	public <T> boolean setNXEX(String prefix, final String key, final T req, int expire) {
		if (req == null) {
			return false;
		}
		if (expire <= 0) {
			throw new RuntimeException("[SET EX NX]必须设置超时时间");
		}
		final String realKey = prefix + key;
		String value = beanToString(req);
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			SetParams params = new SetParams();
			params.nx();
			params.ex(expire);
			String ret = jedis.set(realKey, value, params);
			return "OK".equals(ret);
		} catch (final Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			release(jedis);
		}
	}

	/**
	 * 判断key是否存在
	 */
	public <T> boolean exists(String prefix, String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			//生成真正的key
			String realKey = prefix + key;
			return jedis.exists(realKey);
		} finally {
			release(jedis);
		}
	}

	/**
	 * 删除
	 */
	public boolean delete(String prefix, String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			//生成真正的key
			String realKey = prefix + key;
			long ret = jedis.del(realKey);
			return ret > 0;
		} finally {
			release(jedis);
		}
	}

	/**
	 * 增加值
	 */
	public <T> Long incr(String prefix, String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			//生成真正的key
			String realKey = prefix + key;
			return jedis.incr(realKey);
		} finally {
			release(jedis);
		}
	}

	/**
	 * 减少值
	 */
	public <T> Long decr(String prefix, String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			//生成真正的key
			String realKey = prefix + key;
			return jedis.decr(realKey);
		} finally {
			release(jedis);
		}
	}

	public boolean delete(String prefix) {
		if (prefix == null) {
			return false;
		}
		List<String> keys = scanKeys(prefix);
		if (keys == null || keys.size() <= 0) {
			return true;
		}
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			jedis.del(keys.toArray(new String[0]));
			return true;
		} catch (final Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	public List<String> scanKeys(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			List<String> keys = new ArrayList<String>();
			String cursor = "0";
			ScanParams sp = new ScanParams();
			sp.match("*" + key + "*");
			sp.count(100);
			do {
				ScanResult<String> ret = jedis.scan(cursor, sp);
				List<String> result = ret.getResult();
				if (result != null && result.size() > 0) {
					keys.addAll(result);
				}
				//再处理cursor
				cursor = ret.getCursor();
			} while (!cursor.equals("0"));
			return keys;
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}
	}

	public static <T> String beanToString(T value) {
		if (value == null) {
			return null;
		}
		Class<?> clazz = value.getClass();
		if (clazz == int.class || clazz == Integer.class) {
			return "" + value;
		} else if (clazz == String.class) {
			return (String) value;
		} else if (clazz == long.class || clazz == Long.class) {
			return "" + value;
		} else {
			return JSON.toJSONString(value);
		}
	}

	/**
	 * String转实体类
	 *
	 * @param str
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	private <T> T stringToBean(String str, Class<T> clazz) {
		if (str == null || str.length() <= 0 || clazz == null) {
			return null;
		}
		if (clazz == int.class || clazz == Integer.class) {
			return (T) Integer.valueOf(str);
		} else if (clazz == String.class) {
			return (T) str;
		} else if (clazz == long.class || clazz == Long.class) {
			return (T) Long.valueOf(str);
		} else {
			return JSON.toJavaObject(JSON.parseObject(str), clazz);
		}
	}
}
