import { call, put, takeEvery } from "redux-saga/effects";
import * as vocaAPI from "../../api/vocaAPI"

function* fetchVocaBooksSaga(){
  try {
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

function* fetchCategoriesOfVocaBook(){
  try {
    const categoriesOfVocaBook = yield call(vocaAPI.getVocaBookDetailByIdAPI);
    yield put ({
      type : "vocaBook/getCategoriesOfVocaBookSuccess",
      payload : categoriesOfVocaBook
    });
  } catch (error) {
    yield put({
      type: "vocaBook/getCategoriesOfVocaBookError",
      error: true,
      payload: error,
    });
  }
}

function* vocaBookSaga() {
  yield takeEvery("vocaBook/getVocaBooks", fetchVocaBooksSaga);
  yield takeEvery("vocaBook/getCategoriesOfVocaBook", fetchCategoriesOfVocaBook);
}

export default vocaBookSaga;