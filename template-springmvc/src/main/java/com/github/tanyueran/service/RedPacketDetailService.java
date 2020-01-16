package com.github.tanyueran.service;


import com.github.tanyueran.entity.RedPacketDetail;

import java.util.List;

public interface RedPacketDetailService {
  // 添加红包
  void addRedPacketDetail(RedPacketDetail redPacketDetail);

  // 根据红包id查询详情
  List<RedPacketDetail> getAllRedPacketDetailByPacketId(String redPacketId);
}
