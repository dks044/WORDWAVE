import axios from "axios";

export async function getVocaBookAPI(){
  return await axios.get('/api/vocabook/vocabooklist');
}

export async function getVocaBookDetail(vocaBookId){
  return await axios.get('/api/vocabook/detail',vocaBookId);
}