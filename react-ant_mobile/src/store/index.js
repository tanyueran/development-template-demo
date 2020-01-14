/**
 * @author tanxin
 * @date $
 * @Description: state
 */
import {createStore, combineReducers} from "redux";

import {userReducer} from './user/reducer.js'

export default createStore(combineReducers({
  userReducer,
}));
