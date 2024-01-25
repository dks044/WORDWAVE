import * as authAPI from '../api/authAPI';
import {
  createPromiseThunk,
  reducerUtils,
  handleAsyncActions,
} from '../lib/asyncUtils';

const LOGIN_REQUEST = 'auth/LOGIN_REQUEST';
const LOGIN_SUCCESS = 'auth/LOGIN_SUCCESS';
const LOGIN_FAILURE = 'auth/LOGIN_FAILURE';

const LOGOUT_REQUEST = 'auth/LOGOUT_REQUEST';
const LOGOUT_SUCCESS = 'auth/LOGOUT_SUCCESS';
const LOGOUT_FAILURE = 'auth/LOGOUT_FAILURE';

export const login = createPromiseThunk(LOGIN_REQUEST,authAPI.loginApi);
export const logout = createPromiseThunk(LOGOUT_REQUEST,authAPI.loginApi);

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