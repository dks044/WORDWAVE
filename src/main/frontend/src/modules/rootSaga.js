import createSagaMiddleware from "redux-saga";
import { all, call } from "redux-saga/effects";
import vocaBookSaga from "./voca/vocaBookSaga";


const sagaMiddleware = createSagaMiddleware();

export function* rootSaga() {
  yield all([call(vocaBookSaga)]);
}

export default sagaMiddleware;