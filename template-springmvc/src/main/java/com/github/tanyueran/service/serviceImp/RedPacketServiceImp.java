package com.github.tanyueran.service.serviceImp;

import com.github.tanyueran.entity.RedPacket;
import com.github.tanyueran.entity.RedPacketDetail;
import com.github.tanyueran.exception.NoAmountException;
import com.github.tanyueran.mapper.RedPacketDetailMapper;
import com.github.tanyueran.mapper.RedPacketMapper;
import com.github.tanyueran.service.RedPacketService;
import com.github.tanyueran.utils.RedPacketAmountRandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RedPacketServiceImp implements RedPacketService {

	@Autowired
	private RedPacketMapper redPacketMapper;

	@Autowired
	private RedPacketDetailMapper redPacketDetailMapper;

	@Autowired
	private RedisTemplate redisTemplate;

	/*
	 * 发红包
	 * */
	@Override
	public void sendRedPacket(RedPacket redPacket) {
		// 判断红包个数
		if (redPacket.getTotalNum() < 1) {
			throw new RuntimeException("红包总数不能小于1");
		}
		// 判断红包金额
		if (redPacket.getTotalAmount() < 0.01) {
			throw new RuntimeException("红包总金额不能小于0.01");
		}
		// 判断红包的平均数不能小于0.01
		if ((redPacket.getTotalAmount() / redPacket.getTotalNum()) < 0.01) {
			throw new RuntimeException("红包平均数据不能小于0.01");
		}
		redPacket.setVersion(0);
		// 剩余个数默认为总数
		redPacket.setRestNum(redPacket.getTotalNum());
		redPacketMapper.addRedPacket(redPacket);
	}

	/*
	 * 抢红包
	 * */
	@Override
	public RedPacketDetail gainRedPacket(RedPacketDetail redPacketDetail) throws Exception {
		// 查询红包信息
		RedPacket redPacket = redPacketMapper.getRedPacketById(redPacketDetail.getPacket_id());
		if (redPacket == null) {
			throw new RuntimeException("该红包不存在");
		}
		// 是否还有剩余红包
		if (redPacket.getRestNum() <= 0) {
			throw new NoAmountException("红包已抢完");
		}
		// 查询是否领取
		RedPacket packetForIsGet = new RedPacket();
		packetForIsGet.setUser_id(redPacketDetail.getUser_id());
		packetForIsGet.setId(redPacketDetail.getPacket_id());
		List<RedPacketDetail> list = redPacketDetailMapper.getRedPacketDetailByPacketIdAndUserId(packetForIsGet);
		if (list.size() > 0) {
			throw new RuntimeException("您已经领取了");
		}
		// 获取所有的的数据
		RedPacket packetForAll = new RedPacket();
		packetForAll.setId(redPacket.getId());
		List<Map> list1 = redPacketDetailMapper.getAllRedPacketDetailByPacketId(packetForAll);
		double sum = 0;
		for (int i = 0; i < list1.size(); i++) {
			sum += (double) list1.get(i).get("amout");
		}
		// 剩余金额
		double remainMoney = redPacket.getTotalAmount() - sum;
		double amount = RedPacketAmountRandomUtils.randomNum(redPacket.getRestNum(), remainMoney);
		System.out.println("======================================");
		System.out.println("剩余个数：" + redPacket.getRestNum() + "剩余金额：" + remainMoney + "领的金额:" + amount);
		// 红包随机数
		redPacketDetail.setAmout(amount);
		redPacketDetail.setCreateTime(new Date());
		// 入库
		redPacketDetailMapper.addRedPacketDetail(redPacketDetail);

		// 更新红包剩余数
		RedPacket packetForUpdate = new RedPacket();
		packetForUpdate.setId(redPacket.getId());
		packetForUpdate.setVersion(redPacket.getVersion());
		Integer val = redPacketMapper.updateRedPacketRestNum(packetForUpdate);
		if (val == 0) {
			throw new RuntimeException("抢红包失败");
		}
		return redPacketDetail;
	}

	/*
	 * 获取红包领取情况
	 * */
	@Override
	public List<Map> selectRedPacketList(String redPacketId) {
		RedPacket packet = new RedPacket();
		packet.setId(redPacketId);
		packet.setUser_id(null);
		List<Map> list = redPacketDetailMapper.getAllRedPacketDetailByPacketId(packet);
		return list;
	}
}
