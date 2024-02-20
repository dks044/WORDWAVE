import axios from "axios";

export const getGrammarById = async ({ id, isChoice }) => {
  const response = await axios.get("/api/grammar", {
    params: {
      id: id,
      isChoice: isChoice,
    },
  });
  return response.data;
};

export const getGrammarNumOfAllGrammarBooks = async () => {
  const response = await axios.get("/api/grammar/num-each-grammarbook");
  return response.data;
};
