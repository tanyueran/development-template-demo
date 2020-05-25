/**
 * @author tanxin
 * @date $
 * @Description: 用户模拟的api请求
 */
import request from '../utils/request.js';

const api = {
  login: '/api/login',
  register: '/red/user/add',
  sendRedPacket: '/red/redpacket/send',
  gainRedPacket: '/red/redpacket/gain',
  getRedPacketDetailForGainInfo: '/red/redpacket/get'
};


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
