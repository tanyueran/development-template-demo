/**
 * @author tanxin
 * @date $
 * @Description: user 的 reducer
 */
import Storage from '../../utils/storage.js'

export const SET_USER = 'SET_USER';
export const DEl_USER = 'DEl_USER';

// 初始化值
let defaultValue = {
  id: null,
  username: null,
  isLogin: false,
  token: '',
};

// 从缓存中取
let val = Storage.get('userInfo');
if (val !== null) {
  defaultValue = val;
}


export function userReducer(state = defaultValue, action) {
  switch (action.type) {
    case SET_USER:
      let obj1 = Object.assign({}, state, action.value);
      Storage.set('userInfo', obj1);
      return obj1;

    case DEl_USER:
      let obj2 = Object.assign({});
      Storage.remove('userInfo');
      return obj2;

    default:
      return state;
  }
}
