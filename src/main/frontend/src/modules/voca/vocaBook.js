import { createSlice } from "@reduxjs/toolkit";
import { reducerUtils } from "../../lib/asyncUtils";

const initialState = {
  vocaBooks : reducerUtils.initial()
}

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
    })
  }
})

export const {
  getVocaBooks,
  getVocaBooksSuccess,
  getVocaBooksError
} = vocaBookSlice.actions;
export default vocaBookSlice.reducer;