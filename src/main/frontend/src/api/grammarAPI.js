import axios from "axios";

export async function getGrammarBooksAPI(){
  const response = await axios.get('/api/grammarbook/grammarbook_List');
  return response.data;
}

export async function getGrammarBookAPI({grammarBookId}){
  const response =  await axios.get(`/api/grammarbook/${grammarBookId}`);
  return response.data;
}

export async function getGrammarAPI({grammarBookId,category}){
  const response = await axios.get(`/api/grammar/${grammarBookId}/${category}`);
  return response.data;
}