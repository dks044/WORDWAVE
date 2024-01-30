import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  grammarIndex: 0,
};

const grammarQuizSlice = createSlice({
  name: "grammarQuiz",
  initialState,
  reducers: {
    initializeIndex: (state) => {
      state.grammarIndex = 0;
    },
    increaseIndex: (state) => {
      state.grammarIndex += 1;
    },
  },
});

export const { initializeIndex, increaseIndex } = grammarQuizSlice.actions;
export default grammarQuizSlice.reducer;
