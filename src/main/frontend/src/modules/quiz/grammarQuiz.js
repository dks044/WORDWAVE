import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  grammarIndex: 0,
  isExampleClicked: false,
  isSubmit: false,
  isAnswer: false,
  incorrectGrammarIds: [],
  writeAnswer: [],
  writeAnswerIsClick: {},
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
      state.writeAnswerIsClick[action.payload] = true;
    },
    popWriteAnswer: (state, action) => {
      const current = state.writeAnswer.splice(action.payload, 1);
      state.writeAnswerIsClick[current] = false;
      state.isExampleClicked = false;
    },
    clearWriteAnswer: (state) => {
      state.writeAnswer = [];
      state.writeAnswerIsClick = {};
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
  addWriteAnswer,
  popWriteAnswer,
  clearWriteAnswer,
} = grammarQuizSlice.actions;
export default grammarQuizSlice.reducer;
