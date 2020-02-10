package com.github.tanyueran.shiro;

import com.github.tanyueran.entity.User;
import com.github.tanyueran.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

	@Autowired
	private UserMapper userMapper;

	// 认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 注意：仅仅用账号去查询用户信息，然后获取盐、密码等，给shiro去匹对
		String username = (String) token.getPrincipal();
		User user = userMapper.getUserByUserCode(username);
		if (user == null) {
			throw new AuthenticationException("用户名或者密码不正确");
		}
		return new SimpleAuthenticationInfo(username, user.getPassword(), getName());
	}

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("执行了======================授权");
		String username = (String) principals.getPrimaryPrincipal();
		// 通过用户名查询权限
		Set<String> roles = getUserRolesByUsername(username);
		// 通过用户名查询角色
		Set<String> principal = getUserPrincipalByUsername(username);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setRoles(roles);
		// 设置用户的权限
		info.setStringPermissions(principal);
		return info;
	}

	private Set<String> getUserRolesByUsername(String username) {
		Set<String> set = new HashSet<>();
		set.add("admin");
		set.add("basic-user");
		return set;
	}

	// 通过用户查询权限
	private Set<String> getUserPrincipalByUsername(String username) {
		Set<String> set = new HashSet<>();
		set.add("add");
		return set;
	}
}
