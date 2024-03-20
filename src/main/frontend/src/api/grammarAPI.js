import axios from "axios";

export async function getGrammarBooksAPI(){
  const response = await axios.get('/api/grammarbook/grammarbook_List');
  return response.data;
}