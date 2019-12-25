/**
 * @author tanxin
 * @date
 * @Description: 再次封装axios库
 */
import axios from 'axios';
import router from '../../router/index.js';
import store from '../../store/index';
//引入消息提示组件
import {Message} from 'element-ui';

const _axios = axios.create({
  timeout: 30000,
  retry: 3,// 超时重新请求数
  retryDelay: 100,// 超时重新请求延迟时间值
});

//配置axios
/*
* 请求拦截器
* */
_axios.interceptors.request.use((config) => {
  // 此处可以添加认证的token
  if (store.getters.get_isLogin) {
    config.headers.token = store.getters.get_userInfo.token;
  }

  return config;
}, (err) => {
  return Promise.reject(err);
});

/*
* 响应拦截器
* */
_axios.interceptors.response.use(
  (response) => {
    let data = response.data;
    /**
     * 判断是否成功
     */
    if (data.code != '100') {
      Message({
        type: 'error',
        message: data.msg || '本次请求后台出错了'
      });
    }
    // 对响应数据做点什么
    return Promise.resolve(data);

  }, (error) => {
    // 局部保存config
    let config = error.config;

    // 超时的处理
    if (error.message && error.message.toLocaleLowerCase().indexOf('timeout') > -1) {
      // 设置超时数目
      config.__retryCount = config.__retryCount || 0;
      if (config.__retryCount >= config.retry) {
        Message({
          type: 'error',
          message: '请求超时,请刷新页面重新请求 或 联系管理员'
        });
        return Promise.reject(error);
      }
      config.__retryCount += 1;
      let backoff = new Promise(resolve => {
        setTimeout(() => resolve(), config.retryDelay || 1);
      });
      return backoff.then(() => _axios(config));

    } else {
      // 对响应错误做点什么
      switch (error.response.status) {
        //处理后台响应的错误
        case 401:
          Message({
            type: 'error',
            message: '请登录后，再操作'
          });
          router.replace({
            path: '/login'
          });
          return Promise.reject(error);
        case 404:
          Message({
            type: 'error',
            message: '接口不存在，请联系管理员'
          });
          return Promise.reject(error);
        case 500:
          Message({
            type: 'error',
            message: '服务器出错啦，请求联系管理员',
          });
          return Promise.reject(error);
        default:
          Message({
            type: 'error',
            message: '未知错误'
          });
          return Promise.reject(error);
      }
    }
    return Promise.reject(error);
  });

export default _axios;


