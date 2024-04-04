import React from "react";
import { useParams } from "react-router-dom";
import MyVocaBookContainer from "../../containers/myVoca/MyVocaBookContainer";

const MyVocaBookPage = () =>{
  const {myVocaBookId} = useParams();
  return (
    <MyVocaBookContainer myVocaBookId={myVocaBookId}/>
  )
}

export default React.memo(MyVocaBookPage);