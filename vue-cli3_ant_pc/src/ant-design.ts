/*
* 按需加载aut-design-vue的组件
* */
import Vue from 'vue';
import 'ant-design-vue/dist/antd.less'

import {
  Button,
  message,
  Skeleton,
  Spin,
  Form,
  Input,
  Alert,
  Table,
  Tabs,
} from 'ant-design-vue';

Vue.prototype.$message = message;

Vue.component(Button.name,Button);
// 骨架屏
Vue.component(Skeleton.name,Skeleton);
Vue.component(Spin.name,Spin);
Vue.component(Form.name,Form);
Vue.component(Input.name,Input);
Vue.component(Alert.name,Alert);
Vue.component(Table.name,Table);
Vue.component(Tabs.name,Tabs);
