import * as grammarsAPI from "../../api/grammarsAPI";
import { call, put, takeEvery, takeLatest } from "redux-saga/effects";

function* fetchGrammarById(action) {
  try {
    const grammar = yield call(grammarsAPI.getGrammarById, action.payload);
    yield put({
      type: "grammars/getGrammarByIdSuccess",
      payload: grammar,
    });
  } catch (error) {
    yield put({
      type: "grammars/getGrammarByIdError",
      error: true,
      payload: error,
    });
  }
}

function* fetchGrammarNumOfAllGrammarBooksSaga() {
  try {
    const num = yield call(grammarsAPI.getGrammarNumOfAllGrammarBooks);
    yield put({
      type: "grammars/getGrammarNumOfAllGrammarBooksSuccess",
      payload: num,
    });
  } catch (error) {
    yield put({
      type: "grammars/getGrammarNumOfAllGrammarBooksError",
      error: true,
      payload: error,
    });
  }
}

function* grammarsSaga() {
  yield takeLatest("grammars/getGrammarById", fetchGrammarById);
  yield takeEvery(
    "grammars/getGrammarNumOfAllGrammarBooks",
    fetchGrammarNumOfAllGrammarBooksSaga
  );
}

export default grammarsSaga;
