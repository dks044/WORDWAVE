import axios from "axios";

export const getGrammarBooks = async () => {
  const response = await axios.get("/api/grammarbook/all");
  return response.data;
};

export const getGrammarBookById = async (grammarBookName) => {
  const response = await axios.get(`/api/grammarbook/${grammarBookName}`);
  return response.data;
};

export const getGrammarNumOfAllGrammarBooks = async () => {
  const response = await axios.get("/api/grammarbook/all-grammar-num");
  return response.data;
};
