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
      VocaBooks: reducerUtils.loading(),
    }),
    getVocaBooksSuccess: (state, action) => ({
      ...state,
      VocaBooks: reducerUtils.success(action.payload),
    }),
    getVocaBooksError: (state, action) => ({
      ...state,
      VocaBooks: reducerUtils.error(action.error),
    })
  }
})

export const {
  getVocaBooks,
  getVocaBooksSuccess,
  getVocaBooksError
} = vocaBookSlice.actions;
export default vocaBookSlice.reducer;