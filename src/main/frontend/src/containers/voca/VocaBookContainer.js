import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import styled from "styled-components";
import CircleSpinner from "../../components/CircleSpinner";
import { getCategoriesOfVocaBook } from "../../modules/voca/vocaBook";
import VocaBook from "../../components/voca/VocaBook";

const VocaBookContainerBlock = styled.div`
  padding: 10% 5% 10%;
  overflow-y: scroll;
`
function VocaBookOfCategoriesContainer( {vocaBookId} ){
  const loading = useSelector(
    (state) => state.vocaBook.categoriesOfVocaBook.loading
  );
  const data = useSelector((state) => state.vocaBook.categoriesOfVocaBook.data);
  const error = useSelector((state) => state.vocaBook.categoriesOfVocaBook.error);
  const dispatch = useDispatch();

  useEffect(()=>{
    if(data) return;
    dispatch(getCategoriesOfVocaBook(vocaBookId));
  },[vocaBookId,dispatch,data])

  if (loading && !data) return <CircleSpinner />;
  if (error) return <div>{error.message}</div>;
  return (
    <VocaBookContainerBlock>
      <VocaBook categories={data}/>
    </VocaBookContainerBlock>
  )
}

export default React.memo(VocaBookOfCategoriesContainer);