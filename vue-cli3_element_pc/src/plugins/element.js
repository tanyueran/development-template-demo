/**
 * @author tanxin
 * @date 2019/10/15
 * @desc element-ui的组件按需引入
 **/
import Vue from 'vue'
import {
  Button,
  Form,
  FormItem,
  Input,
  Message,
  Avatar,
  Dropdown,
  DropdownItem,
  DropdownMenu,
  Menu,
  MenuItem,
  Submenu,
  Header,
  Aside,
  Container,
  Main,
  Footer,
  MenuItemGroup,
} from 'element-ui'

Vue.use(Button);
Vue.use(Form);
Vue.use(FormItem);
Vue.use(Input);
Vue.use(Avatar);
Vue.use(Dropdown);
Vue.use(DropdownItem);
Vue.use(DropdownMenu);
Vue.use(Menu);
Vue.use(MenuItem);
Vue.use(Submenu);
Vue.use(Header);
Vue.use(Aside);
Vue.use(Container);
Vue.use(Main);
Vue.use(Footer);
Vue.use(MenuItemGroup);

// 设置全局默认
Vue.prototype.$ELEMENT = {size: 'small'};

Vue.prototype.$message = Message;
