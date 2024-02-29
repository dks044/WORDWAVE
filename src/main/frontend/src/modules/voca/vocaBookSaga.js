import { call, put, takeEvery, takeLatest } from "redux-saga/effects";
import * as vocaAPI from "../../api/vocaAPI"

function* fetchVocaBooksSaga(){
  try {
    const vocaBooks = yield call(vocaAPI.getVocaBooksAPI);
    yield put ({
      type: "vocaBook/getVocaBooksSuccess",
      payload : vocaBooks
    });
    //console.log(vocaBooks);
  } catch (e) {
    yield put({
      type: "vocaBook/getVocaBooksError",
      error: true,
      payload: e.message,
    });
  }
}
function* fetchVocaBookSaga(action){
  try {
    const vocaBook = yield call(vocaAPI.getVocaBookAPI, action.payload);
    yield put ({
      type : "vocaBook/getVocaBookSuccess",
      payload : vocaBook,
    });
  } catch (e) {
    console.error(e);
    yield put({
      type: "vocaBook/getVocaBookError",
      error: true,
      payload: e.message,
    });
  }
}

function* vocaBookSaga() {
  yield takeEvery("vocaBook/getVocaBooks", fetchVocaBooksSaga);
  yield takeEvery("vocaBook/getVocaBook", fetchVocaBookSaga);
}

export default vocaBookSaga;