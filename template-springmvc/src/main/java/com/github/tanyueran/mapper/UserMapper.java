package com.github.tanyueran.mapper;

import com.github.tanyueran.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
	List<User> getUserLit();

	User getUserByUserCode(String userCode);

	void insertUser(@Param("user") User user);

	User getUserByUserCodeAndPassword(@Param("userCode") String userCode, @Param("password") String password);

}
