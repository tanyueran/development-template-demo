import React from 'react';
import {render} from 'react-dom';
import {Provider} from 'react-redux';

import App from './App';
import store from './store/index.js'

import './ant-ui.js'
import './style/index.scss'

render(
  <Provider store={store}>
    <App/>
  </Provider>,
  document.getElementById('root')
);
