/**
 * @author tanxin
 * @date 2019/10/15
 * @Description: 存放全局的ajax请求地址
 */
import {PROXY_API} from "../constant";
import request from '../utils/request.js';

const api = {
  login: `${PROXY_API}/login`,
  // 获取用户信息
  getUserInfo: `${PROXY_API}/user/getUserInfo`,
};

// 登录
export async function login(data) {
  return request({
    url: api.login,
    method: 'post',
    data,
  })
}

// 获取用户信息
export async function getUserInfo() {
  return request({
    url: api.getUserInfo,
    method: 'get',
  })
}
