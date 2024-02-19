import createSagaMiddleware from "redux-saga";
import { all, call } from "redux-saga/effects";
import vocaBookSaga from "./voca/vocaBookSaga";
import vocaSaga from "./voca/vocaSaga";

const sagaMiddleware = createSagaMiddleware();

export function* rootSaga() {
  yield all([call(vocaBookSaga)]);
  yield all([call(vocaSaga)]);
}

export default sagaMiddleware;