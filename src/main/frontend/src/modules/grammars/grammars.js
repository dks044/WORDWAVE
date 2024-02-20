import { createSlice } from "@reduxjs/toolkit";
import { reducerUtils } from "../../lib/asyncUtils";

const initialState = {
  grammar: reducerUtils.initial(),
  grammarNumOfAllGrammarBooks: reducerUtils.initial(),
  isChoice: true,
};

const grammarsSlice = createSlice({
  name: "grammars",
  initialState,
  reducers: {
    getGrammarById: (state) => ({
      ...state,
      grammar: reducerUtils.loading(),
    }),
    getGrammarByIdSuccess: (state, action) => ({
      ...state,
      grammar: reducerUtils.success(action.payload),
    }),
    getGrammarByIdError: (state, action) => ({
      ...state,
      grammar: reducerUtils.error(action.error),
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
    clickWriteSwitch: (state) => {
      state.isChoice = state.isChoice ? false : true;
    },
    initializeWriteSwitch: (state) => {
      state.isChoice = true;
    },
    initializeGrammar: (state) => {
      state.grammar = reducerUtils.initial();
    },
  },
});

export const {
  getGrammarById,
  getGrammarByIdSuccess,
  getGrammarByIdError,
  getGrammarNumOfAllGrammarBooks,
  getGrammarNumOfAllGrammarBooksSuccess,
  getGrammarNumOfAllGrammarBooksError,
  clickWriteSwitch,
  initializeWriteSwitch,
  initializeGrammar,
} = grammarsSlice.actions;
export default grammarsSlice.reducer;
