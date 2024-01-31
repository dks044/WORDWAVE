import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  grammarIndex: 0,
  isExampleClicked: false,
  isSubmit: false,
  isAnswer: false,
  answer: "",
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
    clickExample: (state, action) => {
      state.isExampleClicked = true;
      state.isAnswer = action.payload;
    },
    initializeClickExampleAndSubmit: (state) => {
      state.isExampleClicked = false;
      state.isSubmit = false;
    },
    clickSubmitButton: (state) => {
      state.isSubmit = true;
    },
    setAnswer: (state, action) => {
      state.answer = action.payload;
    },
  },
});

export const {
  initializeIndex,
  increaseIndex,
  clickExample,
  initializeClickExampleAndSubmit,
  clickSubmitButton,
  setAnswer,
} = grammarQuizSlice.actions;
export default grammarQuizSlice.reducer;
