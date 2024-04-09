import { createSlice } from "@reduxjs/toolkit";
import { reducerUtils } from "../../lib/asyncUtils";

const initialState = {
  myVocaBooks : reducerUtils.initial(),
  myVocaBook : reducerUtils.initial(),
  myVocaBookOne : reducerUtils.initial(),
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
    getMyVocaBook: (state) => ({
      ...state,
      myVocaBook: reducerUtils.loading(),
    }),
    getMyVocaBookSuccess: (state, action) => ({
      ...state,
      myVocaBook: reducerUtils.success(action.payload),
    }),
    getMyVocaBookError: (state, action) => ({
      ...state,
      myVocaBook: reducerUtils.error(action.error),
    }),
    getMyVocaBookOne: (state) => ({
      ...state,
      myVocaBookOne: reducerUtils.loading(),
    }),
    getMyVocaBookOneSuccess: (state, action) => ({
      ...state,
      myVocaBookOne: reducerUtils.success(action.payload),
    }),
    getMyVocaBookOneError: (state, action) => ({
      ...state,
      myVocaBookOne: reducerUtils.error(action.error),
    }),

}})

export const {
  getMyVocaBooks,
  getMyVocaBooksSuccess,
  getMyVocaBooksError,
  getMyVocaBook,
  getMyVocaBookSuccess,
  getMyVocaBookError,
  getMyVocaBookOne,
  getMyVocaBookOneSuccess,
  getMyVocaBookOneError
} = myVocaBookSlice.actions;

export default myVocaBookSlice.reducer;