/**
 * @author tanxin
 * @date $
 * @Description: 模拟返回的数据
 */
import mock from 'mockjs';

const tempalte = {
  ok(data) {
    return {
      code: '000000',
      msg: 'ok',
      data,
    }
  },
  no() {
    return {
      code: -100,
      msg: 'error',
      data: {}
    }
  }
};

const obj = {
  // 登录
  login() {
    return tempalte.ok({
      username: mock.mock('@first'),
      name: mock.mock('@cname'),
      token: mock.mock('@guid'),
    });
  },
};

export default obj;
