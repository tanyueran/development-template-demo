/**
 * @author tanxin
 * @date $
 * @Description: 登录页
 */
import React from 'react';
import Schema from 'async-validator';
import './index.scss'

import logo from '../../images/logo.jpg'


export default class RegisterPage extends React.Component {

  constructor(props) {
    super(props);
    this.validator = new Schema(this.descriptor);
  }

  state = {
    username: '',
    password: '',
    password2: '',
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
    password2: [
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
    this.props.history.replace('/login')
  };

  registerHandler = () => {
    this.validator.validate(this.state).then(() => {

    }).catch(({errors}) => {
      // Toast.fail(errors[0].message);
    })
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
          <p>
            <input onInput={e => this.setState({password: e.target.value})} placeholder={'请再次输入密码'} type="password"/>
          </p>
          <p className='text-center'>
            <button onClick={this.registerHandler} type="ghost" size="small">注册</button>
          </p>
          <p className='text-center'>
            已有账号
          </p>
          <p className='text-center'>
            <button onClick={this.loginHandler} type="ghost" size="small">登录</button>
          </p>
        </form>
      </div>
    );
  }
}
