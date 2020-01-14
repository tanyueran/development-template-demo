/**
 * @author tanxin
 * @date $
 * @Description:
 */
import React from 'react';
import {withRouter} from 'react-router-dom'

import {TabBar} from 'antd-mobile';


class MNav extends React.Component {
  state = {
    selectedIndex: 0,
    itemList: [
      {
        badge: 0,
        dot: true,
        path: '/app/page1',
        icon: 'url(https://zos.alipayobjects.com/rmsportal/sifuoDUQdAFKAVcFGROC.svg) center center /  21px 21px no-repeat',
        selectedIcon: 'url(https://zos.alipayobjects.com/rmsportal/iSrlOTqrKddqbOmlvUfq.svg) center center /  21px 21px no-repeat',
        title: '新闻公告',
      },
      {
        badge: 2,
        dot: true,
        path: '/app/page2',
        icon: 'url(https://gw.alipayobjects.com/zos/rmsportal/BTSsmHkPsQSPTktcXyTV.svg) center center /  21px 21px no-repeat',
        selectedIcon: 'url(https://gw.alipayobjects.com/zos/rmsportal/ekLecvKBnRazVLXbWOnE.svg) center center /  21px 21px no-repeat',
        title: '个性发表',
      },
      {
        badge: 3,
        dot: true,
        path: '/app/page3',
        icon: 'url(https://zos.alipayobjects.com/rmsportal/psUFoAMjkCcjqtUCNPxB.svg) center center /  21px 21px no-repeat',
        selectedIcon: 'url(https://zos.alipayobjects.com/rmsportal/IIRLrXXrFAhXVdhMWgUI.svg) center center /  21px 21px no-repeat',
        title: '闲庭漫步',
      },
      {
        badge: 10,
        dot: true,
        path: '/app/page4',
        icon: 'url(https://gw.alipayobjects.com/zos/rmsportal/BTSsmHkPsQSPTktcXyTV.svg) center center /  21px 21px no-repeat',
        selectedIcon: 'url(https://gw.alipayobjects.com/zos/rmsportal/ekLecvKBnRazVLXbWOnE.svg) center center /  21px 21px no-repeat',
        title: '个人中心',
      },
    ]
  };

  barClickHandler(event, item, i) {
    this.props.history.replace(item.path);
  }

  render() {
    return <footer className={this.props.className} style={this.props.style}>
      <TabBar
        unselectedTintColor="#949494"
        tintColor="#33A3F4"
        barTintColor="white"
        tabBarPosition="bottom">
        {
          this.state.itemList.map((item, i) => <TabBar.Item
            title={item.title}
            key={i}
            icon={<div style={{
              width: '22px',
              height: '22px',
              background: item.icon,
            }}
            />
            }
            selectedIcon={<div style={{
              width: '22px',
              height: '22px',
              background: item.selectedIcon
            }}
            />
            }
            selected={this.props.location.pathname === item.path}
            badge={item.badge}
            onPress={(e) => {
              this.barClickHandler(e, item, i)
            }}
          >
          </TabBar.Item>)
        }
      </TabBar>
    </footer>
  }

}

export default withRouter(MNav);
