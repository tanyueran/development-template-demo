package com.github.tanyueran.service.serviceImp;

import com.github.tanyueran.entity.RedPacketDetail;
import com.github.tanyueran.mapper.RedPacketDetailMapper;
import com.github.tanyueran.service.RedPacketDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedPacketDetailServiceImp implements RedPacketDetailService {
  @Autowired
  private RedPacketDetailMapper redPacketDetailMapper;

  @Override
  public void addRedPacketDetail(RedPacketDetail redPacketDetail) {
    redPacketDetailMapper.addRedPacketDetail(redPacketDetail);
  }

  @Override
  public List<RedPacketDetail> getAllRedPacketDetailByPacketId(String redPacketId) {
    return redPacketDetailMapper.getAllRedPacketDetailByPacketId(redPacketId);
  }
}
