/**
 * @author tanxin
 * @date $
 * @Description: 测页面功能用户测试笔者的另一个spring mvc项目
 * 【https://github.com/tanyueran/development-template-demo/tree/master/template-springmvc】的抢红包
 */
import React from 'react';
import {Button} from "antd-mobile";
import {
  register,
  getPrimaryKey,
  sendRedPacket,
  gainRedPacket,
  getRedPacketDetailForGainInfo,
} from '../../../../api/page2.js'

export default class Page1 extends React.Component {
  idList = [];// id

  state = {
    detailList: [],
  };

  // 获取id
  componentWillMount() {
    getPrimaryKey(100).then((list) => {
      this.idList = list;
    }).catch(err => {
      console.log(err)
    });
  }

  // 注册
  registerHandler = () => {
    for (let i = 0; i < 100; i++) {
      register({
        id: this.idList[i],
        username: 'user' + i,
        password: 'password',
        nickname: '张' + i,
      })
    }
  };

  // 发红包
  sendRedPacketHandler = () => {
    sendRedPacket({
      id: this.idList[0],
      user_id: this.idList[0],
      totalNum: 100,
      totalAmount: 100,
      remark: '测试红包',
    });
  };

  // 抢红包
  gainRedPacketHandler = () => {
    let _this = this, i = 0;
    let timer = window.setInterval(() => {
      i++;
      gainRedPacket({
        packet_id: _this.idList[0],
        user_id: _this.idList[i],
        id: _this.idList[i],
      });
      if (i >= 99) {
        window.clearInterval(timer);
      }
    }, 10);
  };

  total = (list) => {
    let i = 0;
    list.map(item => {
      i += item.amout;
    });
    return i;
  };

  // 查询红包信息
  getRedPacketInfoHandler = () => {
    getRedPacketDetailForGainInfo(this.idList[0]).then(data => {
      this.setState({
        detailList: data,
      });
    }).catch(err => {
      console.log(err);
    });
  };


  render() {
    return <div style={{height: '100%', overflow: 'auto'}}>
      <br/>
      <Button inline type="primary" size={"small"} onClick={this.registerHandler}>1、开始注册</Button>
      <br/>
      <Button inline type="primary" size={"small"} onClick={this.sendRedPacketHandler}>2、发红包</Button>
      <br/>
      <Button inline type="primary" size={"small"} onClick={this.gainRedPacketHandler}>3、抢红包</Button>
      <br/>
      <Button inline type="primary" size={"small"} onClick={this.getRedPacketInfoHandler}>4、查询红包信息</Button>
      <br/>
      <div>
        <table border="true" style={{width: '100%'}}>
          <thead>
          <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>金额</th>
          </tr>
          </thead>
          <tbody>
          {
            this.state.detailList.map((item, index) => {
              return <tr key={item.id}>
                <td>{index + 1}</td>
                <td>{item.nickname}</td>
                <td>{item.amout}</td>
              </tr>
            })
          }
          </tbody>
        </table>
      </div>
      <p>
        总额
        {
          this.total(this.state.detailList)
        }
      </p>
    </div>
  }
}
