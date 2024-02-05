import * as vocaAPI from "../api/vocaAPI";
import {
  reducerUtils,
  handleAsyncActions,
  handleAsyncActionsById,
} from '../lib/asyncUtils';

const GET_VOCABOOKLIST = 'GET_VOCABOOKLIST';
const GET_VOCABOOKLIST_SUCCESS = 'GET_VOCABOOKLIST_SUCCESS';
const GET_VOCABOOKLIST_FAILURE = 'GET_VOCABOOKLIST_FAILURE';

const GET_VOCABOOK_DETAIL = 'GET_VOCABOOK_DETAIL';
const GET_VOCABOOK_DETAIL_SUCCESS = 'GET_VOCABOOK_DETAIL_SUCCESS';
const GET_VOCABOOK_DETAIL_FAILURE = 'GET_VOCABOOK_DETAIL_FAILURE';


const initialState = {
  vocaBooks : reducerUtils.initial(),
  vocaBook : reducerUtils.initial()
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

export const getVocaBookDetail = (vocaBookId) => async dispatch => {
  dispatch({type : GET_VOCABOOK_DETAIL});
  try {
    const response = await vocaAPI.getVocaBookDetail(vocaBookId);
    dispatch({type : GET_VOCABOOK_DETAIL_SUCCESS, payload : response.data})
  } catch (e) {
    dispatch({type : GET_VOCABOOK_DETAIL_FAILURE,error : e});
    throw e;
  }
}

export default function voca(state = initialState, action) {
  switch (action.type) {
    case GET_VOCABOOKLIST:
    case GET_VOCABOOKLIST_SUCCESS:
    case GET_VOCABOOKLIST_FAILURE:
      return handleAsyncActions(GET_VOCABOOKLIST, 'vocaBooks')(state, action);
    case GET_VOCABOOK_DETAIL:
    case GET_VOCABOOK_DETAIL_SUCCESS:
    case GET_VOCABOOK_DETAIL_FAILURE:
      return handleAsyncActionsById(GET_VOCABOOK_DETAIL,'vocaBook')(state,action);
    default:
      return state;
  }
}