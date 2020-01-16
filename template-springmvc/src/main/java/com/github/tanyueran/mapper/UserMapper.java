package com.github.tanyueran.mapper;

import com.github.tanyueran.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
  List<User> getUserLit();

  User getUserByUsername(String username);

  void insertUser(@Param("user") User user);

}
