import { combineReducers } from "@reduxjs/toolkit";
import auth from "./auth";
import popup from "./popup";
import vocaBook from "./voca/vocaBook";
import voca from "./voca/voca";
import grammarBook from "./grammar/grammarBook";
import grammar from "./grammar/grammar"
import userLearnPerformance from "./userLearnPerformance/userLearnPerformance";
import myVocaBook from "./myVoca/myVocaBook";
import myVoca from "./myVoca/myVoca";

const rootReducer = combineReducers({
  voca,
  vocaBook,
  myVocaBook,
  myVoca,
  grammarBook,
  grammar,
  auth,
  popup,
  userLearnPerformance
});

export default rootReducer;