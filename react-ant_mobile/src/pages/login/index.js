/**
 * @author tanxin
 * @date $
 * @Description: 登录页
 */
import React from 'react';
import {connect} from "react-redux";
import Schema from 'async-validator';
import {Button, Toast,} from "antd-mobile";
import './index.scss'

import logo from '../../images/logo.jpg'

import {set_user} from '../../store/user/action.js'
import {WhiteSpace} from "antd-mobile";


class LoginPage extends React.Component {

  constructor(props) {
    super(props);
    this.validator = new Schema(this.descriptor);
  }

  state = {
    username: '',
    password: '',
  };

  // 检验规则
  descriptor = {
    username: [
      {
        type: 'string',
        message: '用户名不可为空',
      },
      {
        type: 'string',
        required: true,
        message: '用户名不可为空',
      }
    ],
    password: [
      {
        type: 'string',
        required: true,
        message: '密码不可为空',
      }
    ],
  };

  // 校验器
  validator = null;

  loginHandler = () => {
    this.validator.validate(this.state).then(() => {
      this.props.dispatch(set_user({
        username: this.state.username,
        id: new Date().getTime(),
        isLogin: true,
      }));
      this.props.history.push('/app/page1')
    }).catch(({errors}) => {
      Toast.fail(errors[0].message);
    })
  };

  registerHandler = () => {
    this.props.history.push('/register')
  };

  render() {
    return (
      <div className='login-wrapper'>
        <h2 className='text-center'>
          welcome
          <img src={logo} alt="logo"/>
        </h2>
        <form>
          <p>
            <input onInput={e => this.setState({username: e.target.value})} placeholder={'请输入账号'} type="text"/>
          </p>
          <p>
            <input onInput={e => this.setState({password: e.target.value})} placeholder={'请输入密码'} type="password"/>
          </p>
          <p className='text-center'>
            <Button onClick={this.loginHandler} type="ghost" size="small">登录</Button>
          </p>
          <p className="text-center">
            or
          </p>
          <p className='text-center'>
            <Button onClick={this.registerHandler} to="/register" type="ghost" size="small">
              注册
            </Button>
          </p>
        </form>
      </div>
    );
  }
}

export default connect()(LoginPage);
