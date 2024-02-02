import axios from "axios";

export const getGrammarBooks = async () => {
  const response = await axios.get("/api/grammarbook/all");
  return response.data;
};

export const getGrammarBookById = async (id) => {
  const response = await axios.get(`/api/grammarbook/${id}`);
  return response.data;
};
