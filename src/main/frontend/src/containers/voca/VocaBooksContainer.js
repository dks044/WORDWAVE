import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getVocaBooks } from "../../modules/voca/vocaBook";
import CircleSpinner from "../../components/CircleSpinner"
import VocaBooks from "../../components/voca/VocaBooks";
import styled from "styled-components";
const VocaBooksContainerBlock = styled.div`
  padding: 10% 5% 10%;
  
`

function VocaBooksContainer(){
  const loading = useSelector(
    (state) => state.vocaBook.vocaBooks.loading
  );
  const data = useSelector((state) => state.vocaBook.vocaBooks.data);
  const error = useSelector((state) => state.vocaBook.vocaBooks.error);
  const dispatch = useDispatch();

  useEffect(() => {
    if (data) return;
    dispatch(getVocaBooks());
  }, [data, dispatch]);

  if (loading && !data) return <CircleSpinner />;
  if (error) return <div>{error.message}</div>;
  console.log(data);
  return (
    <VocaBooksContainerBlock>
      <VocaBooks vocaBooks={data}/>
    </VocaBooksContainerBlock>
  )
}


export default React.memo(VocaBooksContainer);