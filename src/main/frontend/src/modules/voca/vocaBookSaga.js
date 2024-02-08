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
    console.log(categoriesOfVocaBook);
    yield put ({
      type : "vocaBook/getCategoriesOfVocaBookSuccess",
      payload : categoriesOfVocaBook,
    });
    console.log(categoriesOfVocaBook);
  } catch (e) {
    console.error(e);
    yield put({
      type: "vocaBook/getCategoriesOfVocaBookError",
      error: true,
      payload: e.message,
    });
  }
}

function* vocaBookSaga() {
  yield takeEvery("vocaBook/getVocaBooks", fetchVocaBooksSaga);
  yield takeEvery("vocaBook/getCategoriesOfVocaBook", fetchCategoriesOfVocaBook);
}

export default vocaBookSaga;