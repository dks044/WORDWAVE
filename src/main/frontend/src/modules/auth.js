import * as authAPI from '../api/authAPI';
import {
  reducerUtils,
  handleAsyncActions,
} from '../lib/asyncUtils';

const LOGIN_REQUEST = 'auth/LOGIN_REQUEST';
const LOGIN_SUCCESS = 'auth/LOGIN_SUCCESS';
const LOGIN_FAILURE = 'auth/LOGIN_FAILURE';

const LOGOUT_REQUEST = 'auth/LOGOUT_REQUEST';
const LOGOUT_SUCCESS = 'auth/LOGOUT_SUCCESS';
const LOGOUT_FAILURE = 'auth/LOGOUT_FAILURE';

const IS_LOGGED_IN_REQUEST = 'auth/LOGGED_IN_REQUEST';
const IS_LOGGED_IN_SUCCESS = 'auth/LOGGED_IN_SUCCESS';
const IS_LOGGED_IN_FAILURE = 'auth/LOGGED_IN_FAILURE';

export const login = (username, password) => async dispatch => {
  dispatch({ type: LOGIN_REQUEST });
  try {
    const response = await authAPI.loginApi(username, password);
    dispatch({ type: LOGIN_SUCCESS, payload: response.data });
    return response.data;
  } catch (e) {
    dispatch({ type: LOGIN_FAILURE, error: e });
    throw e;
  }
};

export const logout = () => async dispatch => {
  dispatch({ type: LOGOUT_REQUEST });
  try {
    const response = await authAPI.logoutApi();
    dispatch({ type: LOGOUT_SUCCESS, payload: response.data });
    return response.data;
  } catch (e) {
    dispatch({ type: LOGOUT_FAILURE, error: e });
    throw e;
  }
};

export const isLoggenIn = () => async dispatch => {
  dispatch({ type : IS_LOGGED_IN_REQUEST });
  try {
    const response = await authAPI.validateTokenApi();
    dispatch({ type : IS_LOGGED_IN_SUCCESS, payload: response.data});
    return response.data;
  } catch (e) {
    dispatch({ type : IS_LOGGED_IN_FAILURE, error: e});
    throw e;
  }
}

const initialState = {
  auth: reducerUtils.initial(),
};

export default function auth(state = initialState, action) {
  switch (action.type) {
    case LOGIN_REQUEST:
    case LOGIN_SUCCESS:
    case LOGIN_FAILURE:
      return handleAsyncActions(LOGIN_REQUEST, 'auth')(state, action);
    case LOGOUT_REQUEST:
    case LOGOUT_SUCCESS:
    case LOGOUT_FAILURE:
      return handleAsyncActions(LOGOUT_REQUEST, 'auth')(state, action);
    case IS_LOGGED_IN_REQUEST:
    case IS_LOGGED_IN_SUCCESS:
    case IS_LOGGED_IN_FAILURE:
      return handleAsyncActions(IS_LOGGED_IN_REQUEST,'auth')
    
    default:
      return state;
  }
}