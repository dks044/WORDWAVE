import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import styled from "styled-components";
import { getVoca } from "../../modules/voca/voca";
import CircleSpinner from "../../components/CircleSpinner";
import Voca from "../../components/voca/Voca";
import { ProgressBar } from "react-bootstrap";

const VocaContainerBlock = styled.div`
  padding: 10% 15% 10%;
  overflow-y: scroll;
`
  
function VocaContainer({vocaBookId,category}){
  const loading = useSelector((state) => state.voca.voca.loading);
  const data = useSelector((state) => state.voca.voca.data);
  const error = useSelector((state) => state.voca.voca.error);
  
  const [stack, setStack] = useState([]); //voca퀴즈Stack
  const [currentVoca, setCurrentVoca] = useState(null); //현재voca
  const [remaining, setRemaining] = useState(0); //남은단어
  const [total, setTotal] = useState(0);  // 전체 단어의 수
  
  const dispatch = useDispatch();
  useEffect(() => {
    dispatch(getVoca({ vocaBookId, category }));
  }, [dispatch, vocaBookId, category]);

  useEffect(() => {
    if (data) {
      setStack([...data]);
      setCurrentVoca(data[0]);
      setTotal(data.length);
      setRemaining(data.length);
    }
  }, [data]);

  const nextVoca = () => {
    const newStack = [...stack];
    newStack.pop();
    setStack(newStack);
    setCurrentVoca(newStack[newStack.length - 1]);
    setRemaining(newStack.length);
  };

  if (loading && !data) return <CircleSpinner />;
  if (error) return <div>{error.message}</div>;
  return (
    <VocaContainerBlock>
      <ProgressBar animated now={((total - remaining) / total) * 100} />;
      <Voca voca={currentVoca} nextVoca={nextVoca}/>
    </VocaContainerBlock>
  )
}

export default React.memo(VocaContainer);