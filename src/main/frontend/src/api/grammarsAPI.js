import axios from "axios";

export const getGrammarById = async (grammarId) => {
  const response = await axios.get(`/api/grammar/${grammarId}`);
  return response.data;
};

export const getGrammarNumOfAllGrammarBooks = async () => {
  const response = await axios.get("/api/grammar/num-each-grammarbook");
  return response.data;
};
