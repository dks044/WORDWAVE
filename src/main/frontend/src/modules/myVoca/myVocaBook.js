import { createSlice } from "@reduxjs/toolkit";
import { reducerUtils } from "../../lib/asyncUtils";

const initialState = {
  myVocaBooks : reducerUtils.initial(),

}

const myVocaBookSlice = createSlice({
  name : "myVocaBook",
  initialState,
  reducers: {
    getMyVocaBooks: (state) => ({
      ...state,
      myVocaBooks: reducerUtils.loading(),
    }),
    getMyVocaBooksSuccess: (state, action) => ({
      ...state,
      myVocaBooks: reducerUtils.success(action.payload),
    }),
    getMyVocaBooksError: (state, action) => ({
      ...state,
      myVocaBooks: reducerUtils.error(action.error),
    }),


}})

export const {
  getMyVocaBooks,
  getMyVocaBooksSuccess,
  getMyVocaBooksError
} = myVocaBookSlice.actions;

export default myVocaBookSlice.reducer;