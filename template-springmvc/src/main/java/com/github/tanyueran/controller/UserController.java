package com.github.tanyueran.controller;

import com.github.tanyueran.entity.User;
import com.github.tanyueran.pojo.Result;
import com.github.tanyueran.service.serviceImp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServiceImp userService;

	// 获取所有用户
	@GetMapping("/list")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}

	// 根据id获取用户
	@GetMapping("/get/{username}")
	public User getUserByUsername(@PathVariable("username") String username) {
		return userService.getUserByUsername(username);
	}

	// 检测用户账号是否使用
	@GetMapping("/used/{username}")
	public Boolean userIsUsed(@PathVariable("username") String username) {
		if (userService.getUserByUsername(username) != null) {
			return true;
		}
		return false;
	}

	// 添加用户
	@PostMapping("/add")
	public Object addUser(@RequestBody @Valid User user) {
		// 检测账号是否使用
		if (userService.getUserByUsername(user.getUsername()) != null) {
			return Result.setError("该账号已被使用");
		}
		userService.addUser(user);
		return true;
	}
}
