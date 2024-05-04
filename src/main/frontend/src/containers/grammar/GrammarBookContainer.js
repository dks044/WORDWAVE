import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import styled from "styled-components";
import CircleSpinner from "../../components/CircleSpinner"
import {getGrammarBook} from "../../modules/grammar/grammarBook"
import GrammarBook from "../../components/grammar/GrammarBook";

const GrammarBookContainerBlock = styled.div`
  padding: 10% 15% 10%;
  overflow-y: scroll;
`
function GrammarBookContainer( {grammarBookId} ){
  console.log(grammarBookId);
  const loading = useSelector((state) => state.grammarBook.grammarBook?.loading);
  const data = useSelector((state) => state.grammarBook.grammarBook?.data);
  const error = useSelector((state) => state.grammarBook.grammarBook?.error);

  const dispatch = useDispatch();

  useEffect(()=>{
    dispatch(getGrammarBook({grammarBookId}));
  },[dispatch,grammarBookId])

  if (loading && !data) return <CircleSpinner />;

  if (error) return <div>{error.message}</div>;
  return (
    <GrammarBookContainerBlock>
      <GrammarBook grammarBook={data} />
      <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
    </GrammarBookContainerBlock>
  )
}

export default GrammarBookContainer;