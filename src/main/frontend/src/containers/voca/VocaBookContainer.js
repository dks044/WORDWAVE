import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import styled from "styled-components";
import { getCategoriesOfVocaBook, getVocaBookName } from "../../modules/voca/vocaBook";
import CircleSpinner from "../../components/CircleSpinner"
import VocaBook from "../../components/voca/VocaBook";

const VocaBookContainerBlock = styled.div`
  padding: 10% 15% 10%;
  overflow-y: scroll;
`
function VocaBookOfCategoriesContainer( {vocaBookId} ){
  const loading = useSelector(
    (state) => state.vocaBook.categoriesOfVocaBook.loading
  );
  const data = useSelector((state) => state.vocaBook.categoriesOfVocaBook.data);
  const error = useSelector((state) => state.vocaBook.categoriesOfVocaBook.error);
  const vocaBookName = useSelector((state)=>state.vocaBook.vocaBookName.data)

  const dispatch = useDispatch();

  useEffect(()=>{
    dispatch(getCategoriesOfVocaBook(vocaBookId));
    dispatch(getVocaBookName(vocaBookId));
  },[dispatch,vocaBookId])

  if (loading && !data) return <CircleSpinner />;
  if (error) return <div>{error.message}</div>;
  return (
    <VocaBookContainerBlock>
      <VocaBook categories={data} vocaBookName={vocaBookName} />
      <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
    </VocaBookContainerBlock>
  )
}

export default React.memo(VocaBookOfCategoriesContainer);