const SHOW_POPUP = 'popup/SHOW_POPUP';
//const CLOSE_POPUP = 'popup/CLOSE_POPUP';

export const showPopup = (message) => ({ type: SHOW_POPUP, payload: message });

//export const closePopup = () => ({ type: CLOSE_POPUP }); 사용자가 직접 끄면 되니까 일단 보류

const initialState = {
  isOpen: false,
  message: '',
};

function popup(state = initialState, action) {
  switch (action.type) {
    case SHOW_POPUP:
      return {
        isOpen: true,
        message: action.payload,
      };
    default:
      return state;
  }
}

export default popup;
