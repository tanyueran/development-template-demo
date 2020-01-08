import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    isLoading: true, // 页面是否正在加载
  },
  mutations: {
    set_is_loading(state, val) {
      Vue.set(state, 'isLoading', val);
    }
  },
  actions: {
  },
  modules: {
  },
});
