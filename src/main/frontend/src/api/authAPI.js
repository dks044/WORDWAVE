import axios from "axios";

export function loginApi(userName, password) {
  return axios.post('/api/auth/signin', { userName, password });
}