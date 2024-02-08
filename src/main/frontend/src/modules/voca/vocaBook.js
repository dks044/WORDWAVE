import { createSlice } from "@reduxjs/toolkit";
import { reducerUtils } from "../../lib/asyncUtils";

const initialState = {
  vocaBooks : reducerUtils.initial(),
  categoriesOfVocaBook : reducerUtils.initial(),
  vocaBookName : reducerUtils.initial()
};

const vocaBookSlice = createSlice({
  name : "vocaBook",
  initialState,
  reducers: {
    getVocaBooks: (state) => ({
      ...state,
      vocaBooks: reducerUtils.loading(),
    }),
    getVocaBooksSuccess: (state, action) => ({
      ...state,
      vocaBooks: reducerUtils.success(action.payload),
    }),
    getVocaBooksError: (state, action) => ({
      ...state,
      vocaBooks: reducerUtils.error(action.error),
    }),
    getCategoriesOfVocaBook: (state) => ({
      ...state,
      categoriesOfVocaBook: reducerUtils.loading(),
    }),
    getCategoriesOfVocaBookSuccess: (state, action) => ({
      ...state,
      categoriesOfVocaBook: reducerUtils.success(action.payload),
    }),
    getCategoriesOfVocaBookError: (state, action) => ({
      ...state,
      categoriesOfVocaBook: reducerUtils.error(action.error),
    }),
    getVocaBookName: (state) => ({
      ...state,
      vocaBookName: reducerUtils.loading(),
    }),
    getVocaBookNameSuccess: (state, action) => ({
      ...state,
      vocaBookName: reducerUtils.success(action.payload),
    }),
    getVocaBookNameError: (state, action) => ({
      ...state,
      vocaBookName: reducerUtils.error(action.error),
    }),
  }
})

export const {
  getVocaBooks,
  getVocaBooksSuccess,
  getVocaBooksError,
  getCategoriesOfVocaBook,
  getCategoriesOfVocaBookSuccess,
  getCategoriesOfVocaBookError,
  getVocaBookName,
  getVocaBookNameSuccess,
  getVocaBookNameError
} = vocaBookSlice.actions;
export default vocaBookSlice.reducer;