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
틀린 grammar의 id를 배열에 모아서 오답 페이지에서 보여주기
오답 페이지에 GrammarBooksPage로 돌아가는 버튼있어야함

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
} = grammarQuizSlice.actions;
export default grammarQuizSlice.reducer;
