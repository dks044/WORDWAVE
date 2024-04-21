import React from "react";
import { useParams } from "react-router-dom";
import MyVocaUpdateFormContainer from "../../containers/myVoca/MyVocaUpdateFormContainer";

const MyVocaUpdateFormPage = () => {
  const { myVocaBookId } = useParams();
  const { category } =useParams();

  return (
    <MyVocaUpdateFormContainer myVocaBookId={myVocaBookId} category={category}/>
  )
}

export default React.memo(MyVocaUpdateFormPage);