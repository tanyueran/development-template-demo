/**
 * @author tanxin
 * @date $
 * @Description:
 */
import React from 'react';
import {connect} from "react-redux";
import {numActionAsync} from "../../../store/page1/action";

let i = 1;

function Page1(props) {
  return <div style={{height: '100%'}}>
    page1
    <br/>
    <br/>
    <br/>
    <button onClick={props.click}>update num</button>
    <div>
      num:{props.num}
    </div>
  </div>
}

export default connect(
  (state) => {
    return {
      num: state.numReducer.num,
    }
  },
  (dispath) => {
    return {
      click: () => {
        dispath(numActionAsync(++i))
      },
    }
  }
)(Page1);
