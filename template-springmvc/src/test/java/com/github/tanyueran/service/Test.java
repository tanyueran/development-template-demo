package com.github.tanyueran.service;

import com.github.tanyueran.config.MyRealm;
import com.github.tanyueran.service.serviceImp.RedPacketServiceImp;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-*.xml"})
public class Test {

	private static Logger logger = Logger.getLogger(Test.class);

	@Autowired
	private RedPacketServiceImp redPacketServiceImp;

	@Autowired
	private RedisTemplate redisTemplate;

	// 测试shiro
	@org.junit.Test
	public void run() {
		DefaultSecurityManager manager = new DefaultSecurityManager();
		// 自定义realm
		MyRealm realm = new MyRealm();
		// 设置加密md5
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
		matcher.setHashAlgorithmName("md5");
		matcher.setHashIterations(1);
		realm.setCredentialsMatcher(matcher);
		manager.setRealm(realm);
		SecurityUtils.setSecurityManager(manager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("username", "password");
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			System.out.println(e.getMessage());
			System.out.println("账号或则密码错误");
		}
		System.out.println("isAuthenticated:" + subject.isAuthenticated());
		subject.checkRole("admin");
		subject.checkPermission("add");
	}


	// 测试redis
	@org.junit.Test
	public void run3() {
		SessionCallback<Object> callback = new SessionCallback<Object>() {
			@Override
			public Object execute(RedisOperations operations) throws DataAccessException {
				operations.opsForValue().set("key", "value");
				return null;
			}
		};
		redisTemplate.execute(callback);
	}

	// 测试redis
	@org.junit.Test
	public void run2() throws InterruptedException {
		redisTemplate.opsForValue().set("key", "value");
		redisTemplate.expire("key", 2, TimeUnit.SECONDS);
		Thread.currentThread().sleep(3000);
		Object key = redisTemplate.opsForValue().get("key");
		System.out.println(key);
	}

	// 测试
	@org.junit.Test
	public void run1() {
		List<Map> list = redPacketServiceImp.selectRedPacketList("1218797573624696832");
		System.out.println(list);
		System.out.println("================");
		logger.error(list);
	}
}
