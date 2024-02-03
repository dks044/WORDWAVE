import { createSlice } from "@reduxjs/toolkit";
import { reducerUtils } from "../../lib/asyncUtils";

const initialState = {
  userWrongGrammars: reducerUtils.initial(),
};

const wrongGrammarsSlice = createSlice({
  name: "wrongGrammars",
  initialState,
  reducers: {
    getUserWrongGrammars: (state, action) => ({
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
  },
});

export const {
  getUserWrongGrammars,
  getUserWrongGrammarsSuccess,
  getUserWrongGrammarsError,
} = wrongGrammarsSlice.actions;
export default wrongGrammarsSlice.reducer;
