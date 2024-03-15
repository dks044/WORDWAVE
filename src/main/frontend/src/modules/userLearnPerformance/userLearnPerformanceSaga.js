import { call, put, takeEvery } from "redux-saga/effects";
import * as userLearnPerformanceAPI from "../../api/userLearnPerformanceAPI"

function* fetchUserLearnHistorySaga(action){
  try {
    const userLearnHistory = yield call(userLearnPerformanceAPI.getUserLearnHistoryAPI, action.payload);
    yield put ({
      type : "userLearnPerformance/getUserLearnHistorySuccess",
      payload : userLearnHistory
    });
  } catch (e) {
    console.log(e);
    yield put({
      type: "userLearnPerformance/getUserLearnHistoryError",
      error: true,
      payload: e.message,
    });
  }
}

function* userLearnPerformanceSaga() {
  yield takeEvery("userLearnPerformance/getUserLearnHistory", fetchUserLearnHistorySaga);
}

export default userLearnPerformanceSaga;