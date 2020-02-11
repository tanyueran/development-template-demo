/**
 * @author tanxin
 * @date $
 * @Description:
 */
import request from '../utils/request.js';

const api = {
  getPrimaryKey: '/red/common/id',
  login: 'sd',
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

// 用户登录
export async function login(data) {
  return request({
    method: 'post',
    url: api.login,
    data,
  });
}