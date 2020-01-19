package com.github.tanyueran.service.serviceImp;


import com.github.tanyueran.entity.User;
import com.github.tanyueran.mapper.UserMapper;
import com.github.tanyueran.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {
  @Autowired
  private UserMapper userMapper;

  @Override
  public List<User> getAllUser() {
    return userMapper.getUserLit();
  }

  @Override
  public User getUserByUsername(String username) {
    return userMapper.getUserByUsername(username);
  }

  @Override
  public void addUser(User user) {
    userMapper.insertUser(user);
  }
}
