// 兼容老ie
import React from 'react';
import {render} from 'react-dom';
import {Provider} from 'react-redux';
// 支持老ie
import "react-app-polyfill/ie9";
import "react-app-polyfill/stable.js";

import App from './App';
import store from './store/index.js'

import './style/index.scss'

// 禁止react development tools
if (process.env.NODE_ENV === 'development') {
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
