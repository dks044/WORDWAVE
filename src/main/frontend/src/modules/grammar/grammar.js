import { createSlice } from "@reduxjs/toolkit";
import { reducerUtils } from "../../lib/asyncUtils";

const initialState = {
  grammar : reducerUtils.initial()
};

const grammarSlice = createSlice({
  name : "grammar",
  initialState,
  reducers: {
    getGrammar: (state) => ({
      ...state,
      grammar: reducerUtils.loading(),
    }),
    getGrammarSuccess: (state, action) => ({
      ...state,
      grammar: reducerUtils.success(action.payload),
    }),
    getGrammarError: (state, action) => ({
      ...state,
      grammar: reducerUtils.error(action.error),
    })
  }
})

export const {
  getGrammar,
  getGrammarSuccess,
  getGrammarError
} = grammarSlice.actions;
export default grammarSlice.reducer;