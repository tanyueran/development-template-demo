package com.github.tanyueran.config;

import com.alibaba.fastjson.JSONObject;
import com.github.tanyueran.pojo.Result;
import com.github.tanyueran.session.RedisSessionDao;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义的认证过滤器，实现token认证
 */
public class TokenFilter extends AuthenticatingFilter {

    private static final String HEADER_PREFIX = "token";

    @Autowired
    @Qualifier("redisTemplate2")
    private RedisTemplate redisTemplate;

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(String.valueOf(req.getUserPrincipal()));
        token.setPassword(req.getHeader(HEADER_PREFIX).toCharArray());
        return token;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        String header = req.getHeader(HEADER_PREFIX);
        // 在redis中检测是否存在
        Object o = redisTemplate.opsForValue().get((RedisSessionDao.getKey(header)));
        if (o == null) {
            Result result = new Result();
            result.setCode(-100);
            result.setMsg("请登录");
            result.setObj(false);
            HttpServletResponse res = (HttpServletResponse) response;
            res.setContentType("application/json;charset=utf-8");
            String str = JSONObject.toJSONString(result);
            res.getWriter().write(str);
            return false;
        }
        return true;
    }
}
