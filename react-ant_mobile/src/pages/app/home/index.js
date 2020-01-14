/**
 * @author tanxin
 * @date $
 * @Description:
 */
import React from 'react';
import {withRouter, Route} from 'react-router-dom'
import {connect} from 'react-redux';

import MNav from '../../../components/MNav.js'
import './index.scss'


class IndexPage extends React.Component {

  static stateToProps(state) {
    return {
      userInfo: state.userReducer
    }
  }

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
      <div className="app-wrapper">
        <section>
          {
            this.props.routes.map((item, i) =>
              <Route exact={item.exact} path={item.path} key={i} render={props =>
                <item.component {...props}/>
              }/>
            )
          }
        </section>
        <MNav style={{position: 'fixed', bottom: 0, right: 0, left: 0, zIndex: 100, background: "#fff"}}/>
      </div>
    );
  }
}

/*
* 通过connect 引入store
* */
export default connect(IndexPage.stateToProps)(withRouter(IndexPage));
