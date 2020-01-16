package com.github.tanyueran.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

// 红包
public class RedPacket {
  // 主键
  @NotEmpty(message = "id 不可为空")
  private String id;

  //  发包者的id
  @NotEmpty(message = "发包者的id不可为空")
  private String user_id;

  //  红包总数
  @NotEmpty(message = "红包总数不可为空")
  @Size(min = 1, message = "红包总数至少一个")
  private Integer totalNum;

  //  剩余红包数
  @Size(min = 0, message = "红宝书至少一个")
  private Integer restNum;

  //  红包总金额
  @NotEmpty(message = "红包总金额")
  @Size(min = 0, message = "红包金额至少大于一分")
  private Double totalAmount;

  // 备注
  private String remark;

  //  创建时间
  @JSONField(format = "yyyy-MM-dd HH:mm:ss")
  private Date createTime;

  public RedPacket() {
  }

  @Override
  public String toString() {
    return "RedPacketMapper{" +
      "id='" + id + '\'' +
      ", user_id='" + user_id + '\'' +
      ", totalNum=" + totalNum +
      ", restNum=" + restNum +
      ", totalAmount=" + totalAmount +
      ", remark='" + remark + '\'' +
      ", createTime=" + createTime +
      '}';
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUser_id() {
    return user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public Integer getTotalNum() {
    return totalNum;
  }

  public void setTotalNum(Integer totalNum) {
    this.totalNum = totalNum;
  }

  public Integer getRestNum() {
    return restNum;
  }

  public void setRestNum(Integer restNum) {
    this.restNum = restNum;
  }

  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
