import React from "react";
import GrammarBookContainer from "../../containers/grammar/GrammarBookContainer";
import { useParams } from "react-router-dom";

const GrammarBookPage = () => {
  const {grammarBookId} = useParams();
  console.log(grammarBookId);
  return (
    <GrammarBookContainer grammarBookId={grammarBookId}/>
  )
}

export default React.memo(GrammarBookPage);