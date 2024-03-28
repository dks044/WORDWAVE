import { createSlice } from "@reduxjs/toolkit";
import { reducerUtils } from "../../lib/asyncUtils";

const initialState = {
  userLearnHistory : reducerUtils.initial(),
  allUserLearnPerformance : reducerUtils.initial()
};

const userLearnPerformanceSlice = createSlice({
  name : "userLearnPerformance",
  initialState,
  reducers: {
    getUserLearnHistory: (state) => ({
      ...state,
      userLearnHistory: reducerUtils.loading(),
    }),
    getUserLearnHistorySuccess: (state, action) => ({
      ...state,
      userLearnHistory: reducerUtils.success(action.payload),
    }),
    getUserLearnHistoryError: (state, action) => ({
      ...state,
      userLearnHistory: reducerUtils.error(action.error),
    }),
    getAllUserLearnPerformance: (state) => ({
      ...state,
      allUserLearnPerformance: reducerUtils.loading(),
    }),
    getAllUserLearnPerformanceSuccess: (state, action) => ({
      ...state,
      allUserLearnPerformance: reducerUtils.success(action.payload),
    }),
    getAllUserLearnPerformanceError: (state, action) => ({
      ...state,
      allUserLearnPerformance: reducerUtils.error(action.error),
    })
  }
})


export const {
  getUserLearnHistory,
  getUserLearnHistorySuccess,
  getUserLearnHistoryError,
  getAllUserLearnPerformance,
  getAllUserLearnPerformanceSuccess,
  getAllUserLearnPerformanceError
} =  userLearnPerformanceSlice.actions;

export default userLearnPerformanceSlice.reducer;