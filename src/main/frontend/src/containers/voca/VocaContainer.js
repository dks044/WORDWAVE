import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import styled from "styled-components";
import { getVoca } from "../../modules/voca/voca";
import CircleSpinner from "../../components/CircleSpinner";
import Voca from "../../components/voca/Voca";
import { ProgressBar } from "react-bootstrap";
import { showPopup } from "../../modules/popup";

const VocaContainerBlock = styled.div`

  overflow-y: scroll;
  text-align: center;
`
const ProgressBarBlock = styled.div`
  margin-bottom: 3%;
`

function VocaContainer({vocaBookId,category}){
  const loading = useSelector((state) => state.voca.voca.loading);
  const data = useSelector((state) => state.voca.voca.data);
  const error = useSelector((state) => state.voca.voca.error);
  
  const [stack, setStack] = useState([]); //voca퀴즈Stack
  const stackSize = stack.length;
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
    setTimeLeft(20);
    setCurrentVoca(newStack[newStack.length - 1]);
    setRemaining(newStack.length);
    setVariant('info');
  };
  

  //제한시간 로직
  const [timeLeft, setTimeLeft] = useState(20); 
  const [variant, setVariant] = useState('info'); 

  useEffect(() => {
    if (((total - remaining) / total) * 100 === 100) {
      return;
    }
    const timerId = setInterval(() => {
      setTimeLeft((prevTimeLeft) => {
        if (prevTimeLeft <= 1) {
          clearInterval(timerId);
          return 0;
        } else {
          const newTimeLeft = prevTimeLeft - 1;
          if (newTimeLeft <= 5) {
            setVariant('danger');  
          }
          return newTimeLeft;
        }
      });
    }, 1000); 
  
    return () => {
      clearInterval(timerId);  
    };
  }, [timeLeft]);
  

  useEffect(() => {
    if (timeLeft === 0) {
      dispatch(showPopup('제한시간이 다 됐습니다!'));
      nextVoca();
      setTimeLeft(20);
      setVariant('info');
    }
  }, [timeLeft]);

  if (loading && !data) return <CircleSpinner />;
  if (error) return <div>{error.message}</div>;
  return (
    <VocaContainerBlock>
      <ProgressBarBlock>
        <ProgressBar animated now={((total - remaining) / total) * 100} />
      </ProgressBarBlock>
      <ProgressBarBlock>
        <ProgressBar animated variant={variant} now={(timeLeft / 20) * 100} />
      </ProgressBarBlock>
      <Voca voca={currentVoca} nextVoca={nextVoca} stackSize={stackSize} timeLeft={timeLeft} category={category} />
    </VocaContainerBlock>
  )
}

export default React.memo(VocaContainer);