import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import styled from "styled-components";
import { getVoca } from "../../modules/voca/voca";
import CircleSpinner from "../../components/CircleSpinner";
import Voca from "../../components/voca/Voca";

const VocaContainerBlock = styled.div`
  padding: 10% 15% 10%;
  overflow-y: scroll;
`
  
function VocaContainer({vocaBookId,category}){
  const loading = useSelector((state) => state.voca.voca.loading);
  const data = useSelector((state) => state.voca.voca.data);
  const error = useSelector((state) => state.voca.voca.error);
  const dispatch = useDispatch();
  useEffect(()=>{
    console.log("호출!");
    dispatch(getVoca({ vocaBookId, category }));
  },[dispatch,vocaBookId,category]);

  if (loading && !data) return <CircleSpinner />;
  if (error) return <div>{error.message}</div>;
  return (
    <VocaContainerBlock>
      <Voca voca={data}/>
    </VocaContainerBlock>
  )
}

export default React.memo(VocaContainer);