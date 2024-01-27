import axios from "axios";

export async function loginApi(userName, password) {
  return await axios.post('/api/auth/signin', { userName, password });
}

export async function logoutApi(){
  return await axios.post('/api/auth/signout');
}

export async function validateTokenApi(){
  return await axios.post('/api/auth/validateToken');
}

export async function userInfoApi(){
  return await axios.post('api/auth/userinfo');
}
