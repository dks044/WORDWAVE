import React, { useEffect, useState } from "react";
import { Badge, Button, Card } from "react-bootstrap";
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

const AnimatedWordButton = styled.button`
  animation: fadeIn 0.5s;
  display: inline-block;
  margin-right: 5px;
  background-color: transparent;
  border: 1px solid black;
  border-radius: 5px 5px 5px 5px;

  transition: 0.325s all ease-in;
  @keyframes fadeIn {
    from {
      opacity: 0;
      transform: translateY(-20px);
    }
    to {
      opacity: 1;
      transform: translateY(0);
    }
  }

  cursor: pointer;
  &:hover {
    background: #63e6be;
  }
  &:active {
    background: #20c997;
  }

`;
const PuzzleSubmitButtonBlock = styled.div`
  padding-left: 5%;
  padding-right: 5%;
`


const CategoryTitle = styled.h5`
  margin-top: 10px;
  font-weight: bolder;
  color: skyblue;
`


function Grammar({grammar,nextGrammar,stackSize,timeLeft,category}){
  const dispatch = useDispatch();
  const [answerCount,setAnswerCount] = useState(0);
  const [wrongCount,setWrongCount] = useState(0);
  const [wrongQuiz,setWrongQuiz] = useState([]);
  const [puzzleQuizWordBlock,setPuzzleQuizWordBlock] = useState([]); //퍼즐퀴즈 제출공간
  const [puzzleUserAnser,setPuzzleUserAnser] = useState(''); //사용자 제출 답안
  const [wordBlocks, setWordBlock] = useState(grammar ? grammar.wordBlocks : []); //퀴즈 블록
  useEffect(() => {
    if (grammar) {
      setWordBlock(grammar.wordBlocks);
    }
  }, [grammar]);
  
  //제한시간이 끝나도 못 풀었을 경우
  useEffect(()=>{
    if(timeLeft === 0){
     setWrongCount(wrongCount +1);
     setPuzzleQuizWordBlock([]);
    }
  },[timeLeft,wrongCount])
  
  //퀴즈 블록을 누를떄마다 '사용자 제출 답안' 동적 업데이트
  useEffect(() => {
    const updatedPuzzleUserAnswer = puzzleQuizWordBlock.join(' ');
    setPuzzleUserAnser(updatedPuzzleUserAnswer);
    console.log(updatedPuzzleUserAnswer);
  }, [puzzleQuizWordBlock]); 

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
        <Card>
        <Card.Body>
          {puzzleQuizWordBlock.map((data,index)=>{
            return (
              <AnimatedWordButton key={index}
                onClick={()=>{
                  setWordBlock([...wordBlocks,data]);
                  const newPuzzleQuizWordBlock = puzzleQuizWordBlock.filter((block,filterIndex)=>filterIndex !== index);
                  setPuzzleQuizWordBlock(newPuzzleQuizWordBlock);
                }}
              >
                {data}
              </AnimatedWordButton>
            )
          })}
        </Card.Body>
      </Card>
      <br />
      {wordBlocks.map((data, index) => {
        return (
          <>
            <AnimatedWordButton key={index}
              onClick={()=>{
                setPuzzleQuizWordBlock([...puzzleQuizWordBlock, data]); 
                const newWordBlocks = wordBlocks.filter((block, filterIndex) => filterIndex !== index); 
                setWordBlock(newWordBlocks);
              }}
            >
              {data}
            </AnimatedWordButton>
          </>
        );
      })}
      </>
      }
      <CountBlock>
        <Badge bg="primary">{answerCount}</Badge><Badge bg="danger">{wrongCount}</Badge>
        <CategoryTitle>{category}</CategoryTitle>
      </CountBlock>
      <br/><br/>
      <PuzzleSubmitButtonBlock>
        <div className="d-grid gap-2">
          <Button variant="primary">제출하기!</Button>
          <Button variant="info">못풀겠어요🥹</Button>
        </div>
      </PuzzleSubmitButtonBlock>
      <br/><br/><br/><br/>
    </div>
  )
}

export default Grammar;