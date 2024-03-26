import { createSlice } from "@reduxjs/toolkit";
import { reducerUtils } from "../../lib/asyncUtils";

const initialState = {
  grammarBooks : reducerUtils.initial(),
  grammarBook : reducerUtils.initial(),
};

const grammarBookSlice = createSlice({
  name : "grammarBook",
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
      grammarBooks: reducerUtils.error(action.payload),
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
      grammarBook: reducerUtils.error(action.payload),
    }),
  }
})


export const {
  getGrammarBooks,
  getGrammarBooksSuccess,
  getGrammarBooksError,
  getGrammarBook,
  getGrammarBookSuccess,
  getGrammarBookError
} = grammarBookSlice.actions;

export default grammarBookSlice.reducer;