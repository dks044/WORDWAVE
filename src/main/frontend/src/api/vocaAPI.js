import axios from "axios";

export async function getVocaBookAPI(){
  return await axios.get('/api/vocabook/vocabooklist');
}

export async function getVocaBookDetailByIdAPI(vocaBookId){
  return await axios.get('/api/vocabook/vocabooklist',{vocaBookId});
}
