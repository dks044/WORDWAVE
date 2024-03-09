import { createSlice } from "@reduxjs/toolkit";
import { reducerUtils } from "../../lib/asyncUtils";

const initialState = {
  vocaBooks : reducerUtils.initial(),
  vocaBook : reducerUtils.initial(),
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
    getVocaBook: (state) => ({
      ...state,
      vocaBook : reducerUtils.loading(),
    }),
    getVocaBookSuccess: (state, action) => ({
      ...state,
      vocaBook : reducerUtils.success(action.payload),
    }),
    getVocaBookError: (state, action) => ({
      ...state,
      vocaBook : reducerUtils.error(action.error),
    }),
  }
})

export const {
  getVocaBooks,
  getVocaBooksSuccess,
  getVocaBooksError,
  getVocaBook,
  getVocaBookSuccess,
  getVocaBookError,
} = vocaBookSlice.actions;
export default vocaBookSlice.reducer;