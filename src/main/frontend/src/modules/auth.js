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

const FINDID = 'auth/FINDID';
const FINDID_SUCCESS = 'auth/FINDID_SUCCESS';
const FINDID_FAILURE = 'auth/FINDID_FAILURE';

const FINDPW = 'auth/FINDPW';
const FINDPW_SUCCESS = 'auth/FINDPW_SUCCESS';
const FINDPW_FAILURE = 'auth/FINDPW_FAILURE';

const CHANGEPW = 'auth/CHANGEPW';
const CHANGEPW_SUCCESS = 'auth/CHANGEPW_SUCCESS';
const CHANGEPW_FAILURE = 'auth/CHANGEPW_FAILURE';

const DELETE_USER = 'auth/DELETE_USER';
const DELETE_USER_SUCCESS = 'auth/DELETE_USER_SUCCESS';
const DELETE_USER_FAILURE = 'auth/DELETE_USER_FAILURE';

const SENDEMAIL_CODE = 'auth/SENDEMAIL_CODE';
const SENDEMAIL_CODE_SUCCESS = 'auth/SENDEMAIL_CODE_SUCCESS';
const SENDEMAIL_CODE_FAILURE = 'auth/SENDEMAIL_CODE_FAILURE';

const VALIDCODE = 'auth/VALIDCODE';
const VALIDCODE_SUCCESS = 'auth/VALIDCODE_SUCCESS';
const VALIDCODE_FAILURE = 'auth/VALIDCODE_FAILURE';



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
    throw e;
  }
}
export const findId = (email) => async dispatch => {
  dispatch({type : FINDID});
  try {
    const response = await authAPI.findidAPI(email);
    dispatch({type : FINDID_SUCCESS, payload: response.data});
    return response.data;
  } catch (e) {
    dispatch({type: FINDID_FAILURE, error: {message: e.message, code: e.code}});
    throw e;
  }
}

export const findPw = (userName,email) => async dispatch => {
  dispatch({type : FINDPW});
  try {
    const response = await authAPI.findPwAPI(userName,email);
    dispatch({type : FINDID_SUCCESS,payload : response.data});
    return response.data;
  } catch (e) {
    dispatch({type: FINDID_FAILURE, error: e});
    throw e;
  }
}

export const changePw = (password,newPassword) => async dispatch => {
  dispatch({ type : CHANGEPW });
  try {
    const response = await authAPI.changePwAPI(password,newPassword);
    dispatch({ type : CHANGEPW_SUCCESS, payload: response.data});
    return response.data;
  } catch (e) {
    if (e.response.status === 401) {//입력한 비밀번호와 원래비밀번호가 안맞을경우
      throw e;
    } else {
      dispatch({ type : CHANGEPW_FAILURE, error: e});
      throw e;
    }
  }
}

export const deleteUser = (email,password) => async dispatch => {
  dispatch({type : DELETE_USER});
  try {
    const response = await authAPI.deleteUserAPI(email,password);
    dispatch({type : DELETE_USER_SUCCESS, payload: response.data});
    return response.data;
  } catch (e) {
    if (e.response.status === 401) {//입력한 비밀번호와 이메일이 회원정보와 안맞을경우
      throw e;
    }else{
      dispatch({type : DELETE_USER_FAILURE, error : e});
      throw e;
    }
  }
}
export const sendEmailCode = (email) => async dispatch => {
  dispatch({type : SENDEMAIL_CODE});
  try {
    const response = await authAPI.sendEmailCodeAPI(email);
    dispatch({type : SENDEMAIL_CODE_SUCCESS,payload : response.data});
    return response.data;
  } catch (e) {
    if (e.response.status === 401) {//입력한 이메일이 데이터베이스에 이미 있을경우
      throw e;
    }else {
      dispatch({type : SENDEMAIL_CODE_FAILURE,error : e});
      throw e;
    }
  }
}

export const validEmailCode = (email,emailCode) => async dispatch => {
  dispatch({type : VALIDCODE});
  try {
    const response = await authAPI.validEmailCodeAPI(email,emailCode);
    dispatch({type : VALIDCODE_SUCCESS,payload: response.data});
    return response.data;
  } catch (e) {
    if (e.response.status === 401) {//인증코드를 잘못입력했을 경우
      throw e;
    }else {
      dispatch({type :VALIDCODE_FAILURE,error : e});
      throw e;
    }
  }
}




const initialState = {
  auth: reducerUtils.initial(),
  isLoging: false,
  user : reducerUtils.initial(),
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
        user: reducerUtils.initial(),
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
    case FINDID:
    case FINDID_SUCCESS:
    case FINDID_FAILURE:
      return handleAsyncActions(FINDID,'auth')(state,action);

    case FINDPW:
    case FINDPW_SUCCESS:
    case FINDPW_FAILURE:
      return handleAsyncActions(FINDPW,'auth')(state,action);
    case CHANGEPW:
    case CHANGEPW_SUCCESS:
    case CHANGEPW_FAILURE:
      return handleAsyncActions(CHANGEPW,'auth')(state,action);
    case DELETE_USER:
    case DELETE_USER_SUCCESS:
    case DELETE_USER_FAILURE:
      return handleAsyncActions(DELETE_USER,'auth')(state,action);
    case SENDEMAIL_CODE:
    case SENDEMAIL_CODE_SUCCESS:
    case SENDEMAIL_CODE_FAILURE:
      return handleAsyncActions(SENDEMAIL_CODE,'auth')(state,action);
    case VALIDCODE:
    case VALIDCODE_SUCCESS:
    case VALIDCODE_FAILURE:
      return handleAsyncActions(VALIDCODE,'auth')(state,action);
  }
}