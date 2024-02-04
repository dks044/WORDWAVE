import * as vocaAPI from "../api/vocaAPI";
import {
  reducerUtils,
  handleAsyncActions,
  handleAsyncActionsById,
} from '../lib/asyncUtils';

const GET_VOCABOOKLIST = 'GET_VOCABOOKLIST';
const GET_VOCABOOKLIST_SUCCESS = 'GET_VOCABOOKLIST_SUCCESS';
const GET_VOCABOOKLIST_FAILURE = 'GET_VOCABOOKLIST_FAILURE';

const initialState = {
  vocabooks : reducerUtils.initial()
}


export const getVocaBookList = async dispatch => {
  dispatch({type : GET_VOCABOOKLIST})
  try {
    const payload = vocaAPI.getVocaBookAPI();
    dispatch({type: GET_VOCABOOKLIST_SUCCESS , payload})
    return payload;
  } catch (e) {
    dispatch({type : GET_VOCABOOKLIST_FAILURE,error : e});
    throw e;
  }
}

export default function voca(state = initialState, action) {
  switch (action.type) {
    case GET_VOCABOOKLIST:
    case GET_VOCABOOKLIST_SUCCESS:
    case GET_VOCABOOKLIST_FAILURE:
      return handleAsyncActionsById(GET_VOCABOOKLIST, 'vocabooks')(state, action);
    default:
      return state;
  }
}