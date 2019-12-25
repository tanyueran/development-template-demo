/**
 * @author tanxin
 * @date 2019/10/15
 * @desc 组件的状态文件
 **/
import Vue from 'vue';
import vuex from 'vuex';

import module1 from './module1/index.js'

Vue.use(vuex);
// 需要缓存的页面组件
const cacheList = ['page1', 'page2', 'page3'];

const state = {
  isLogin: false,
  // 需要缓存的数据
  cacheList: [],
  // 用户信息
  userInfo: {},
};

const getters = {
  get_isLogin: state => state.isLogin,
  // 用户信息
  get_userInfo: state => state.userInfo,
};

const mutations = {
  /*
  * 状态初始化
  * @dec:将一些需要存入sessionStorage的东西放置此处,用户手动刷新的时候统一从session取出，放置store中
  * */
  init() {
    // 是否登录
    const loginState = window.sessionStorage.getItem('isLogin');
    let isLogin = (loginState === '8888' ? true : loginState === '0' ? false : false);
    console.log('init');
    if (isLogin === true) { //用户已经登录
      Vue.set(state, 'isLogin', true);
      // 用户信息
      Vue.set(state, 'userInfo', JSON.parse(window.sessionStorage.getItem('userInfo')));
      // 设置缓存页面
      Vue.set(state, 'cacheList', [...cacheList]);
    } else {
      Vue.set(state, 'isLogin', false);
      Vue.set(state, 'userInfo', {});
    }
  },
  set_isLogin(state, val) {
    window.sessionStorage.setItem('isLogin', '8888');
    Vue.set(state, 'isLogin', val);
    // 设置缓存页面
    Vue.set(state, 'cacheList', [...cacheList]);
  },
  // 用户信息
  set_userInfo(state, val) {
    window.sessionStorage.setItem('userInfo', JSON.stringify(val));
    Vue.set(state, 'userInfo', JSON.stringify(val));
  },
  // 退出登录
  destroy() {
    window.sessionStorage.removeItem('userInfo');
    window.sessionStorage.removeItem('isLogin');
    Vue.set(state, 'userInfo', {});
    Vue.set(state, 'isLogin', false);
    Vue.set(state, 'cacheList', []);
  },
};

const actions = {};

export default new vuex.Store({
  state,
  getters,
  mutations,
  actions,
  modules: {
    module1,
  }
});
