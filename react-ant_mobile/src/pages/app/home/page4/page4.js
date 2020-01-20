/**
 * @author tanxin
 * @date $
 * @Description:
 */
import React from 'react';
import {connect} from "react-redux";
import {Card, WingBlank, WhiteSpace, Button, Modal} from 'antd-mobile'

import {del_user} from "../../../../store/user/action";
import img from '../../../../images/logo.jpg'

class Page1 extends React.Component {

  logoutHandler = () => {
    Modal.alert('提示', '您确定退出吗？', [
      {
        text: '取消', onPress: () => {
        }, style: 'default'
      },
      {
        text: '确定', onPress: () => {
          this.props.history.replace('/login');
          this.props.dispatch(del_user())
        }
      },
    ]);
  }

  render() {
    return <div style={{height: '100%'}}>
      <WingBlank size="lg">
        <WhiteSpace size="lg"/>
        <Card>
          <Card.Header
            title="怪盗基德"
            thumb={<img style={{width: '60px', height: 'auto'}} src={img}></img>}
            extra={<span>this is extra</span>}
          />
          <Card.Body>
            <div>This is content of `Card`</div>
          </Card.Body>
          <Card.Footer content="footer content" extra={<div>extra footer content</div>}/>
        </Card>
        <WhiteSpace size="lg"/>
        <Button onClick={this.logoutHandler}>退出登录</Button>
        <WhiteSpace/>
      </WingBlank>
    </div>
  }
}

export default connect()(Page1);

