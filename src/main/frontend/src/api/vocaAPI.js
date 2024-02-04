import axios from "axios";

export async function getVocaBookAPI(){
  return await axios.get('/api/voca/vocabooklist');
}