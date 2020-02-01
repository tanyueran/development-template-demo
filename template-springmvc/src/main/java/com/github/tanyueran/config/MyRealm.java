package com.github.tanyueran.config;

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
		String username = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		// 查询数据库，看账号密码是否正确
		if (!username.equals("username")) {
			throw new UnknownAccountException();
		}
		if (!password.equals("password")) {
			throw new IncorrectCredentialsException();
		}

		return new SimpleAuthenticationInfo(username, password, getName());
	}

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
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
