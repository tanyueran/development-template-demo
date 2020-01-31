package com.github.tanyueran.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

// 用户实体
public class User {
	// 主键
	@NotEmpty(message = "id 不可为空")
	private String id;

	// 用户账号
	@NotEmpty(message = "userCode 不可为空")
	private String userCode;

	// 用户密码
	@NotEmpty(message = "password 不可为空")
	private String password;

	// 用户昵称
	@NotEmpty(message = "username 不可为空")
	private String username;

	// 创建日期
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public User() {
	}

	public User(@NotEmpty(message = "id 不可为空") String id, @NotEmpty(message = "userCode 不可为空") String userCode, @NotEmpty(message = "password 不可为空") String password, @NotEmpty(message = "username 不可为空") String username, Date createTime) {
		this.id = id;
		this.userCode = userCode;
		this.password = password;
		this.username = username;
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "User{" +
			"id='" + id + '\'' +
			", userCode='" + userCode + '\'' +
			", password='" + password + '\'' +
			", username='" + username + '\'' +
			", createTime=" + createTime +
			'}';
	}
}
