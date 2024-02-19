import { createSlice } from "@reduxjs/toolkit";
import { reducerUtils } from "../../lib/asyncUtils";

const initialState = {
  voca : reducerUtils.initial()
};

const vocaSlice = createSlice({
  name : "voca",
  initialState,
  reducers: {
    getVoca: (state) => ({
      ...state,
      voca: reducerUtils.loading(),
    }),
    getVocaSuccess: (state, action) => ({
      ...state,
      voca: reducerUtils.success(action.payload),
    }),
    getVocaError: (state, action) => ({
      ...state,
      voca: reducerUtils.error(action.error),
    })
  }
})

export const {
  getVoca,
  getVocaSuccess,
  getVocaError,
} = vocaSlice.actions;
export default vocaSlice.reducer;