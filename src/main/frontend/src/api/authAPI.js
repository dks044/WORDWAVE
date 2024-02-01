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

export async function signupApi(userName,password,email,phoneNumber){
  return await axios.post('/api/auth/signup',{userName,password,email,phoneNumber})
}

export async function findidAPI(email){
  return await axios.post('/api/auth/find_username',{email});
}

export async function findPwAPI(userName,email){
  return await axios.post('/api/auth//find_password',{userName,email})
}