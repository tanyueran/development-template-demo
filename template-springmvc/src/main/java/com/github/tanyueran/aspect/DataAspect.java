package com.github.tanyueran.aspect;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
// 记录请求响应的数据报文
public class DataAspect {
	public static final Logger logger = LoggerFactory.getLogger(DataAspect.class);


	@Pointcut("execution(public * com.github.tanyueran.controller.*.*(..))")
	public void pointcut() {
	}

	@Around("pointcut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		String className = pjp.getTarget().getClass().getSimpleName();
		String name = pjp.getSignature().getName();
		String args = pjp.getArgs().toString();
		logger.info("<{}.{}>,请求参数:{}" + className + "name:" + name, args);
		Object ret = pjp.proceed();
		logger.info("响应数据:{}", JSONObject.toJSONString(ret));
		return ret;
	}

}
