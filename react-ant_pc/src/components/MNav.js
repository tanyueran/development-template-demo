/**
 * @author tanxin
 * @date $
 * @Description:
 */
import React from 'react';
import {withRouter} from 'react-router-dom'
import {Menu, Icon} from "antd";


class MNav extends React.Component {
  clickHandler = (val) => {
    this.props.history.push(val.key);
  };

  render() {
    return <Menu onClick={this.clickHandler} selectedKeys={this.props.location.pathname}>
      <Menu.Item key="/home/page1">
        <Icon type="user"/>
        <span>page 1</span>
      </Menu.Item>
      <Menu.Item key="/home/page2">
        <Icon type="video-camera"/>
        <span>page 2</span>
      </Menu.Item>
      <Menu.Item key="/home/page3">
        <Icon type="upload"/>
        <span>page 3</span>
      </Menu.Item>
    </Menu>
  }

}

export default withRouter(MNav);
