package com.github.tanyueran.service;

import com.github.tanyueran.entity.RedPacket;
import com.github.tanyueran.entity.RedPacketDetail;
import com.github.tanyueran.exception.NoAmountException;

import java.util.List;
import java.util.Map;

// 抢红包业务模块
public interface RedPacketService {
  // 发红包
  void sendRedPacket(RedPacket redPacket);

  // 抢红包
  RedPacketDetail gainRedPacket(RedPacketDetail redPacketDetail) throws Exception;

  // 根据红包id查询红包领取情况
  List<Map> selectRedPacketList(String redPacketId);
}
