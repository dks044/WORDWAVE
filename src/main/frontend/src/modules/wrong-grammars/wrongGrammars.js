import { createSlice } from "@reduxjs/toolkit";
import { reducerUtils } from "../../lib/asyncUtils";

const initialState = {
  userWrongGrammars: reducerUtils.initial(),
  saveWrongGrammars: reducerUtils.initial(),
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
  },
});

export const {
  getUserWrongGrammars,
  getUserWrongGrammarsSuccess,
  getUserWrongGrammarsError,
  saveUserWrongGrammars,
  saveUserWrongGrammarsSuccess,
  saveUserWrongGrammarsError,
} = wrongGrammarsSlice.actions;
export default wrongGrammarsSlice.reducer;
