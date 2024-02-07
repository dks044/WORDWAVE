import * as grammarBooksAPI from "../../api/grammarBooksAPI";
import { call, put, takeEvery } from "redux-saga/effects";

function* fetchGrammarBooksSaga() {
  try {
    const grammarBooks = yield call(grammarBooksAPI.getGrammarBooks);
    yield put({
      type: "grammarBooks/getGrammarBooksSuccess",
      payload: grammarBooks,
    });
  } catch (error) {
    yield put({
      type: "grammarBooks/getGrammarBooksError",
      error: true,
      payload: error,
    });
  }
}

function* fetchGrammarBookSaga(action) {
  try {
    const grammarBook = yield call(
      grammarBooksAPI.getGrammarBookById,
      action.payload
    );
    yield put({
      type: "grammarBooks/getGrammarBookSuccess",
      payload: grammarBook,
    });
  } catch (error) {
    yield put({
      type: "grammarBooks/getGrammarBookError",
      error: true,
      payload: error,
    });
  }
}

function* fetchGrammarNumOfAllGrammarBooksSaga() {
  try {
    const num = yield call(grammarBooksAPI.getGrammarNumOfAllGrammarBooks);
    yield put({
      type: "grammarBooks/getGrammarNumOfAllGrammarBooksSuccess",
      payload: num,
    });
  } catch (error) {
    yield put({
      type: "grammarBooks/getGrammarNumOfAllGrammarBooksError",
      error: true,
      payload: error,
    });
  }
}

function* grammarBooksSaga() {
  yield takeEvery("grammarBooks/getGrammarBooks", fetchGrammarBooksSaga);
  yield takeEvery("grammarBooks/getGrammarBook", fetchGrammarBookSaga);
  yield takeEvery(
    "grammarBooks/getGrammarNumOfAllGrammarBooks",
    fetchGrammarNumOfAllGrammarBooksSaga
  );
}

export default grammarBooksSaga;
