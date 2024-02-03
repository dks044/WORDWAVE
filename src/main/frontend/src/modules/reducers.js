import { combineReducers } from "@reduxjs/toolkit";
import grammarBooksReducer from "./grammarbooks/grammarBooks";
import grammarQuizReducer from "./quiz/grammarQuiz";
import wrongGrammars from "./wrong-grammars/wrongGrammars";
import auth from "./auth";
import popup from "./popup";

const rootReducer = combineReducers({
  grammarBooks: grammarBooksReducer,
  grammarQuiz: grammarQuizReducer,
  wrongGrammars: wrongGrammars,
  auth,
  popup,
});

export default rootReducer;
