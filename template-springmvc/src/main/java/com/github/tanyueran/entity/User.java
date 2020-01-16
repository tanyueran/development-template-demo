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
  @NotEmpty(message = "username 不可为空")
  private String username;

  // 用户密码
  @NotEmpty(message = "password 不可为空")
  private String password;

  // 用户昵称
  @NotEmpty(message = "nickname 不可为空")
  private String nickname;

  // 创建日期
  @JSONField(format = "yyyy-MM-dd HH:mm:ss")
  private Date createTime;

  public User() {
  }

  @Override
  public String toString() {
    return "User{" +
      "id='" + id + '\'' +
      ", username='" + username + '\'' +
      ", password='" + password + '\'' +
      ", nickname='" + nickname + '\'' +
      ", createTime=" + createTime +
      '}';
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
