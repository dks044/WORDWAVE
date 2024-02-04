import axios from "axios";

export const getUserWrongGrammars = async (userName) => {
  console.log(userName);
  try {
    const response = await axios.get("/api/user-wrong-grammar", {
      params: {
        userName: userName,
      },
      // withCredentials: true,
    });
    return response.data;
  } catch (error) {
    console.log(error);
  }
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
