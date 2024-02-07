import axios from "axios";

export async function getVocaBooksAPI(){
  const response =  await axios.get('/api/vocabook/vocabooklist');
  return response.data;
}

export async function getVocaBookDetailByIdAPI(vocaBookId){
  const response =  await axios.get(`/api/vocabook/vocabooklist,${vocaBookId}`);
  return response.data;
}
