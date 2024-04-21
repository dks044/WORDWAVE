import { createSlice } from "@reduxjs/toolkit";
import { reducerUtils } from "../../lib/asyncUtils";

const initialState = {
  updateFormMyVoca : reducerUtils.initial(),
  myVoca : reducerUtils.initial(),
}

const myVocaSlice = createSlice({
  name : "myVoca",
  initialState,
  reducers: {
    getUpdateFormMyVoca: (state) => ({
      ...state,
      updateFormMyVoca: reducerUtils.loading(),
    }),
    getUpdateFormMyVocaSuccess: (state, action) => ({
      ...state,
      updateFormMyVoca: reducerUtils.success(action.payload),
    }),
    getUpdateFormMyVocaError: (state, action) => ({
      ...state,
      updateFormMyVoca: reducerUtils.error(action.error),
    }),
    getMyVoca: (state) => ({
      ...state,
      myVoca: reducerUtils.loading(),
    }),
    getMyVocaSuccess: (state, action) => ({
      ...state,
      myVoca: reducerUtils.success(action.payload),
    }),
    getMyVocaError: (state, action) => ({
      ...state,
      myVoca: reducerUtils.error(action.error),
    }),
  }

})

export const {
  getUpdateFormMyVoca,
  getUpdateFormMyVocaSuccess,
  getUpdateFormMyVocaError,
  getMyVoca,
  getMyVocaSuccess,
  getMyVocaError
} = myVocaSlice.actions;

export default myVocaSlice.reducer;