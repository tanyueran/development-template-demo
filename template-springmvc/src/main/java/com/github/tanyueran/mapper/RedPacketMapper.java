package com.github.tanyueran.mapper;

import com.github.tanyueran.entity.RedPacket;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RedPacketMapper {
  // 添加红包
  void addRedPacket(@Param("redPacket") RedPacket redPacket);

  // 根据id查询红包数据
  RedPacket getRedPacketById(@Param("id") String id);

  // 更新红包剩余数量
  Integer updateRedPacketRestNum(@Param("redPacket") RedPacket redPacket);
}
