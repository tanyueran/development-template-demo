package com.github.tanyueran.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RedPacket {
  // 添加红包
  void addRedPacket(@Param("redPacket") RedPacket redPacket);

  // 根据id查询红包数据
  RedPacket getRedPacketById(@Param("id") String id);

  // 更新红包剩余数量
  void setRedPacketRestNum(@Param("num") Integer num);
}
