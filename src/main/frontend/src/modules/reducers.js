import { combineReducers } from "@reduxjs/toolkit";
import auth from "./auth";
import popup from "./popup";
import vocaBook from "./voca/vocaBook";
import voca from "./voca/voca";
import grammarBook from "./grammar/grammarBook";
import grammar from "./grammar/grammar"
import userLearnPerformance from "./userLearnPerformance/userLearnPerformance";

const rootReducer = combineReducers({
  voca,
  vocaBook,
  grammarBook,
  grammar,
  auth,
  popup,
  userLearnPerformance
});

export default rootReducer;