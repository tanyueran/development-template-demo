/**
 * @author tanxin
 * @date $
 * @Description: user 的 action模块
 */
import {SET_USER,DEl_USER} from "./reducer";

export function set_user(value) {
  return {
    type: SET_USER,
    value,
  }
}

export function del_user() {
  return {
    type:DEl_USER,
  }
}
