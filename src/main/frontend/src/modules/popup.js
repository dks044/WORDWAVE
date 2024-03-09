const SHOW_POPUP = 'popup/SHOW_POPUP';
const CLOSE_POPUP = 'popup/CLOSE_POPUP';

export const showPopup = (message) => ({ type: SHOW_POPUP, payload: message });

export const closePopup = () => ({ type: CLOSE_POPUP }); 

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
    case CLOSE_POPUP:
      return{
          isOpen: false,
          message: ''
      }
    default:
      return state;
  }
}

export default popup;
