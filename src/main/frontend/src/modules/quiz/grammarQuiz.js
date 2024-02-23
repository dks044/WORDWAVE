import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  grammarIndex: 0,
  isExampleClicked: false,
  isSubmit: false,
  isAnswer: false,
  incorrectGrammarIds: [],
  writeAnswer: [],
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
    initializeClickExampleAndSubmitAndAnswer: (state) => {
      state.isExampleClicked = false;
      state.isSubmit = false;
      state.isAnswer = false;
    },
    clickSubmitButton: (state) => {
      state.isSubmit = true;
    },
    addIncorrectGrammarId: (state, action) => {
      state.incorrectGrammarIds.push(action.payload);
    },
    clearIncorrectGrammarIds: (state) => {
      state.incorrectGrammarIds.length = 0;
    },
    addWriteAnswer: (state, action) => {
      state.writeAnswer.push(action.payload);
    },
    popWriteAnswer: (state) => {
      state.writeAnswer.pop();
    },
    clearWriteAnswer: (state) => {
      state.writeAnswer = [];
    },
  },
});

export const {
  initializeIndex,
  increaseIndex,
  clickExample,
  initializeClickExampleAndSubmitAndAnswer,
  clickSubmitButton,
  addIncorrectGrammarId,
  clearIncorrectGrammarIds,
  clearWriteAnswer,
} = grammarQuizSlice.actions;
export default grammarQuizSlice.reducer;
