/**
 * @author tanxin
 * @date $
 * @Description: user 的 reducer
 */
import Storage from '../../utils/storage.js'

// 设置登录信息
export const SET_USER = 'SET_USER';
export const DEl_USER = 'DEl_USER';
// 设置是否正在登录
export const SET_LOGIN_STATUS = 'SET_LOGIN_STATUS';


// 初始化值
let defaultValue = {
  loading: false,
  loginErr: '',
  userInfo: {
    id: null,
    username: null,
    isLogin: false,
    token: '',
  },
};

// 从缓存中取
let val = Storage.get('userInfo');
if (val !== null) {
  defaultValue.userInfo = val;
}

export function userReducer(state = defaultValue, action) {
  switch (action.type) {
    case SET_USER:
      let obj1 = Object.assign({}, state, {userInfo: action.value});
      Storage.set('userInfo', action.value);
      return obj1;

    case DEl_USER:
      let obj2 = Object.assign({});
      Storage.remove('userInfo');
      return obj2;

    case SET_LOGIN_STATUS:
      let obj = Object.assign({}, state, action.value);
      return obj;

    default:
      return state;
  }
}

