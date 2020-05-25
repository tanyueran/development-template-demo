/**
 * @author tanxin
 * @date $
 * @Description: user 的 action模块
 */
import {
  SET_USER,
  DEl_USER,
  SET_LOGIN_STATUS,
} from "./reducer";

// 请求的api
import {login} from "../../api/user.js";

export function set_user(value) {
  return {
    type: SET_USER,
    value,
  }
}

export function del_user() {
  return {
    type: DEl_USER,
  }
}

export function set_loading_status(val) {
  return {
    type: SET_LOGIN_STATUS,
    value: val,
  }
}

export function userLogin(data, func) {
  return dispatch => {
    dispatch(set_loading_status(true));
    set_loading_status(true);
    login(data).then(res => {
      // 登录成功
      dispatch(set_user(res));
      // 执行回调
      func();
    }).catch(err => {
    }).finally(() => {
      dispatch(set_loading_status(false));
    })
  }
}
