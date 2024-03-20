import { call, put, takeEvery, takeLatest } from "redux-saga/effects";
import * as grammarAPI from "../../api/grammarAPI"


function* fetchGrammarBooksSaga(){
  try {
    const grammarBooks = yield call(grammarAPI.getGrammarBooksAPI);
    yield put ({
      type: "grammarBook/getGrammarBooksSuccess",
      payload : grammarBooks
    });
    //console.log(GrammarBooks);
  } catch (e) {
    yield put({
      type: "grammarBook/getGrammarBooksError",
      error: true,
      payload: e.message,
    });
  }
}

function* grammarBookSaga() {
  yield takeEvery("grammarBook/getGrammarBooks", fetchGrammarBooksSaga);
}

export default grammarBookSaga;