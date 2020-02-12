/**
 * @author tanxin
 * @date $
 * @Description: 路由配置信息
 */
import {lazy} from 'react'

const loginPage = lazy(() => import('../pages/login/index.js'));
const notFoundPage = lazy(() => import('../pages/notFound/index.js'));

export default [
  {
    path: '/',
    exact: true,
    component: loginPage,
  },
  {
    path: '/login',
    exact: true,
    component: loginPage,
  },
  {
    path: '/register',
    exact: true,
    component: lazy(() => import('../pages/register/index.js')),
  },
  {
    component: lazy(() => import('../pages/home/index.js')),
    children: [
      {
        path: '/home',
        exact: true,
        component: lazy(() => import('../pages/home/index/index.js')),
      },
      {
        path: '/home/page1',
        exact: true,
        component: lazy(() => import('../pages/home/page1/index.js')),
      },
      {
        path: '/home/page2',
        exact: true,
        component: lazy(() => import('../pages/home/page2/index.js')),
      },
      {
        path: '/home/page3',
        exact: true,
        component: lazy(() => import('../pages/home/page3/index.js')),
      },
      {
        path: '/home/404',
        component: notFoundPage,
      },
    ]
  },
  {
    component: notFoundPage,
  }
]
