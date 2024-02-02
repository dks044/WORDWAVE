import { combineReducers } from 'redux';
import auth from '../modules/auth';
import popup from '../modules/popup';

const rootReducer = combineReducers({auth,popup});

export default rootReducer;