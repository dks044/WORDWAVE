import { combineReducers } from 'redux';
import auth from '../modules/auth';
import popup from '../modules/popup';
import vocabook from '../modules/vocabook';

const rootReducer = combineReducers({auth,popup,vocabook});

export default rootReducer;