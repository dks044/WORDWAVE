import React from "react";
import { useParams } from "react-router-dom";
import GrammarContainer from "../../containers/grammar/GrammarContainer";

const GrammarPage = () => {
  const {grammarBookId} = useParams();
  const {category} = useParams();
  return(
    <>
      <GrammarContainer grammarBookId={grammarBookId} category={category}/> 
    </>
  )
}

export default React.memo(GrammarPage);