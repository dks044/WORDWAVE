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
  return await axios.post('/api/auth/find_password',{userName,email})
}

export async function changePwAPI(password,newPassword){
  return await axios.post('/api/auth/change_password',{password,newPassword});
}

export async function deleteUserAPI(email,password){
  return await axios.post('/api/auth/delete_user',{email,password});
}

export async function sendEmailCodeAPI(email){
  return await axios.post('api/auth/send_authenticateCode',{email});
}

export async function validEmailCodeAPI(email,emailCode){
  return await axios.post('api/auth/authenticateCode',{email,emailCode});
}