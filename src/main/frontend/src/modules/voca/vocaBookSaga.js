import { call, put, takeEvery } from "redux-saga/effects";
import * as vocaAPI from "../../api/vocaAPI"

function* fetchVocaBooksSaga(){
  try {
    yield put({ type: "vocaBook/resetVocaBooks" });
    const vocaBooks = yield call(vocaAPI.getVocaBooksAPI);
    yield put ({
      type: "vocaBook/getVocaBooksSuccess",
      payload : vocaBooks
    });
    console.log(vocaBooks);
  } catch (error) {
    yield put({
      type: "vocaBook/getVocaBooksError",
      error: true,
      payload: error,
    });
  }
}

function* vocaBookSaga() {
  yield takeEvery("vocaBook/getVocaBooks", fetchVocaBooksSaga);

}

export default vocaBookSaga;