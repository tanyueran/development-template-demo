package com.github.tanyueran.service;

import com.github.tanyueran.entity.User;

import java.util.List;

public interface UserService {
  // 查询所有用户
  List<User> getAllUser();

  // 根据username查询用户
  User getUserByUsername(String username);

  // 添加用户
  void addUser(User user);
}
