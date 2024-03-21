import { call, put, takeEvery } from "redux-saga/effects";
import * as grammarAPI from "../../api/grammarAPI"

function* fetchGrammarSaga(action){
  try {
    const grammar = yield call(grammarAPI.getGrammarAPI, action.payload);
    yield put ({
      type : "grammar/getGrammarSuccess",
      payload : grammar
    });
  } catch (e) {
    console.log(e);
    yield put({
      type: "grammar/getGrammarError",
      error: true,
      payload: e.message,
    });
  }
}

function* grammarSaga() {
  yield takeEvery("grammar/getGrammar", fetchGrammarSaga);
}

export default grammarSaga;