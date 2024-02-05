import React from "react"
import { useParams } from "react-router-dom";
import VocaBookDetailContainer from "../containers/voca/VocaBookDetailContainer";

const VocaBookDetailPage = () => {
  const params = useParams();
  return(
    <VocaBookDetailContainer vocaBookId={parseInt(params.vocaBookId,10)}/>
  )
}

export default VocaBookDetailPage;