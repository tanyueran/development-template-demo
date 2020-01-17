package com.github.tanyueran.service.serviceImp;

import com.github.tanyueran.entity.RedPacket;
import com.github.tanyueran.entity.RedPacketDetail;
import com.github.tanyueran.exception.NoAmountException;
import com.github.tanyueran.mapper.RedPacketDetailMapper;
import com.github.tanyueran.mapper.RedPacketMapper;
import com.github.tanyueran.service.RedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Service
public class RedPacketServiceImp implements RedPacketService {

  @Autowired
  private RedPacketMapper redPacketMapper;

  @Autowired
  private RedPacketDetailMapper redPacketDetailMapper;

  /*
   * 发红包
   * */
  @Override
  public void sendRedPacket(RedPacket redPacket) {
    redPacket.setVersion(0);
    // 剩余个数默认为总数
    redPacket.setRestNum(redPacket.getTotalNum());
    redPacketMapper.addRedPacket(redPacket);
  }

  /*
   * 抢红包
   * */
  @Override
  @Transactional()
  public RedPacketDetail gainRedPacket(RedPacketDetail redPacketDetail) throws Exception {
    // 查询红包信息
    RedPacket redPacket = redPacketMapper.getRedPacketById(redPacketDetail.getPacket_id());
    // 是否还有剩余红包
    if (redPacket.getRestNum() <= 0) {
      throw new NoAmountException("红包已抢完");
    }
    // todo：查询该用户是否已经领取

    redPacketDetail.setAmout(Math.floor(redPacket.getTotalAmount() / redPacket.getTotalNum()));
    redPacketDetail.setCreateTime(new Date());
    // 入库
    redPacketDetailMapper.addRedPacketDetail(redPacketDetail);
    // 更新红包剩余数
    RedPacket newRedPacket = new RedPacket();
    newRedPacket.setId(redPacketDetail.getPacket_id());
    newRedPacket.setVersion(redPacket.getVersion());
    Integer val = redPacketMapper.updateRedPacketRestNum(newRedPacket);
    if (val == 0) {
      throw new RuntimeException("抢红包失败");
    }
    return redPacketDetail;
  }

  /*
   * 获取红包领取情况
   * */
  @Override
  public List<RedPacketDetail> selectRedPacketList(String redPacketId) {
    return redPacketDetailMapper.getAllRedPacketDetailByPacketId(redPacketId);
  }
}
