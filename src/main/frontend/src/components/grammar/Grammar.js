import React, { useEffect, useState } from "react";
import { Badge, Button, Card, ListGroup } from "react-bootstrap";
import styled from "styled-components";
import { showPopup } from "../../modules/popup";
import { useDispatch, useSelector } from "react-redux";
import SimplePieChart from "../SimplePieChart";
import {createUserLearnPerformanceAPI} from "../../api/userLearnPerformanceAPI"


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
const Title = styled.h1`
  font-weight: bolder;
`
const CardContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 20px; // Card 사이의 여백
`;

function Grammar({grammar,nextGrammar,stackSize,timeLeft,category}){
  const dispatch = useDispatch();
  const [answerCount,setAnswerCount] = useState(0);
  const [wrongCount,setWrongCount] = useState(0);
  const [wrongQuiz,setWrongQuiz] = useState([]);
  const [puzzleQuizWordBlock,setPuzzleQuizWordBlock] = useState([]); //퍼즐퀴즈 제출공간
  const [puzzleUserAnser,setPuzzleUserAnser] = useState(''); //사용자 제출 답안
  const [wordBlocks, setWordBlock] = useState(grammar ? grammar.wordBlocks : []); //퀴즈 블록
  const {user} = useSelector(state=>state.auth);
  //차트
  const data = [
    { name: '정답', value: answerCount },
    { name: '오답', value: wrongCount }
  ];

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
     setWrongQuiz([...wrongQuiz, { engSentence: grammar.engSentence, answer: grammar.answer, korSentence: grammar.korSentence }]);// 틀린 퀴즈의 정보 저장
    }
  },[timeLeft,wrongCount,wrongQuiz])

  //퀴즈 블록을 누를떄마다 '사용자 제출 답안' 동적 업데이트
  useEffect(() => {
    const updatedPuzzleUserAnswer = puzzleQuizWordBlock.join(' ');
    setPuzzleUserAnser(updatedPuzzleUserAnswer);
    console.log(updatedPuzzleUserAnswer);
  }, [puzzleQuizWordBlock]); 

  //퀴즈를 다풀면 학습이력을 서버에 전송
  //learnType : 1(VOCA) , 2(GRAMMAR)
  useEffect(()=>{
    if(stackSize ===0){
      createUserLearnPerformanceAPI({
        userId: user.id,
        category: category,
        learnType: 2,
        answerCount: answerCount,
        wrongCount: wrongCount
      });
    }
  });


  //grammar가 없을경우(퀴즈를 다 풀었을경우)
  if (!grammar) return (
    //stackSize가 0일경우 (퀴즈를 다 풀었을 경우)
    <div>
      {stackSize === 0 &&
        <>
          <CategoryTitle>{category}</CategoryTitle>
          <br />
          <Title>결과</Title>
            <Badge bg="primary">{answerCount}</Badge><Badge bg="danger">{wrongCount}</Badge>
          <SimplePieChart data={data}/>
          <br />
          <Title>틀린 문제들</Title>
          <CardContainer>
            {wrongQuiz.map((quiz, index) => {
              return (
                <Card style={{ width: '18rem' }} key={index} border="warning" bg="warning" text="white">
                  <Card.Header>틀린문제 #{index}</Card.Header>
                  <ListGroup variant="flush">
                    <ListGroup.Item>{quiz.engSentence}</ListGroup.Item>
                    <ListGroup.Item>{quiz.answer}</ListGroup.Item>
                    <ListGroup.Item>{quiz.korSentence}</ListGroup.Item>
                  </ListGroup>
                </Card>
              )
            })}
          </CardContainer>
        </>
      }
      <br/><br/><br/><br/><br/><br/><br/>
    </div>
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
      <br/><br/>
      <PuzzleSubmitButtonBlock>
        <div className="d-grid gap-2">
          <Button variant="primary"
            onClick={()=>{
              //정답을 맞췄다면
              if(grammar.originEngSentence === puzzleUserAnser){
                setAnswerCount(answerCount + 1);
                dispatch(showPopup('정답입니다!😎'));
                setPuzzleQuizWordBlock([]);
                nextGrammar();
              }
              //정답을 못 맞췄다면
              if(grammar.originEngSentence !== puzzleUserAnser){
                dispatch(showPopup('정답이 아닙니다, 다시 풀어보세요!'));
              }
            }}
          >
            제출하기!
          </Button>
          <Button variant="info"
           onClick={()=>{
            dispatch(showPopup(`정답은 ${grammar.originEngSentence}`));
            setWrongCount(wrongCount +1);
            setPuzzleQuizWordBlock([]);
            setWrongQuiz([...wrongQuiz, { engSentence: grammar.engSentence, answer: grammar.answer, korSentence: grammar.korSentence }]);// 틀린 퀴즈의 정보 저장
            nextGrammar();
           }}
          >
            못풀겠어요🥹
          </Button>
        </div>
      </PuzzleSubmitButtonBlock>
      </>
      }
      <CountBlock>
        <Badge bg="primary">{answerCount}</Badge><Badge bg="danger">{wrongCount}</Badge>
        <CategoryTitle>{category}</CategoryTitle>
      </CountBlock>
      <br/><br/><br/><br/>
    </div>
  )
}

export default Grammar;