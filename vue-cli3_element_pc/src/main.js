import Vue from 'vue'
import store from './store/index.js'
import router from './router/index.js'

import App from './App.vue'
import './plugins/element.js'
import api from './api/index.js'
import filters from './common/filters/index.js'
import axios from './common/utils/axios.js'

import './style/index.scss'

// 项目环境
const HOST = process.env.NODE_ENV;

// 引入开发的模拟数据
if (HOST === 'development') {
  require('./dev/mock/index.js');
}

if (HOST === 'product') {
  Vue.config.productionTip = false;
} else {
  console.log(`===${HOST}`);
}

// 请求地址
Vue.prototype.$api = api;
// xhr库
Vue.prototype.$axios = axios;

// 全局过滤器
for (const val in filters) {
  Vue.filter(val, filters[val]);
}
// 状态初始化
store.commit('init');

new Vue({
  router,
  store,
  render: createElement => createElement(App),
}).$mount('#app');
