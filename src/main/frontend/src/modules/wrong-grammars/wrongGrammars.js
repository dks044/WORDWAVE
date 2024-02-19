import { createSlice } from "@reduxjs/toolkit";
import { reducerUtils } from "../../lib/asyncUtils";

const initialState = {
  userWrongGrammars: reducerUtils.initial(),
  saveWrongGrammars: reducerUtils.initial(),
  userWrongGrammarBook: reducerUtils.initial(),
  isClickWrongGrammarSwitch: false,
};

const wrongGrammarsSlice = createSlice({
  name: "wrongGrammars",
  initialState,
  reducers: {
    getUserWrongGrammars: (state) => ({
      ...state,
      userWrongGrammars: reducerUtils.loading(),
    }),
    getUserWrongGrammarsSuccess: (state, action) => ({
      ...state,
      userWrongGrammars: reducerUtils.success(action.payload),
    }),
    getUserWrongGrammarsError: (state, action) => ({
      ...state,
      userWrongGrammars: reducerUtils.error(action.error),
    }),
    saveUserWrongGrammars: (state) => ({
      ...state,
      saveWrongGrammars: reducerUtils.loading(),
    }),
    saveUserWrongGrammarsSuccess: (state, action) => ({
      ...state,
      saveWrongGrammars: reducerUtils.success(action.payload),
    }),
    saveUserWrongGrammarsError: (state, action) => ({
      ...state,
      saveWrongGrammars: reducerUtils.error(action.error),
    }),
    getUserWrongGrammarBook: (state) => ({
      ...state,
      userWrongGrammarBook: reducerUtils.loading(),
    }),
    getUserWrongGrammarBookSuccess: (state, action) => ({
      ...state,
      userWrongGrammarBook: reducerUtils.success(action.payload),
    }),
    getUserWrongGrammarBookError: (state, action) => ({
      ...state,
      userWrongGrammarBook: reducerUtils.error(action.error),
    }),
    clickWrongGrammarSwitch: (state) => {
      state.isClickWrongGrammarSwitch = state.isClickWrongGrammarSwitch
        ? false
        : true;
    },
    initializeWrongGrammarSwitch: (state) => {
      state.isClickWrongGrammarSwitch = false;
    },
  },
});

export const {
  getUserWrongGrammars,
  getUserWrongGrammarsSuccess,
  getUserWrongGrammarsError,
  saveUserWrongGrammars,
  saveUserWrongGrammarsSuccess,
  saveUserWrongGrammarsError,
  getUserWrongGrammarBook,
  getUserWrongGrammarBookSuccess,
  getUserWrongGrammarBookError,
  clickWrongGrammarSwitch,
  initializeWrongGrammarSwitch,
} = wrongGrammarsSlice.actions;
export default wrongGrammarsSlice.reducer;
