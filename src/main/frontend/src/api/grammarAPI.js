import axios from "axios";

// 환경 변수에서 API 기본 URL을 가져옵니다.
const API_BASE_URL = process.env.REACT_APP_API_BASE_URL;

// Axios 인스턴스 생성
const api = axios.create({
  baseURL: API_BASE_URL,
});

export async function getGrammarBooksAPI(){
  const response = await api.get('/api/grammarbook/grammarbook_List');
  return response.data;
}

export async function getGrammarBookAPI({grammarBookId}){
  const response =  await api.get(`/api/grammarbook/${grammarBookId}`);
  return response.data;
}

export async function getGrammarAPI({grammarBookId,category}){
  const response = await api.get(`/api/grammar/${grammarBookId}/${category}`);
  return response.data;
}