/**
 * @author tanxin
 * @date 2019/10/15
 * @desc element-ui的组件引入
 **/
import Vue from 'vue'
import {Button, Form, FormItem, Input, Message} from 'element-ui'

Vue.use(Button);
Vue.use(Form);
Vue.use(FormItem);
Vue.use(Input);

Vue.prototype.$message = Message;
