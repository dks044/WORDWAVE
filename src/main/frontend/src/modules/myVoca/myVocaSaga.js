import { call, put, take, takeEvery, takeLatest } from "redux-saga/effects";
import * as myVocaAPI from "../../api/myVocaAPI";

function* fetchUpdateFormMyVocaSaga(action){
  try {
    const updateFormMyVoca = yield call(myVocaAPI.getUpdateFormMyVocaAPI,action.payload);
    yield put ({
      type: "updateFormMyVoca/getUpdateFormMyVocaSuccess",
      payload : updateFormMyVoca
    });
    
  } catch (e) {
    yield put({
      type: "updateFormMyVoca/getUpdateFormMyVocaError",
      error: true,
      payload: e.message,
    });
  }
}

function* myVocaSaga() {
  yield takeEvery("myVoca/getUpdateFormMyVoca", fetchUpdateFormMyVocaSaga);
}

export default myVocaSaga;