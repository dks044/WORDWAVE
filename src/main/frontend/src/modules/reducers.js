import { combineReducers } from "@reduxjs/toolkit";
import auth from "./auth";
import popup from "./popup";
import vocaBook from "./voca/vocaBook";
import voca from "./voca/voca";

const rootReducer = combineReducers({
  voca,
  vocaBook,
  auth,
  popup,
});

export default rootReducer;