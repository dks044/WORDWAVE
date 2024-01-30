import axios from "axios";

const instance = axios.create({
  baseURL: "http://localhost:8080/",
});

export const getGrammarBooks = async () => {
  const response = await instance.get("api/grammarbook/all");
  return response.data;
};

export const getGrammarBookById = async (id) => {
  const response = await instance.get(`api/grammarbook/${id}`);
  return response.data;
};
