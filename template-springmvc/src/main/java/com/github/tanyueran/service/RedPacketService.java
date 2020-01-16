package com.github.tanyueran.service;

import com.github.tanyueran.entity.RedPacket;
import com.github.tanyueran.mapper.RedPacketMapper;

public interface RedPacketService {
  // 添加红包
  void addRedPacket(RedPacket redPacket);

  // 根据id查询红包数据
  RedPacketMapper getRedPacketById(String id);

  // 更新红包剩余数量
  void setRedPacketRestNum(Integer num);
}
