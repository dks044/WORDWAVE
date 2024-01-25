import * as authAPI from '../api/authAPI';
import {
  reducerUtils,
  handleAsyncActions,
} from '../lib/asyncUtils';
import axios from 'axios';

const LOGIN_REQUEST = 'auth/LOGIN_REQUEST';
const LOGIN_SUCCESS = 'auth/LOGIN_SUCCESS';
const LOGIN_FAILURE = 'auth/LOGIN_FAILURE';

const LOGOUT_REQUEST = 'auth/LOGOUT_REQUEST';
const LOGOUT_SUCCESS = 'auth/LOGOUT_SUCCESS';
const LOGOUT_FAILURE = 'auth/LOGOUT_FAILURE';

export const login = (username, password) => async dispatch => {
  dispatch({ type: LOGIN_REQUEST });
  try {
    const response = await authAPI.loginApi(username, password);
    const token = response.data.token;
    localStorage.setItem('token', token);
    axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
    dispatch({ type: LOGIN_SUCCESS, payload: response.data });
  } catch (e) {
    dispatch({ type: LOGIN_FAILURE, error: e });
  }
};

export const logout = () => dispatch => {
  dispatch({ type: LOGOUT_REQUEST });
  try {
    localStorage.removeItem('token');
    delete axios.defaults.headers.common['Authorization'];
    dispatch({ type: LOGOUT_SUCCESS });
  } catch (e) {
    dispatch({ type: LOGOUT_FAILURE, error: e });
  }
};

const initialState = {
  auth: reducerUtils.initial()
};

export default function auth(state = initialState, action) {
  switch (action.type) {
    case LOGIN_REQUEST:
    case LOGIN_SUCCESS:
    case LOGIN_FAILURE:
      return handleAsyncActions(LOGIN_REQUEST, 'auth', true)(state, action);
    case LOGOUT_REQUEST:
    case LOGOUT_SUCCESS:
    case LOGOUT_FAILURE:
      return handleAsyncActions(LOGOUT_REQUEST, 'auth')(state, action);
    default:
      return state;
  }
}