/**
 * @author tanxin
 * @date $
 * @Description: 登录页
 */
import React from 'react';
import {connect} from "react-redux";
import {
  message,
  Form,
  Input,
  Button,
  Checkbox,
  Typography,
} from 'antd';

import {
  UserOutlined,
  LockOutlined,
} from '@ant-design/icons'

import './index.scss';

import {userLogin} from '../../store/user/action.js'

import logo from "../../images/logo.jpg";

class LoginPage extends React.Component {
  static stateToProps(state) {
    return {
      user: state.userReducer
    }
  }

  loginHandler = values => {
    this.props.dispatch(userLogin(values, () => {
      message.success('登录成功!');
      this.props.history.push("/home")
    }));
  };

  render() {
    return (
      <div className='login-wrapper'>
        <Typography.Title>
          welcome
          <img src={logo} alt="logo"/>
        </Typography.Title>
        <Form onFinish={this.loginHandler}>
          <Form.Item name={"username"} rules={[{required: true, message: '请输入登录账号!'}]}>
            <Input
              autoComplete={"off"}
              prefix={<UserOutlined style={{color: 'rgba(0,0,0,.25)'}}/>}
              placeholder="账号"
            />
          </Form.Item>
          <Form.Item name={'password'} rules={[{required: true, message: '请输入账号密码!'}]}>
            <Input
              prefix={<LockOutlined style={{color: 'rgba(0,0,0,.25)'}}/>}
              type="password"
              placeholder="密码"
            />
          </Form.Item>
          <Form.Item>
            <div style={{marginBottom: '8px'}}>
              <Checkbox name={'remember'}>记住我</Checkbox>
              <a href="#" className={"right"} onClick={(e) => {
                e.preventDefault();
                message.info('请联系管理员')
              }}>
                忘记密码
              </a>
            </div>
            <Button loading={this.props.user.loading} block type="primary" htmlType="submit">
              登录
            </Button>
            <br/>
            <div style={{marginBottom: '8px'}}>
              或 <a href="#" onClick={(e) => {
              e.preventDefault();
              this.props.history.push("/register")
            }}>注册!</a>
            </div>
          </Form.Item>
        </Form>
      </div>
    );
  }
}

export default connect(LoginPage.stateToProps)(LoginPage);
