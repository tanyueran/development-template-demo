package com.github.tanyueran.controller;

import com.github.tanyueran.pojo.Result;
import com.github.tanyueran.service.serviceImp.UserServiceImp;
import com.github.tanyueran.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServiceImp userService;

	// 登录
	@PostMapping("/login")
	public Object login(@RequestBody com.github.tanyueran.vo.User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
		} catch (Exception e) {
			e.printStackTrace();
			Result result = new Result();
			result.setCode(-100);
			result.setMsg("账号密码错误");
			result.setObj(false);
			return result;
		}
		return subject.getSession().getId().toString();
	}

	// 登出
	@GetMapping("/logout")
	@RequiresRoles("user")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "登出成功";
	}

	// 获取所有用户
	@GetMapping("/list")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}

	// 根据id获取用户
	@GetMapping("/get/{userCode}")
	public User getUserByUsername(@PathVariable("userCode") String userCode) {
		return userService.getUserByUserCode(userCode);
	}

	// 检测用户账号是否使用
	@GetMapping("/used/{userCode}")
	public Boolean userIsUsed(@PathVariable("userCode") String userCode) {
		if (userService.getUserByUserCode(userCode) != null) {
			return true;
		}
		return false;
	}

	// 添加用户
	@PostMapping("/add")
	public Object addUser(@RequestBody @Valid User user) {
		// 检测账号是否使用
		if (userService.getUserByUserCode(user.getUserCode()) != null) {
			return Result.setError("该账号已被使用");
		}
		userService.addUser(user);
		return true;
	}
}
