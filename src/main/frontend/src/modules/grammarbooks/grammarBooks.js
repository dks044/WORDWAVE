import { createSlice } from "@reduxjs/toolkit";
import { reducerUtils } from "../../lib/asyncUtils";

const initialState = {
  grammarBooks: reducerUtils.initial(),
  grammarBook: reducerUtils.initial(),
  grammarNumOfAllGrammarBooks: reducerUtils.initial(),
};

const grammarBooksSlice = createSlice({
  name: "grammarBooks",
  initialState,
  reducers: {
    getGrammarBooks: (state) => ({
      ...state,
      grammarBooks: reducerUtils.loading(),
    }),
    getGrammarBooksSuccess: (state, action) => ({
      ...state,
      grammarBooks: reducerUtils.success(action.payload),
    }),
    getGrammarBooksError: (state, action) => ({
      ...state,
      grammarBooks: reducerUtils.error(action.error),
    }),
    getGrammarBook: (state) => ({
      ...state,
      grammarBook: reducerUtils.loading(),
    }),
    getGrammarBookSuccess: (state, action) => ({
      ...state,
      grammarBook: reducerUtils.success(action.payload),
    }),
    getGrammarBookError: (state, action) => ({
      ...state,
      grammarBook: reducerUtils.error(action.error),
    }),
    getGrammarNumOfAllGrammarBooks: (state) => ({
      ...state,
      grammarNumOfAllGrammarBooks: reducerUtils.loading(),
    }),
    getGrammarNumOfAllGrammarBooksSuccess: (state, action) => ({
      ...state,
      grammarNumOfAllGrammarBooks: reducerUtils.success(action.payload),
    }),
    getGrammarNumOfAllGrammarBooksError: (state, action) => ({
      ...state,
      grammarNumOfAllGrammarBooks: reducerUtils.error(action.error),
    }),
  },
});

export const {
  getGrammarBooks,
  getGrammarBooksSuccess,
  getGrammarBooksError,
  getGrammarBook,
  getGrammarBookSuccess,
  getGrammarBookError,
  getGrammarNumOfAllGrammarBooks,
  getGrammarNumOfAllGrammarBooksSuccess,
  getGrammarNumOfAllGrammarBooksError,
} = grammarBooksSlice.actions;
export default grammarBooksSlice.reducer;
