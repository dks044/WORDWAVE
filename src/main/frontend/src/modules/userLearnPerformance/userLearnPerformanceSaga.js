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

function* fetchAllUserLearnPerformanceSaga(action){
  try {
    const allUserLearnPerformance = yield call(userLearnPerformanceAPI.getAllUserLearnPerformanceAPI, action.payload);
    yield put ({
      type : "userLearnPerformance/getAllUserLearnPerformanceSuccess",
      payload : allUserLearnPerformance
    });
  } catch (e) {
    console.log(e);
    yield put({
      type: "userLearnPerformance/getAllUserLearnPerformanceError",
      error: true,
      payload: e.message,
    });
  }
}


function* userLearnPerformanceSaga() {
  yield takeEvery("userLearnPerformance/getUserLearnHistory", fetchUserLearnHistorySaga);
  yield takeEvery("userLearnPerformance/getAllUserLearnPerformance",fetchAllUserLearnPerformanceSaga);
}

export default userLearnPerformanceSaga;