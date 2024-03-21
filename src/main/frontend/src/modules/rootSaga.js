import createSagaMiddleware from "redux-saga";
import { all, call } from "redux-saga/effects";
import vocaBookSaga from "./voca/vocaBookSaga";
import vocaSaga from "./voca/vocaSaga";
import grammarBookSaga from "./grammar/grammarBookSaga";
import grammarSaga from "./grammar/grammarSaga";
import userLearnPerformanceSaga from "./userLearnPerformance/userLearnPerformanceSaga";

const sagaMiddleware = createSagaMiddleware();

export function* rootSaga() {
  yield all([call(vocaSaga), call(vocaBookSaga),call(userLearnPerformanceSaga),
            call(grammarBookSaga),call(grammarSaga)]);
}

export default sagaMiddleware;