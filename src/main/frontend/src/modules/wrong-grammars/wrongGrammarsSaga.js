import * as wrongGrammarsAPI from "../../api/wrongGrammarsAPI";
import { call, put, takeEvery } from "redux-saga/effects";

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

function* wrongGrammarsSaga() {
  yield takeEvery(
    "wrongGrammars/getUserWrongGrammars",
    fetchUserWrongGrammarsSaga
  );
}

export default wrongGrammarsSaga;
