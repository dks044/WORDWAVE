import * as authAPI from '../api/authAPI';
import {
  reducerUtils,
  handleAsyncActions,
  handleAsyncActionsById,
} from '../lib/asyncUtils';

const LOGIN = 'auth/LOGIN_REQUEST';
const LOGIN_SUCCESS = 'auth/LOGIN_SUCCESS';
const LOGIN_FAILURE = 'auth/LOGIN_FAILURE';

const LOGOUT = 'auth/LOGOUT_REQUEST';
const LOGOUT_SUCCESS = 'auth/LOGOUT_SUCCESS';
const LOGOUT_FAILURE = 'auth/LOGOUT_FAILURE';

const IS_LOGGED_IN = 'auth/LOGGED_IN_REQUEST';
const IS_LOGGED_IN_SUCCESS = 'auth/LOGGED_IN_SUCCESS';
const IS_LOGGED_IN_FAILURE = 'auth/LOGGED_IN_FAILURE';

const USERINFO = 'auth/USERINFO_REQUEST';
const USERINFO_SUCCESS = 'auth/USERINFO_SUCCESS';
const USERINFO_FAILURE = 'auth/USERINFO_FAILURE';


export const login = (username, password) => async dispatch => {
  dispatch({ type: LOGIN });
  try {
    const response = await authAPI.loginApi(username, password);
    dispatch({ type: LOGIN_SUCCESS, payload: response.data });
    sessionStorage.setItem('isLoging', true);
    return response.data;
  } catch (e) {
    dispatch({ type: LOGIN_FAILURE, error: e });
    throw e;
  }
};

export const logout = () => async dispatch => {
  dispatch({ type: LOGOUT });
  try {
    const response = await authAPI.logoutApi();
    dispatch({ type: LOGOUT_SUCCESS, payload: response.data });
    sessionStorage.removeItem('isLoging');
    return response.data;
  } catch (e) {
    dispatch({ type: LOGOUT_FAILURE, error: e });
    throw e;
  }
};

export const isLoggedIn = () => async dispatch => {
  dispatch({ type : IS_LOGGED_IN });
  try {
    const response = await authAPI.validateTokenApi();
    dispatch({ type : IS_LOGGED_IN_SUCCESS, payload: response.data});
    sessionStorage.setItem('isLoging', true);
    return response.data;
  } catch (e) {
    dispatch({ type : IS_LOGGED_IN_FAILURE, error: e});
    throw e;
  }
}

export const userInfo = () => async dispatch => {
  dispatch({ type : USERINFO });
  try {
    const data = await authAPI.userInfoApi(); 
    console.log('data => '+data);  
    dispatch({type : USERINFO_SUCCESS,payload : data});
    return data;
  } catch (error) {
    dispatch({type : USERINFO_FAILURE,error: error});
    throw error; 
  }
}

const initialState = {
  auth: reducerUtils.initial(),
  isLoging: false,
  user : {}
};

export default function auth(state = initialState, action) {
  switch (action.type) {
    case LOGIN:
    case LOGIN_SUCCESS:
    case LOGIN_FAILURE:
      return {...handleAsyncActions(LOGIN, 'auth',true)(state, action),
      isLoging: action.type === LOGIN_SUCCESS ? true : state.isLoging
      }
    case LOGOUT:
    case LOGOUT_SUCCESS:
      return {
        ...handleAsyncActions(LOGOUT, 'auth')(state, action),
        isLoging: action.type === LOGOUT_SUCCESS ? false : state.isLoging,
        user : action.type === LOGOUT_SUCCESS ? null : state.user
      };
    case IS_LOGGED_IN:
    case IS_LOGGED_IN_SUCCESS:
    case IS_LOGGED_IN_FAILURE:
      return {
        ...handleAsyncActions(IS_LOGGED_IN, 'auth')(state, action),
        isLoging: action.type === IS_LOGGED_IN_SUCCESS ? true : state.isLoging
      };
    case USERINFO:
    case USERINFO_SUCCESS:
    case USERINFO_FAILURE:
      return {
        ...handleAsyncActions(USERINFO, 'user',true)(state, action),
        user : action.type === USERINFO_SUCCESS ? action.payload : state.user
      }
    default:
      return state;
  }
}