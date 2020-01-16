package com.github.tanyueran.service.serviceImp;

import com.github.tanyueran.entity.RedPacket;
import com.github.tanyueran.mapper.RedPacketMapper;
import com.github.tanyueran.service.RedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedPacketServiceImp implements RedPacketService {
  @Autowired
  private RedPacketMapper redPacketMapper;

  @Override
  public void addRedPacket(RedPacket redPacket) {
    redPacketMapper.addRedPacket(redPacket);
  }

  @Override
  public RedPacketMapper getRedPacketById(String id) {
    return redPacketMapper.getRedPacketById(id);
  }

  @Override
  public void setRedPacketRestNum(Integer num) {
    redPacketMapper.setRedPacketRestNum(num);
  }
}
