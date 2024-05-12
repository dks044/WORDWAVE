import axios from "axios";

// 환경 변수에서 API 기본 URL을 가져옵니다.
const API_BASE_URL = process.env.REACT_APP_API_BASE_URL;

// Axios 인스턴스 생성
const api = axios.create({
  baseURL: API_BASE_URL,
  withCredentials: true
});

export async function getVocaBooksAPI(){
  const response =  await api.get('api/vocabook/vocabooklist');
  return response.data;
}

export async function getVocaBookAPI({vocaBookId}){
  const response =  await api.get(`/api/vocabook/${vocaBookId}`);
  return response.data;
}

export async function getVocaAPI({vocaBookId,category}){
  const response =  await api.get(`/api/voca/${vocaBookId}/${category}`);
  return response.data;
}