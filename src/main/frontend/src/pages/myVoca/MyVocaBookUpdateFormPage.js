import React from "react";
import MyVocaBookUpdateFormContainer from "../../containers/myVoca/MyVocaBookUpdateFormContainer"
import { useParams } from "react-router-dom";

const MyVocaBookUpdateFormPage = () => {
  const { myVocaBookId } = useParams();

  return (
    <MyVocaBookUpdateFormContainer myVocaBookId={myVocaBookId}/>
  )
}

export default React.memo(MyVocaBookUpdateFormPage);