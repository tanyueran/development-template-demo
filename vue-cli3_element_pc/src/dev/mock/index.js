/**
 * @author tanxin
 * @date $
 * @Description: 开发模式下的模拟数据
 */
import Mock from 'mockjs'
import template from './dateTemplate.js'
import api from '../../api/index'

Mock.setup({
  timeout: 300,
});

// 登录模拟
Mock.mock(api.login.login, 'post', template.login());
