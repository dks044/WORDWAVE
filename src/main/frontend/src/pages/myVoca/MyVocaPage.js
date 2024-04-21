import React from "react";
import { useParams } from "react-router-dom";
import MyVocaContainer from "../../containers/myVoca/MyVocaContainer";

const MyVocaPage = () => {
  const {myVocaBookId} = useParams();
  const {category} = useParams();

  return (
    <MyVocaContainer myVocaBookId={myVocaBookId} category={category}/>
  )
}

export default MyVocaPage;