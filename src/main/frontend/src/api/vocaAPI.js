import axios from "axios";

export async function getVocaBooksAPI(){
  const response =  await axios.get('api/vocabook/vocabooklist');
  return response.data;
}

export async function getVocaBookAPI({vocaBookId}){
  const response =  await axios.get(`/api/vocabook/${vocaBookId}`);
  return response.data;
}

export async function getVocaAPI({vocaBookId,category}){
  const response =  await axios.get(`/api/voca/${vocaBookId}/${category}`);
  return response.data;
}