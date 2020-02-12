/**
 * @author tanxin
 * @date $
 * @Description: 登录页
 */
import React from 'react';
import './index.scss'

import logo from '../../images/logo.jpg'
import {
  message,
  Form,
  Icon,
  Input,
  Button,
  Checkbox,
  Tooltip,
  Typography,
  Modal,
} from 'antd';

import MSiteAgreement from '../../components/MSiteAgreement.js'


class RegisterPage extends React.Component {
  state = {
    loading: false,
  };

  loginHandler = e => {
    e.preventDefault();
    this.props.form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        console.log('Received values of form: ', values);
      }
    });
  };

  render() {
    const {getFieldDecorator} = this.props.form;
    return (
      <div className='register-wrapper'>
        <Typography.Title>
          欢迎注册
          <img src={logo} alt="logo"/>
        </Typography.Title>
        <Form {...{
          labelCol: {span: 6},
          wrapperCol: {span: 14},
        }} onSubmit={this.loginHandler}>
          <Form.Item label={"账号"} hasFeedback>
            {getFieldDecorator('usercode', {
              rules: [{required: true, message: '请输入登录账号!'}],
            })(
              <Input
                autoComplete={"off"}
                placeholder="请输入登录账号"
              />,
            )}
          </Form.Item>
          <Form.Item label={"密码"} hasFeedback>
            {getFieldDecorator('password', {
              rules: [{required: true, message: '请输入账号密码!'}],
            })(
              <Input.Password
                placeholder="请输入账号密码"
              />,
            )}
          </Form.Item>
          <Form.Item label={"确认密码"} hasFeedback>
            {getFieldDecorator('password2', {
              rules: [{required: true, message: '请输入账号密码!'}],
            })(
              <Input.Password
                placeholder="请确认密码"
              />,
            )}
          </Form.Item>
          <Form.Item hasFeedback label={
            <span>
            用户姓名
              <Tooltip title="请输入您的姓名或者昵称?">
            <Icon type="question-circle-o"/>
            </Tooltip>
            </span>
          }>
            {getFieldDecorator('username', {
              rules: [{required: true, message: '请输入昵称!'}],
            })(
              <Input
                autoComplete={"off"}
                placeholder="请输入昵称"
              />,
            )}
          </Form.Item>
          <Form.Item wrapperCol={{span: 12, offset: 6}}>
            {
              getFieldDecorator('agreement', {
                rules: [{required: true, message: '请阅读!'}],
              })(
                <Checkbox>
                  阅读并接受<a onClick={
                  (e) => {
                    e.preventDefault();
                    Modal.info({
                      title: '网站用户协议',
                      width: '500px',
                      content: <MSiteAgreement/>,
                      okText: '确定',
                    })
                  }
                }>《网站用户协议》</a>
                </Checkbox>
              )
            }
          </Form.Item>
          <Form.Item wrapperCol={{span: 12, offset: 6}}>
            <Button loading={this.state.loading} type="primary" htmlType="submit">
              注册
            </Button>
            <br/>
            已有帐号<a href="#" onClick={(e) => {
            e.preventDefault();
            this.props.history.push("login")
          }}>登录!</a>
          </Form.Item>
        </Form>
      </div>
    );
  }
}

export default Form.create()(RegisterPage)