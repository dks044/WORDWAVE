import * as wrongGrammarsAPI from "../../api/wrongGrammarsAPI";
import { call, put, takeEvery, takeLatest } from "redux-saga/effects";

function* fetchUserWrongGrammarsSaga(action) {
  try {
    const userWrongGrammars = yield call(
      wrongGrammarsAPI.getUserWrongGrammars,
      action.payload
    );
    yield put({
      type: "wrongGrammars/getUserWrongGrammarsSuccess",
      payload: userWrongGrammars,
    });
  } catch (error) {
    yield put({
      type: "wrongGrammars/getUserWrongGrammarsError",
      error: true,
      payload: error,
    });
  }
}

function* postUserWrongGrammarsSaga(action) {
  try {
    const response = yield call(
      wrongGrammarsAPI.postUserWrongGrammarIds,
      action.payload
    );
    yield put({
      type: "wrongGrammars/saveUserWrongGrammarsSuccess",
      payload: response.data,
    });
  } catch (error) {
    yield put({
      type: "wrongGrammars/saveUserWrongGrammarsError",
      error: true,
      payload: error,
    });
  }
}

function* fetchUserWrongGrammarBookSaga(action) {
  try {
    const userWrongGrammarBook = yield call(
      wrongGrammarsAPI.getUserWrongGrammarBook,
      action.payload
    );
    yield put({
      type: "wrongGrammars/getUserWrongGrammarBookSuccess",
      payload: userWrongGrammarBook,
    });
  } catch (error) {
    yield put({
      type: "wrongGrammars/getUserWrongGrammarBookError",
      error: true,
      payload: error,
    });
  }
}

function* wrongGrammarsSaga() {
  yield takeEvery(
    "wrongGrammars/getUserWrongGrammars",
    fetchUserWrongGrammarsSaga
  );
  yield takeLatest(
    "wrongGrammars/saveUserWrongGrammars",
    postUserWrongGrammarsSaga
  );
  yield takeEvery(
    "wrongGrammars/getUserWrongGrammarBook",
    fetchUserWrongGrammarBookSaga
  );
}

export default wrongGrammarsSaga;
