import { createSlice } from "@reduxjs/toolkit";
import { reducerUtils } from "../../lib/asyncUtils";

const initialState = {
  updateFormMyVoca : reducerUtils.initial(),
}

const MyVocaSlice = createSlice({
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
  }

})

export const {
  getUpdateFormMyVoca,
  getUpdateFormMyVocaSuccess,
  getUpdateFormMyVocaError
} = MyVocaSlice.actions;

export default MyVocaSlice.reducer;