import React from "react";
import { useParams } from "react-router-dom";
import VocaContainer from "../../containers/voca/VocaContainer";


const VocaPage = () =>{
  const {vocaBookId} = useParams();
  const {category} = useParams();
  return (
    <>
      <VocaContainer vocaBookId={vocaBookId} category={category}/>
    </>
  )
}

export default React.memo(VocaPage);