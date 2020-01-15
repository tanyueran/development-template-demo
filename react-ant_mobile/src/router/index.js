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
    path: '/app',
    component: lazy(() => import('../pages/app/home/index.js')),
    children: [
      {
        path: '/app/page1',
        exact: true,
        component: lazy(() => import('../pages/app/home/page1/page1.js')),
      },
      {
        path: '/app/page2',
        exact: true,
        component: lazy(() => import('../pages/app/home/page2/page2.js')),
      },
      {
        path: '/app/page3',
        exact: true,
        component: lazy(() => import('../pages/app/home/page3/page3.js')),
      },
      {
        path: '/app/page4',
        exact: true,
        component: lazy(() => import('../pages/app/home/page4/page4.js')),
      },
      {
        component: notFoundPage,
      },
    ]
  },
  {
    component: notFoundPage,
  }
]
