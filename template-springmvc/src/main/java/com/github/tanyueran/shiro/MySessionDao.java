package com.github.tanyueran.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.SerializationUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * redis共享session。
 */
public class RedisSessionDao extends AbstractSessionDAO {

    @Autowired
    @Qualifier("redisTemplate2")// 这个redisTemplate只能是使用byte的，使用json的出错
    private RedisTemplate redisTemplate;

    // redis中session的前缀
    private static final String REDIS_SESSION_PREFIX = "template-spring-mvc-session:";

    public static byte[] getKey(String key) {
        return (REDIS_SESSION_PREFIX + key).getBytes();
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable serializable = generateSessionId(session);
        // 将生成的sessionId 和 当前的session进行捆绑
        assignSessionId(session, serializable);
        redisTemplate.opsForValue().set(getKey(serializable.toString()), SerializationUtils.serialize(session));
        return serializable;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        return (Session) SerializationUtils.deserialize((byte[]) redisTemplate.opsForValue().get(getKey(sessionId.toString())));
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        if (session != null) {
            // 会话过期没有必要更新了
            if (session instanceof ValidatingSession && ((ValidatingSession) session).isValid()) {
                return;
            }
            Serializable id = session.getId();
            redisTemplate.opsForValue().set(getKey(id.toString()), session);
        }
    }

    @Override
    public void delete(Session session) {
        if (session != null) {
            Serializable id = session.getId();
            redisTemplate.delete(getKey(REDIS_SESSION_PREFIX + id.toString()));
        }
    }

    @Override
    public Collection<Session> getActiveSessions() {
        Set<Session> set = redisTemplate.keys(REDIS_SESSION_PREFIX + "*");
        return set;
    }
}
