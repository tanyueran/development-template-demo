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
  Icon,
  Input,
  Button,
  Checkbox,
  Typography,
} from 'antd';
import './index.scss';
import {login} from '../../api/user.js'

import {set_user} from '../../store/user/action.js'
import logo from "../../images/logo.jpg";

class LoginPage extends React.Component {
  constructor(props) {
    super(props);
  }

  state = {
    loading: false,
  };

  loginHandler = e => {
    e.preventDefault();
    this.props.form.validateFields((err, values) => {
      if (!err) {
        this.setState({
          loading: true,
        });

        message.info("登录成功！" + values);
        this.props.dispatch(set_user({
          id: '234',
          username: '234',
          isLogin: true,
          token: '234',
        }));
        this.props.history.push('/home');
        return;


        login(values).then(data => {
          message.info("登录成功！" + values);
          this.props.dispatch(set_user({
            id: '234',
            username: '234',
            isLogin: true,
            token: '234',
          }));
        }).catch(err => {

        }).finally(() => {
          this.setState({
            loading: false,
          })
        });
      }
    });
  };

  render() {
    const {getFieldDecorator} = this.props.form;
    return (
      <div className='login-wrapper'>
        <Typography.Title>
          welcome
          <img src={logo} alt="logo"/>
        </Typography.Title>
        <Form onSubmit={this.loginHandler}>
          <Form.Item>
            {getFieldDecorator('username', {
              rules: [{required: true, message: '请输入登录账号!'}],
            })(
              <Input
                autoComplete={"off"}
                prefix={<Icon type="user" style={{color: 'rgba(0,0,0,.25)'}}/>}
                placeholder="账号"
              />,
            )}
          </Form.Item>
          <Form.Item>
            {getFieldDecorator('password', {
              rules: [{required: true, message: '请输入账号密码!'}],
            })(
              <Input
                prefix={<Icon type="lock" style={{color: 'rgba(0,0,0,.25)'}}/>}
                type="password"
                placeholder="密码"
              />,
            )}
          </Form.Item>
          <Form.Item>
            {getFieldDecorator('remember', {
              valuePropName: 'checked',
              initialValue: true,
            })(<Checkbox>记住我</Checkbox>)}
            <a href="#" className={"right"} onClick={(e) => {
              e.preventDefault();
              message.info('请联系管理员')
            }}>
              忘记密码
            </a>
            <br/>
            <Button loading={this.state.loading} block type="primary" htmlType="submit">
              登录
            </Button>
            <br/>
            或 <a href="#" onClick={(e) => {
            e.preventDefault();
            this.props.history.push("register")
          }}>注册!</a>
          </Form.Item>
        </Form>
      </div>
    );
  }
}

export default connect()(Form.create({name: 'login-form'})(LoginPage));
