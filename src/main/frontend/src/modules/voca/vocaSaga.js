import { call, put, takeEvery } from "redux-saga/effects";
import * as vocaAPI from "../../api/vocaAPI"

function* fetchVocaSaga(action){
  try {
    const voca = yield call(vocaAPI.getVocaAPI, action.payload);
    yield put ({
      type : "voca/getVocaSuccess",
      payload : voca
    });
  } catch (e) {
    console.log(e);
    yield put({
      type: "voca/getVocaError",
      error: true,
      payload: e.message,
    });
  }
}



function* vocaSaga() {
  yield takeEvery("voca/getVoca", fetchVocaSaga);
}

export default vocaSaga;