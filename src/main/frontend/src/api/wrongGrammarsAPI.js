import axios from "axios";

export const getUserWrongGrammars = async (userName) => {
  try {
    const response = await axios.get("/api/user-wrong-grammar/grammars", {
      params: {
        userName: userName,
      },
    });
    return response.data;
  } catch (error) {
    console.log(error);
  }
};

export const getUserWrongGrammarBook = async ({
  userName,
  grammarBookName,
}) => {
  try {
    const response = await axios.get("/api/user-wrong-grammar/grammarbook", {
      params: {
        userName: userName,
        grammarBookName: grammarBookName,
      },
    });
    return response.data;
  } catch (error) {
    console.log(error);
  }
};

export const postUserWrongGrammarIds = async (wrongGrammarsDto) => {
  return await axios.post("/api/user-wrong-grammar", wrongGrammarsDto);
};
