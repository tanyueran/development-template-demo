/**
 * @author tanxin
 * @date $
 * @Description:
 */
import request from '../utils/request.js';

const api = {
  getPrimaryKey: '/red/common/id',
  register: '/red/user/add',
  sendRedPacket: '/red/redpacket/send',
  gainRedPacket: '/red/redpacket/gain',
  getRedPacketDetailForGainInfo: '/red/redpacket/get'
};

// 获取id
export async function getPrimaryKey(num) {
  return request({
    method: 'get',
    url: api.getPrimaryKey + '/' + num,
  });
}

// 注册用户
export async function register(data) {
  return request({
    method: 'post',
    url: api.register,
    data,
  });
}

// 发红包
export async function sendRedPacket(data) {
  return request({
    method: 'post',
    url: api.sendRedPacket,
    data,
  });
}

// 抢红包
export async function gainRedPacket(data) {
  return request({
    method: 'post',
    url: api.gainRedPacket,
    data,
  })
}

// 查看红包领取情况
export async function getRedPacketDetailForGainInfo(packetId) {
  return request({
    method: 'get',
    url: api.getRedPacketDetailForGainInfo + "/" + packetId,
  });
}
