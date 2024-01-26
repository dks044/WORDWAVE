import axios from "axios";

export function loginApi(userName, password) {
  return axios.post('/api/auth/signin', { userName, password });
}

export function logoutApi(){
  return axios.post('/api/auth/signout');
}

export function validateTokenApi(){
  return axios.post('/api/auth/validateToken');
}

export function userNameApi(){
  return axios.post('/api/auth/username');
}