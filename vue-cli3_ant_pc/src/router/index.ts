import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue';
import Store from '../store/index';

Vue.use(VueRouter);

// 白名单
const WHRITE_LIST:string[] = [
  'login',
  'register',
];

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home,
  },
  {
    path: '/register',
    name: 'register',
    component: () => import('../views/user/register.vue'),
    meta: {
      title: '注册'
    }
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/user/login.vue'),
    meta: {
      title: '登录'
    }
  },
];

const router = new VueRouter({
  mode: 'history',
  routes,
});



router.beforeEach((to, from, next) => {
  Store.commit('set_is_loading',true);
  document.title = to.meta.title || '系统';
  return next();
});

router.afterEach(() => {
    Vue.nextTick(() => {
      Store.commit('set_is_loading',false);
    });
});

export default router;
