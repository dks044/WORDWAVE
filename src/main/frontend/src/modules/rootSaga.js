import createSagaMiddleware from "redux-saga";
import { all, call } from "redux-saga/effects";
import grammarBooksSaga from "./grammarbooks/grammarBooksSaga";
import wrongGrammarsSaga from "./wrong-grammars/wrongGrammarsSaga";
import grammarsSaga from "./grammars/grammarsSaga";

const sagaMiddleware = createSagaMiddleware();

export function* rootSaga() {
  yield all([
    call(grammarBooksSaga),
    call(wrongGrammarsSaga),
    call(grammarsSaga),
  ]);
}

export default sagaMiddleware;
