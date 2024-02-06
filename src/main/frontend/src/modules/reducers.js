import { combineReducers } from "@reduxjs/toolkit";
import auth from "./auth";
import popup from "./popup";

const rootReducer = combineReducers({
  auth,
  popup,
});

export default rootReducer;