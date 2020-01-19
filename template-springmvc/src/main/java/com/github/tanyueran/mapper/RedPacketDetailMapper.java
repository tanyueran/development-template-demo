package com.github.tanyueran.mapper;

import com.github.tanyueran.entity.RedPacket;
import com.github.tanyueran.entity.RedPacketDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RedPacketDetailMapper {
  // 添加红包
  void addRedPacketDetail(@Param("redPacketDetail") RedPacketDetail redPacketDetail);

  // 根据红包id查询详情
  List<RedPacketDetail> getAllRedPacketDetailByPacketId(RedPacket redPacket);

  // 根据红包id和用户id查询(不必有)红包详情，该用户已领取
  List<RedPacketDetail> getRedPacketDetailByPacketIdAndUserId(RedPacket redPacket);
}
