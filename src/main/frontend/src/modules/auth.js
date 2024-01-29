import axios from 'axios';
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

const SIGNUP = 'auth/SIGNUP';
const SIGNUP_SUCCESS = 'auth/SIGNUP_SUCCESS';
const SIGNUP_FAILURE = 'auth/SIGNUP/FAILURE';


export const login = (username, password) => async dispatch => {
  dispatch({ type: LOGIN });
  try {
    const response = await authAPI.loginApi(username, password);
    dispatch({ type: LOGIN_SUCCESS, payload: response.data });
    console.log(response.data);
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
    console.log('validate success');
    return response.data;
  } catch (e) {
    if (e.response && e.response.status === 401) {//비로그인 사용자 예외처리
      dispatch({ type: LOGOUT });
      console.log('비로그인 사용자임(토큰없음)');
    } else {
      dispatch({ type : IS_LOGGED_IN_FAILURE, error: e});
      throw e;
    }
  }
}

export const signUp = (userName,password,email,phoneNumber) => async dispatch => {
  dispatch({type : SIGNUP});
  try {
    const response = await authAPI.signupApi(userName,password,email,phoneNumber);
    dispatch({type : SIGNUP_SUCCESS,payload : response.data});
    return response.data;
  } catch (e) {
    dispatch({type: SIGNUP_FAILURE, error: e});
  }
}

const initialState = {
  auth: reducerUtils.initial(),
  isLoging: false,
  user : {},
};

export default function auth(state = initialState, action) {
  switch (action.type) {
    case LOGIN:
    case LOGIN_SUCCESS:
    case LOGIN_FAILURE:
      return {
        ...handleAsyncActions(LOGIN, 'auth',true)(state, action),
        isLoging: action.type === LOGIN_SUCCESS ? true : state.isLoging,
        user : action.type === LOGIN_SUCCESS ? action.payload : state.user,
      }
    case LOGOUT:
    case LOGOUT_SUCCESS:
      return {
        ...handleAsyncActions(LOGOUT, 'auth')(state, action),
        isLoging: false, 
        user: {},
        auth: reducerUtils.initial()
      };
    case IS_LOGGED_IN:
    case IS_LOGGED_IN_SUCCESS:
    case IS_LOGGED_IN_FAILURE:
      return {
        ...handleAsyncActions(IS_LOGGED_IN, 'auth')(state, action),
        isLoging: action.type === IS_LOGGED_IN_SUCCESS ? true : state.isLoging,
      };
    case SIGNUP:
    case SIGNUP_SUCCESS:
    case SIGNUP_FAILURE:
      return handleAsyncActions(SIGNUP,'auth')(state,action);
    default:
      return state;
  }
}