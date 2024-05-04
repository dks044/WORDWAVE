import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import styled from "styled-components";
import { getGrammar } from "../../modules/grammar/grammar";
import { showPopup } from "../../modules/popup";
import CircleSpinner from "../../components/CircleSpinner";
import { ProgressBar } from "react-bootstrap";
import Grammar from "../../components/grammar/Grammar"

const GrammarContainerBlock = styled.div`
  overflow-y: scroll;
  text-align: center;
`
const ProgressBarBlock = styled.div`
  margin-bottom: 3%;
`


function GrammarContainer({grammarBookId,category}){
  const loading = useSelector((state) => state.grammar.grammar?.loading);
  const data = useSelector((state) => state.grammar.grammar?.data);
  const error = useSelector((state) => state.grammar.grammar?.error);

  const [stack, setStack] = useState([]); //Grammar 퀴즈Stack
  const stackSize = stack.length;
  const [currentGrammar, setCurrentGrammar] = useState(null); //현재 Grammar 퀴즈
  const [remaining, setRemaining] = useState(0); //남은단어
  const [total, setTotal] = useState(0);  // 전체 단어의 수

  //퀴즈 데이터 랜더링이 완료 됐는지
  const [isDataLoaded, setIsDataLoaded] = useState(false);

  //제한시간 로직
  const [timeLeft, setTimeLeft] = useState(60); 
  const [variant, setVariant] = useState('info'); 

  const dispatch = useDispatch();
  useEffect(() => {
    dispatch(getGrammar({grammarBookId,category}));
  }, [dispatch, grammarBookId, category]);

  useEffect(() => {
    if (data) {
      setStack([...data]);
      setCurrentGrammar(data[0]);
      setTotal(data.length);
      setRemaining(data.length);
      setIsDataLoaded(true);
    }
  }, [data]);

    //다음 퀴즈로 전환(진행)
    const nextGrammar = () => {
      const newStack = [...stack];
      newStack.shift(); 
      setStack(newStack);
      setTimeLeft(60);
      setCurrentGrammar(newStack[0]); 
      setRemaining(newStack.length);
      setVariant('info');
    };

    //제한시간에 따른 진행도bar
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

    //제한시간이 다 될 경우
    useEffect(() => {
      if (timeLeft === 0) {
        dispatch(showPopup('제한시간이 다 됐습니다!'));
        nextGrammar();
        setTimeLeft(60);
        setVariant('info');
      }
    }, [timeLeft]);

    if (loading && !data) return <CircleSpinner />;
    if (error) return <div>{error.message}</div>;

    return (
      <GrammarContainerBlock>
        <ProgressBarBlock>
          <ProgressBar animated now={((total - remaining) / total) * 100} />
        </ProgressBarBlock>
        <ProgressBarBlock>
          <ProgressBar animated variant={variant} now={(timeLeft / 60) * 100} />
        </ProgressBarBlock>
        <Grammar grammar={currentGrammar} nextGrammar={nextGrammar} stackSize={stackSize} timeLeft={timeLeft} category={category} isDataLoaded={isDataLoaded}/>
      </GrammarContainerBlock>
    )
}

export default React.memo(GrammarContainer);