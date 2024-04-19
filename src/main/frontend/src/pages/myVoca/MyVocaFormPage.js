import React from "react";
import MyVocaFormContainer from "../../containers/myVoca/MyVocaFormContainer";
import { useParams } from "react-router-dom";

const MyVocaFormPage = () => {
  const { myVocaBookId } = useParams();
  return(
    <MyVocaFormContainer myVocaBookId={myVocaBookId} />
  ) 
}

export default MyVocaFormPage;