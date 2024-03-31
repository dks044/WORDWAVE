import React from "react";
import MyVocaBooksContainer from "../../containers/myVoca/MyVocaBooksContainer";
import MyVocaBookFormContainer from "../../containers/myVoca/MyVocaBookFormContainer";


const MyVocaBookFormPage = () => {
  return (
    <MyVocaBookFormContainer />
  )
}

export default React.memo(MyVocaBookFormPage);