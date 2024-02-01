import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  grammarIndex: 0,
  isExampleClicked: false,
  isSubmit: false,
  isAnswer: false,
  answer: "",
  incorrectGrammarIds: [],
};

/*
나중에 로그인된 유저만 퀴즈 페이지 접근 가능하고,
유저 식별해서 백엔드에 오답 grammar들 post 요청 보내기
*/

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
    addIncorrectGrammarId: (state, action) => {
      state.incorrectGrammarIds.push(action.payload);
    },
    clearIncorrectGrammarIds: (state) => {
      state.incorrectGrammarIds.length = 0;
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
  addIncorrectGrammarId,
  clearIncorrectGrammarIds,
} = grammarQuizSlice.actions;
export default grammarQuizSlice.reducer;
