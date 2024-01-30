import createSagaMiddleware from "redux-saga";
import { all, call } from "redux-saga/effects";
import grammarBooksSaga from "./grammarbooks/grammarBooksSaga";

const sagaMiddleware = createSagaMiddleware();

export function* rootSaga() {
  yield all([call(grammarBooksSaga)]);
}

export default sagaMiddleware;
