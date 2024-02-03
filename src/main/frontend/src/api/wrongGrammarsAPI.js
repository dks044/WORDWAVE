import axios from "axios";

export const getUserWrongGrammars = async () => {
  const response = await axios.get("/api/user-wrong-grammar", {
    headers: {
      Authorization: `Bearer ${localStorage.getItem("token")}`,
    },
  });
  return response.data;
};

export const postUserWrongGrammarIds = async (
  userName,
  wrongGrammarIds,
  lastTryTime
) => {
  return await axios.post("/api/user", {
    userName,
    wrongGrammarIds,
    lastTryTime,
  });
};
