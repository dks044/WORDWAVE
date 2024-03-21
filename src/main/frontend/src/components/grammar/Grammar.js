import React, { useEffect, useState } from "react";
import { Badge, Button } from "react-bootstrap";
import styled from "styled-components";
import { showPopup } from "../../modules/popup";
import { useDispatch, useSelector } from "react-redux";

const EngSentence = styled.h3`
  font-weight: bolder;
`
const KorSentence = styled.h4`
  color: blue;
`

const CountBlock = styled.div`
  position: absolute;
  z-index: 1;
  left: 50%;
  transform: translateX(-50%);
  top: 17%;
`

const PuzzleQuizTile = styled.h3`
  font-weight: bolder;
`
const CategoryTitle = styled.h5`
  margin-top: 10px;
  font-weight: bolder;
  color: skyblue;
`

function Grammar({grammar,nextGrammar,stackSize,timeLeft,category}){
  const [answerCount,setAnswerCount] = useState(0);
  const [wrongCount,setWrongCount] = useState(0);
  const [wrongQuiz,setWrongQuiz] = useState([]);
  const dispatch = useDispatch();

  //제한시간이 끝나도 못 풀었을 경우
  useEffect(()=>{
    if(timeLeft === 0){
     setWrongCount(wrongCount +1);
    }
  },[timeLeft,wrongCount])

  if (!grammar) return (
    <>
      <p>grammar가 없어요</p>
    </>
  )

  return (
    <div>
      <br/><br/><br/><br/>
      {/* 객관식 퀴즈 (quizStaus == 1) */}
      {grammar.quizStatus === 1 &&
        <>
          <EngSentence>{grammar.engSentence}</EngSentence>
          <KorSentence>{grammar.korSentence}</KorSentence>
          <hr/>
          <p>문장의 빈칸과 뜻을 참고하고 알맞은 정답을 누르세요!</p>
          {grammar.blackOptions.map((data,index)=>{
            return (
              <div key={index} className="d-grid gap-2">
                <Button variant="outline-primary" size="lg" value={data} onClick={() => {
                  if (data === grammar.answer) {
                    setAnswerCount(answerCount + 1);
                    dispatch(showPopup('정답입니다!😎'));
                    nextGrammar();
                  } else {
                    dispatch(showPopup(`틀렸습니다! 정답은 ${grammar.answer} 입니다.🥹`));
                    setWrongCount(wrongCount +1);
                    setWrongQuiz([...wrongQuiz, { engSentence: grammar.engSentence, answer: grammar.answer, korSentence: grammar.korSentence }]);// 틀린 퀴즈의 정보 저장
                    nextGrammar();
                  }
                }}>
                  {data}
                </Button>
              </div>
            )
          })}
        </>
      }
      {/* 퍼블식 퀴즈 (quizStaus == 2) */}
      {grammar.quizStatus === 2 &&
      <>
        <PuzzleQuizTile>{grammar.korSentence}</PuzzleQuizTile>
        <hr/>
        <p>뜻을 참고하고, 블록을 눌러 영어문장을 완성하세요!</p>

      </>
      }
      <CountBlock>
        <Badge bg="primary">{answerCount}</Badge><Badge bg="danger">{wrongCount}</Badge>
        <CategoryTitle>{category}</CategoryTitle>
      </CountBlock>
    </div>
  )

}

export default Grammar;