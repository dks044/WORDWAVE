import { call, put, takeEvery, takeLatest } from "redux-saga/effects";
import * as myVocaAPI from "../../api/myVocaAPI";

function* fetchMyVocaBooksSaga(action){
  try {
    const myVocaBooks = yield call(myVocaAPI.getMyVocaBooksAPI,action.payload);
    yield put ({
      type: "myVocaBook/getMyVocaBooksSuccess",
      payload : myVocaBooks
    });
    
  } catch (e) {
    yield put({
      type: "myVocaBook/getMyVocaBooksError",
      error: true,
      payload: e.message,
    });
  }
}

function* myVocaBookSaga() {
  yield takeEvery("myVocaBook/getMyVocaBooks", fetchMyVocaBooksSaga);
}

export default myVocaBookSaga;