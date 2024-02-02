import { combineReducers } from "@reduxjs/toolkit";
import grammarBooksReducer from "./grammarbooks/grammarBooks";
import grammarQuizReducer from "./quiz/grammarQuiz";
import auth from "./auth";
import popup from "./popup";

const rootReducer = combineReducers({
  grammarBooks: grammarBooksReducer,
  grammarQuiz: grammarQuizReducer,
  auth,
  popup,
});

export default rootReducer;
