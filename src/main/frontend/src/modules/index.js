import { combineReducers } from 'redux';
import auth from '../modules/auth';
import popup from '../modules/popup';
import voca from '../modules/voca';

const rootReducer = combineReducers({auth,popup,voca});

export default rootReducer;