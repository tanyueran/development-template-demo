// 兼容老ie
import React from 'react';
import {render} from 'react-dom';
import {Provider} from 'react-redux';
import "react-app-polyfill/ie9";
import "react-app-polyfill/stable.js";

import App from './App';
import store from './store/index.js'

import './style/index.scss'

render(
  <Provider store={store}>
    <App/>
  </Provider>,
  document.getElementById('root')
);
