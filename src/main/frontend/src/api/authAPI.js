import axios from "axios";

// 환경 변수에서 API 기본 URL을 가져옵니다.
const API_BASE_URL = process.env.REACT_APP_API_BASE_URL;

// Axios 인스턴스 생성
const api = axios.create({
  baseURL: API_BASE_URL,
  withCredentials: true
});

export async function loginApi(userName, password) {
  return await api.post('/api/auth/signin', { userName, password });
}

export async function logoutApi(){
  return await api.post('/api/auth/signout',{
    withCredentials: true
  });
}

// export async function validateTokenApi(){
//   return await axios.post('/api/auth/validateToken');
// }

export async function signupApi(userName,password,email,phoneNumber){
  return await api.post('/api/auth/signup',{userName,password,email,phoneNumber})
}

export async function findidAPI(email){
  return await api.post('/api/auth/find_username',{email});
}

export async function findPwAPI(userName,email){
  return await api.post('/api/auth/find_password',{userName,email})
}

export async function changePwAPI(password,newPassword){
  return await api.post('/api/auth/change_password',{password,newPassword}, {
    withCredentials: true
  });
}

export async function deleteUserAPI(email,password){
  return await api.post('/api/auth/delete_user',{email,password}, {
    withCredentials: true
  });
}

export async function sendEmailCodeAPI(email){
  return await api.post('api/auth/send_authenticateCode',{email});
}

export async function validEmailCodeAPI(email,emailCode){
  return await api.post('api/auth/authenticateCode',{email,emailCode});
}