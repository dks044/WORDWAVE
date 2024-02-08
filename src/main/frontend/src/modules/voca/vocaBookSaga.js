import { call, put, takeEvery } from "redux-saga/effects";
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

function* fetchCategoriesOfVocaBook(action){
  try {
    const categoriesOfVocaBook = yield call(vocaAPI.getVocaBookDetailByIdAPI,action.payload);
    yield put ({
      type : "vocaBook/getCategoriesOfVocaBookSuccess",
      payload : categoriesOfVocaBook,
    });
  } catch (e) {
    console.error(e);
    yield put({
      type: "vocaBook/getCategoriesOfVocaBookError",
      error: true,
      payload: e.message,
    });
  }
}

function* fetchVocaBookName(action){
  try {
    const vocaBookName = yield call(vocaAPI.getVocaBookNameByIdAPI,action.payload);
    yield put ({
      type : "vocaBook/getVocaBookNameSuccess",
      payload : vocaBookName,
    });
  } catch (e) {
    console.error(e);
    yield put({
      type: "vocaBook/getVocaBookNameError",
      error: true,
      payload: e.message,
    });
  }
}


function* vocaBookSaga() {
  yield takeEvery("vocaBook/getVocaBooks", fetchVocaBooksSaga);
  yield takeEvery("vocaBook/getCategoriesOfVocaBook", fetchCategoriesOfVocaBook);
  yield takeEvery("vocaBook/getVocaBookName", fetchVocaBookName);
}

export default vocaBookSaga;