package com.github.tanyueran.controller;

import com.github.tanyueran.entity.RedPacket;
import com.github.tanyueran.entity.RedPacketDetail;
import com.github.tanyueran.exception.NoAmountException;
import com.github.tanyueran.pojo.Result;
import com.github.tanyueran.service.serviceImp.RedPacketServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redpacket")
public class RedPacketController {
  @Autowired
  private RedPacketServiceImp redPacketServiceImp;

  // 发红包
  @PostMapping("/send")
  public Boolean addRedPacket(@RequestBody RedPacket redPacket) {
    redPacketServiceImp.sendRedPacket(redPacket);
    return true;
  }

  // 抢红包
  @PostMapping("/gain")
  public Object gainRedPacket(@RequestBody RedPacketDetail redPacketDetail) throws Exception {
    RedPacketDetail detail = null;
    try {
      detail = redPacketServiceImp.gainRedPacket(redPacketDetail);
    } catch (Exception e) {
      if (e instanceof NoAmountException) {
        Result result = new Result();
        result.setCode(-100);
        result.setMsg(e.getMessage());
        return result;
      } else {
        throw e;
      }
    }
    return detail;
  }

  // 查询红包领取情况
  @GetMapping("/get/{redPackId}")
  public List<RedPacketDetail> getRedPacketDetail(@PathVariable("redPackId") String redPackId) {
    List<RedPacketDetail> list = redPacketServiceImp.selectRedPacketList(redPackId);
    return list;
  }


}
