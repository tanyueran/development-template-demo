import React from 'react';
import {render} from 'react-dom';
import {Provider} from 'react-redux';

import App from './App';
import store from './store/index.js'
import 'antd/dist/antd.css';
import './style/index.scss'

// 引入模拟数据模块
import './mock/index.js'

// 禁止react development tools
if (process.env.NODE_ENV !== 'development') {
  try {
    let funcList = window.__REACT_DEVTOOLS_GLOBAL_HOOK__;
    for (let f in funcList) {
      if (typeof funcList[f] == 'function') {
        funcList[f] = function () {
        }
      }
    }
  } catch (e) {
  }
}


render(
  <Provider store={store}>
    <App/>
  </Provider>,
  document.getElementById('root')
);
