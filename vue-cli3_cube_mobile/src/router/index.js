/**
 * @author tanxin
 * @date 2019/10/15
 * @desc 路由文件
 **/
import vue from 'vue';
import VueRouter from 'vue-router';
import store from '../store/index';
import {Toast} from 'cube-ui';

/*
* 解决路由跳转时出现的错误
* */
const originalPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
};

vue.use(VueRouter);

// 正在加载
const toastInstance = Toast.$create({
  type: 'loading',
  txt: '页面加载中...',
  time: 0,
});

const router = new VueRouter({
  routes: [
    // 登录
    {
      path: '/login',
      name: 'login',
      component: () => import('../pages/login/index.vue'),
      meta: {
        needLogin: false,
        title: '登录',
      }
    },
    // 注册
    {
      path: '/register',
      name: 'register',
      component: () => import('../pages/register/index.vue'),
      meta: {
        needLogin: false,
        title: '注册',
      }
    },
    // 主页
    {
      path: '/',
      redirect: 'home',
      component: () => import('../layout/index.vue'),
      children: [
        // 欢迎页
        {
          path: '/home',
          name: 'home',
          component: () => import('../pages/home/home.vue'),
          meta: {
            title: '首页',
            needLogin: true,
          }
        },
        {
          path: '/home/page1',
          name: 'page1',
          component: () => import('../pages/home/page1/index.vue'),
          meta: {
            title: 'page1',
            needLogin: true,
          }
        },
        {
          path: '/home/page2',
          name: 'page2',
          component: () => import('../pages/home/page2/index.vue'),
          meta: {
            title: 'page2',
            needLogin: true,
          }
        },
        {
          path: '/home/page3',
          name: 'page3',
          component: () => import('../pages/home/page3/index.vue'),
          meta: {
            title: 'page3',
            needLogin: true,
          }
        },
        // 404
        {
          path: '/home/404',
          component: () => import('../pages/notFound.vue'),
          meta: {
            needLogin: false,
            title: '404',
          }
        },
        // 监听404页面
        {
          path: '/home/*',
          redirect: '/home/404',
        },
      ]
    },
    //404页面
    {
      path: '/404',
      component: () => import('../pages/notFound.vue'),
      meta: {
        needLogin: false,
        title: '404',
      }
    },
    // 404
    {
      path: '/*',
      redirect: '/404',
    },
  ]
});

// 路由错误
router.onError(() => {

});

router.beforeEach((to, from, next) => {
  toastInstance.show();
  // 认证拦截
  if (to.meta.needLogin && !store.getters.get_isLogin) {
    return next({name: 'login',});
  }

  // 登录后不允许到登录页
  if (store.getters.get_isLogin && (to.name === 'login')) {
    return next({name: 'home'});
  }

  document.title = to.meta.title || '系统';
  return next();
});

router.afterEach(() => {
  vue.nextTick(() => {
    toastInstance.hide();
  });
});

export default router;
