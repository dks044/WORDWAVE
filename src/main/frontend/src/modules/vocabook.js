import { createAsyncThunk } from "@reduxjs/toolkit";
import * as vocaAPI from "../api/vocaAPI";
import {
  reducerUtils,
  handleAsyncActions,
  handleAsyncActionsById,
  createPromiseThunkById,
} from '../lib/asyncUtils';

const GET_VOCABOOKLIST = 'GET_VOCABOOKLIST';
const GET_VOCABOOKLIST_SUCCESS = 'GET_VOCABOOKLIST_SUCCESS';
const GET_VOCABOOKLIST_FAILURE = 'GET_VOCABOOKLIST_FAILURE';

const GET_VOCABOOK_DETAIL = 'GET_VOCABOOK_DETAIL';
const GET_VOCABOOK_DETAIL_SUCCESS = 'GET_VOCABOOK_DETAIL_SUCCESS';
const GET_VOCABOOK_DETAIL_FAILURE = 'GET_VOCABOOK_DETAIL_FAILURE';


const initialState = {
  vocaBooks : reducerUtils.initial(),
  vocaBookCategory : {}
}

export const getVocaBookList = () => async dispatch => {
  dispatch({type : GET_VOCABOOKLIST})
  try {
    const response = await vocaAPI.getVocaBookAPI();
    dispatch({type: GET_VOCABOOKLIST_SUCCESS , payload : response.data})
    return response.data;
  } catch (e) {
    dispatch({type : GET_VOCABOOKLIST_FAILURE,error : e});
    throw e;
  }
}

export const getVocaBookDetailById = createPromiseThunkById(GET_VOCABOOK_DETAIL,vocaAPI.getVocaBookDetailByIdAPI);


export default function voca(state = initialState, action) {
  switch (action.type) {
    case GET_VOCABOOKLIST:
    case GET_VOCABOOKLIST_SUCCESS:
    case GET_VOCABOOKLIST_FAILURE:
      return handleAsyncActions(GET_VOCABOOKLIST, 'vocaBooks',true)(state, action);
    case GET_VOCABOOK_DETAIL:
    case GET_VOCABOOK_DETAIL_SUCCESS:
    case GET_VOCABOOK_DETAIL_FAILURE:
      return handleAsyncActionsById(GET_VOCABOOK_DETAIL,'vocaBookCategory')(state, action);
    default:
      return state;
  }
}
