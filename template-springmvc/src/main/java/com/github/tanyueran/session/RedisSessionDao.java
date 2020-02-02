package com.github.tanyueran.session;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * redis实现的session操作
 */
public class RedisSessionDao extends AbstractSessionDAO {

	@Autowired
	private RedisTemplate redisTemplate;

	// redis中session的前缀
	private static final String REDIS_SESSION_PREFIX = "template-spring-mvc-session:";

	@Override
	protected Serializable doCreate(Session session) {
		Serializable serializable = generateSessionId(session);
		// 将生成的sessionId 和 当前的session进行捆绑
		assignSessionId(session, serializable);
		redisTemplate.opsForValue().set((REDIS_SESSION_PREFIX + serializable.toString()), JSONObject.toJSON(session));
		return serializable;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		if (sessionId == null) {
			return null;
		}
		JSONObject o = (JSONObject) redisTemplate.opsForValue().get(REDIS_SESSION_PREFIX + sessionId);
		if (o == null) {
			return null;
		}
		// todo :此处反序列化有问题
		Session session = (Session) (o.toJavaObject(Object.class));
		return session;
	}

	@Override
	public void update(Session session) throws UnknownSessionException {
		Serializable serializable = generateSessionId(session);
		redisTemplate.opsForValue().set((REDIS_SESSION_PREFIX + serializable.toString()), JSONObject.toJSON(session));
	}

	@Override
	public void delete(Session session) {
		Serializable id = session.getId();
		redisTemplate.delete((REDIS_SESSION_PREFIX + id));
	}

	@Override
	public Collection<Session> getActiveSessions() {
		Set<Session> set = redisTemplate.keys(REDIS_SESSION_PREFIX + "*");
		return set;
	}
}
