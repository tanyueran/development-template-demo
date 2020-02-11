/**
 * @author tanxin
 * @date $
 * @Description: 布局页面
 */
import React from 'react';
import {withRouter, Route} from 'react-router-dom'
import {connect} from 'react-redux';
import {Layout, Menu, Icon} from 'antd';

import './index.scss';

const {Header, Footer, Sider, Content} = Layout;


class IndexPage extends React.Component {

  static stateToProps(state) {
    return {
      userInfo: state.userReducer
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
    if (this.props.userInfo.isLogin) {
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
          <div className="logo">
            logo
            {
              this.state.collapsed ? "" : "welcome to system"
            }
          </div>
          <Menu theme={"light"} defaultSelectedKeys={['1']}>
            <Menu.Item key="1">
              <Icon type="user"/>
              <span>nav 1</span>
            </Menu.Item>
            <Menu.Item key="2">
              <Icon type="video-camera"/>
              <span>nav 2</span>
            </Menu.Item>
            <Menu.Item key="3">
              <Icon type="upload"/>
              <span>nav 3</span>
            </Menu.Item>
          </Menu>
        </Sider>
        <Layout className={"app-content-wrapper"}>
          <Header style={{background: '#fff', padding: "0 10px",}}>
            <Icon
              className="trigger"
              type={this.state.collapsed ? 'menu-unfold' : 'menu-fold'}
              onClick={this.toggle}
            />
          </Header>
          <Content style={{background: "#fff", overflow: 'auto', margin: '20px 10px'}}>
            {
              this.props.routes.map((item, i) =>
                <Route exact={item.exact} path={item.path} key={i} render={props =>
                  <item.component {...props}/>
                }/>
              )
            }
          </Content>
          <Footer className={"text-center"}>hi</Footer>
        </Layout>
      </Layout>
    );
  }
}

/*
* 通过connect 引入store
* */
export default connect(IndexPage.stateToProps)(withRouter(IndexPage));
