import { call, put, take, takeEvery, takeLatest } from "redux-saga/effects";
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
function* fetchMyVocaBookSaga(action){
  try {
    const myVocaBook = yield call(myVocaAPI.getMyVocaBookAPI,action.payload);
    yield put ({
      type: "myVocaBook/getMyVocaBookSuccess",
      payload : myVocaBook
    });
    
  } catch (e) {
    yield put({
      type: "myVocaBook/getMyVocaBookError",
      error: true,
      payload: e.message,
    });
  }
}



function* myVocaBookSaga() {
  yield takeEvery("myVocaBook/getMyVocaBooks", fetchMyVocaBooksSaga);
  yield takeEvery("myVocaBook/getMyVocaBook", fetchMyVocaBookSaga);
}

export default myVocaBookSaga;