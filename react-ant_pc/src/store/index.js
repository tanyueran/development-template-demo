/**
 * @author tanxin
 * @date $
 * @Description: state
 */
import {createStore, combineReducers} from "redux";

import {userReducer} from './user/reducer.js'

const store = createStore(combineReducers({
  userReducer,
}));

export default store;
