/**
 * @author tanxin
 * @date $
 * @Description: 布局页面
 */
import React from 'react';
import {withRouter, Route, Redirect} from 'react-router-dom'
import {connect} from 'react-redux';

import {
  Layout,
  Avatar,
  Row,
  Col,
  Dropdown,
  Menu,
  Switch,
  Tooltip,
} from 'antd';

import {
  UserOutlined,
  CaretDownOutlined,
  CaretUpOutlined,
  HomeOutlined,
  MenuUnfoldOutlined,
  MenuFoldOutlined,
  QuestionCircleOutlined,
} from '@ant-design/icons'

import MNav from '../../components/MNav.js';

import './index.scss';

const {Header, Footer, Sider, Content} = Layout;

class IndexPage extends React.Component {

  static stateToProps(state) {
    return {
      user: state.userReducer
    }
  }

  state = {
    collapsed: false,
  };

  toggle = () => {
    this.setState({
      collapsed: !this.state.collapsed,
    });
  };

  componentWillMount() {
    // 判断是否登录
    if (this.props.user.userInfo.isLogin) {
      if (this.props.location.pathname === '/') {
        this.props.history.replace('/app/page1');
      }
    } else {
      this.props.history.replace('/login');
    }
  }

  render() {
    return (
      <Layout className="app-wrapper">
        <Sider theme={"light"} trigger={null} collapsible collapsed={this.state.collapsed}>
          <div className="logo" style={{cursor: 'pointer'}} onClick={() => {
            this.props.history.push('/home')
          }}>
            <HomeOutlined style={{marginRight: '5px', fontSize: '18px'}}/>
            {
              this.state.collapsed ? "" : "welcome to system"
            }
          </div>
          <MNav/>
        </Sider>
        <Layout className={"app-content-wrapper"}>
          <Header style={{padding: "0 10px",}}>
            <Row type={"flex"}>
              <Col span={12}>
                {
                  this.state.collapsed ?
                    <MenuUnfoldOutlined onClick={this.toggle}/> :
                    <MenuFoldOutlined onClick={this.toggle}/>
                }
              </Col>
              <Col push={8} span={4} style={{justifyContent: 'center', display: 'flex', alignItems: 'center'}}>
                <Tooltip title={"使用说明"}>
                  <QuestionCircleOutlined style={{fontSize: '18px'}}/>
                </Tooltip>
                {/*头像*/}
                <Avatar style={{margin: "0 1em"}} size={"small"} icon={<UserOutlined/>}/>
                <Dropdown overlay={
                  <Menu>
                    <Menu.Item onClick={() => {
                      this.props.history.push('/home')
                    }}>个人中心</Menu.Item>
                    <Menu.Item>退出</Menu.Item>
                  </Menu>
                }>
                  <a style={{fontSize: "16px",}}>
                    {this.props.user.userInfo.username}
                    <CaretDownOutlined style={{marginLeft: "5px"}}/>
                  </a>
                </Dropdown>
              </Col>
            </Row>
          </Header>
          <Content className={"app-content-wrapper_box"}
                   style={{overflow: 'auto', margin: '20px 10px'}}>
            {
              this.props.routes.map((item, i) =>
                <Route exact={item.exact} path={item.path} key={i} render={props =>
                  <item.component {...props}/>
                }/>
              )
            }
            {/* 配置404*/}
            {
              this.props.routes.findIndex(item => item.path === this.props.location.pathname) === -1 ?
                < Redirect to="/home/404"/> : ""
            }
          </Content>
          <Footer className={"text-center"} style={{margin: "0 10px",}}>
            唯有阳光和绿茶最搭了！
          </Footer>
        </Layout>
      </Layout>
    );
  }
}

/*
* 通过connect 引入store
* */
export default connect(IndexPage.stateToProps)(withRouter(IndexPage));
