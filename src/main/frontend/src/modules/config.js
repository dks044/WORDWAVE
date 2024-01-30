import { combineReducers, configureStore } from "@reduxjs/toolkit";
import logger from "redux-logger";
import sagaMiddleware, { rootSaga } from "./rootSaga";
import grammarBooksReducer from "./grammarbooks/grammarBooks";
import grammarQuizReducer from "./quiz/grammarQuiz";

const rootReducer = combineReducers({
  grammarBooks: grammarBooksReducer,
  grammarQuiz: grammarQuizReducer,
});

const store = configureStore({
  reducer: rootReducer,
  devTools: process.env.NODE_ENV !== "production",
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware().concat(sagaMiddleware, logger),
});

sagaMiddleware.run(rootSaga);

export default store;
