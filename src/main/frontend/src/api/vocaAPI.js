import axios from "axios";

export async function getVocaBooksAPI(){
  const response =  await axios.get('api/vocabook/vocabooklist');
  return response.data;
}

export async function getVocaBookDetailByIdAPI(vocaBookId){
  const response =  await axios.get(`/api/vocabook/${vocaBookId}`);
  return response.data;
}

export async function getVocaBookNameByIdAPI(vocaBookId){
  const response =  await axios.get(`/api/vocabook/name/${vocaBookId}`);
  return response.data;
}