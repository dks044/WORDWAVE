import { combineReducers } from "@reduxjs/toolkit";
import auth from "./auth";
import popup from "./popup";
import vocaBook from "./voca/vocaBook";

const rootReducer = combineReducers({
  vocaBook : vocaBook,
  auth,
  popup,
});

export default rootReducer;