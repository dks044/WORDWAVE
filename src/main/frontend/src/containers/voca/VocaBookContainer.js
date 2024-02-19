import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import styled from "styled-components";
import {getVocaBook} from "../../modules/voca/vocaBook"
import CircleSpinner from "../../components/CircleSpinner"
import VocaBook from "../../components/voca/VocaBook";

const VocaBookContainerBlock = styled.div`
  padding: 10% 15% 10%;
  overflow-y: scroll;
`
function VocaBookOfCategoriesContainer( {vocaBookId} ){
  const loading = useSelector((state) => state.vocaBook.vocaBook.loading);
  const data = useSelector((state) => state.vocaBook.vocaBook.data);
  const error = useSelector((state) => state.vocaBook.vocaBook.error);

  const dispatch = useDispatch();

  useEffect(()=>{
    dispatch(getVocaBook({vocaBookId}));
  },[dispatch,vocaBookId])

  if (loading && !data) return <CircleSpinner />;
  console.log(data);
  if (error) return <div>{error.message}</div>;
  return (
    <VocaBookContainerBlock>
      <VocaBook vocaBook={data} />
      <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
    </VocaBookContainerBlock>
  )
}

export default VocaBookOfCategoriesContainer;