import Vue from 'vue'
// cube-ui的组件
import './plugins/cube.js'
import store from './store/index.js'
import router from './router/index.js'

import App from './App.vue'
import filters from './filters/index.js'

import './style/index.scss'

// 项目环境
const HOST = process.env.NODE_ENV;
if (HOST === 'product') {
  Vue.config.productionTip = false;
} else {
  console.log(`===${HOST}`);
}

// 全局过滤器
for (const val in filters) {
  Vue.filter(val, filters[val]);
}
// 状态初始化
store.commit('init');

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app');
