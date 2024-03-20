import { createSlice } from "@reduxjs/toolkit";
import { reducerUtils } from "../../lib/asyncUtils";

const initialState = {
  grammarBooks : reducerUtils.initial(),
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
      grammarBooks: reducerUtils.error(action.error),
    }),
  }
})


export const {
  getGrammarBooks,
  getGrammarBooksSuccess,
  getGrammarBooksError
} = grammarBookSlice.actions;

export default grammarBookSlice.reducer;