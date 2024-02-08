import React from "react";
import { useParams } from "react-router-dom";
import VocaBookContainer from "../../containers/voca/VocaBookContainer";

const VocaBookPage = () =>{
  const {vocaBookId} = useParams();
  return (
    <VocaBookContainer vocaBookId={vocaBookId}/>
  )
}

export default React.memo(VocaBookPage);