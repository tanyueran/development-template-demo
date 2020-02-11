/**
 * @author tanxin
 * @date $
 * @Description:
 */
import React from 'react'
import {Icon} from "antd";

let style = {
  position: 'fixed',
  top: 0,
  left: 0,
  right: 0,
  bottom: 0,
  display: 'flex',
  alignItems: 'center',
  justifyContent: 'center',
}

export default () => <div style={style}>
  <Icon type="loading" size="lg"/>
</div>
