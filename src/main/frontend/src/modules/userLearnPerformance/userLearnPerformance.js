import { createSlice } from "@reduxjs/toolkit";
import { reducerUtils } from "../../lib/asyncUtils";

const initialState = {
  userLearnHistory : reducerUtils.initial()
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
    })
  }
})


export const {
  getUserLearnHistory,
  getUserLearnHistorySuccess,
  getUserLearnHistoryError,
} =  userLearnPerformanceSlice.actions;

export default userLearnPerformanceSlice.reducer;