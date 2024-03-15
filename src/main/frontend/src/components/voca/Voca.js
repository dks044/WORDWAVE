import React, { useEffect, useState } from "react";
import { Badge, Button, Card, Form, ListGroup } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import styled from "styled-components";
import { showPopup } from "../../modules/popup";
import SimplePieChart from "../SimplePieChart";
import {createUserLearnPerformanceAPI} from "../../api/userLearnPerformanceAPI"

const HidenEngWord = styled.h1`
  font-weight: bolder;
`
const KorWord = styled.h2`
  font-weight: bolder;
`
const CountBlock = styled.div`
  position: absolute;
  z-index: 1;
  left: 50%;
  transform: translateX(-50%);
  top: 17%;
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



function Voca({ voca,nextVoca,stackSize,timeLeft,category }) {
  const [answerCount,setAnswerCount] = useState(0);
  const [wrongCount,setWrongCount] = useState(0);
  const [userAnswer, setUserAnswer] = useState('');
  const [wrongQuiz,setWrongQuiz] = useState([]);
  const dispatch = useDispatch();
  const {user} = useSelector(state=>state.auth);

  //차트
  const data = [
    { name: '정답', value: answerCount },
    { name: '오답', value: wrongCount }
  ];

  useEffect(()=>{
    //제한시간이 끝나도 못 풀었을 경우
    if(timeLeft === 0){
     setWrongCount(wrongCount +1);
    }
  },[timeLeft,wrongCount])

  useEffect(()=>{
    if(stackSize ===0){
      createUserLearnPerformanceAPI({
        userId: user.id,
        category: category,
        learnType: 1,
        answerCount: answerCount,
        wrongCount: wrongCount
      });
    }
  });


  if (!voca) return (
    <div>
      {stackSize === 0 &&
        <>
          <br />
          <Title>결과</Title>
            <Badge bg="success">{answerCount}</Badge><Badge bg="danger">{wrongCount}</Badge>
          <SimplePieChart data={data}/>
          <br />
          <Title>틀린 단어들</Title>
          <CardContainer>
            {wrongQuiz.map((quiz, index) => {
              return (
                <Card style={{ width: '18rem' }} key={index} border="warning" bg="warning" text="white">
                  <Card.Header>틀린단어 #{index}</Card.Header>
                  <ListGroup variant="flush">
                    <ListGroup.Item>{quiz.engWord}</ListGroup.Item>
                    <ListGroup.Item>{quiz.korWord}</ListGroup.Item>
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
      {/* 영어부터 제시하는 퀴즈일 경우 */}
      {voca.quizStatus === 1 && 
      <>
        <HidenEngWord>{voca.hiddenEngWord}</HidenEngWord>
        <h5>{voca.korWord}</h5>
        <hr />
        <Form.Floating className="mb-3">
          <Form.Control
            id="floatingInputCustom"
            type="email"
            placeholder="답안 입력하기"
            value={userAnswer}
            onChange={(e) => setUserAnswer(e.target.value)}
            onKeyDown={(e) => {
              if (e.key === 'Enter') {
                e.preventDefault();
                if (userAnswer.toLowerCase() === voca.engWord) {
                  setAnswerCount(answerCount + 1);
                  dispatch(showPopup('정답입니다!😎'));
                  setUserAnswer('');
                  nextVoca();
                } else {
                  dispatch(showPopup(`틀렸습니다! 정답은 ${voca.engWord} 입니다.🥹`));
                  setWrongCount(wrongCount +1);
                  setUserAnswer('');
                  setWrongQuiz([...wrongQuiz, { korWord: voca.korWord, engWord: voca.engWord }]);
                  nextVoca();
                }
              }
            }}
          />
          <label htmlFor="floatingInputCustom">답안 입력(풀네임으로)</label>
          <div className="d-grid gap-2">
            <Button variant="primary" size="lg" onClick={() => {
              if (userAnswer.toLowerCase() === voca.engWord) {
                setAnswerCount(answerCount + 1);
                dispatch(showPopup('정답입니다!😎'));
                setUserAnswer('');
                nextVoca();
              } else {
                dispatch(showPopup(`틀렸습니다! 정답은 ${voca.engWord} 입니다.🥹`));
                setWrongCount(wrongCount +1);
                setUserAnswer('');
                setWrongQuiz([...wrongQuiz, { korWord: voca.korWord, engWord: voca.engWord }]);// 틀린 퀴즈의 정보 저장
                nextVoca();
              }
            }}>
              정답제출하기
            </Button>
          </div>
        </Form.Floating>
        <input type="hidden" value={voca.engWord}/>
      </>
      }
    {/* 한글부터 제시하는 퀴즈일 경우 */}
    {voca.quizStatus === 2 && 
    <>
      <KorWord>{voca.korWord}</KorWord>
      <hr />
      <p>뜻에 맞는 영단어를 누르세요!</p>
      {voca.randomEngWord.map((data, index) => {
        return (
          <div key={index} className="d-grid gap-2">
            <Button variant="outline-primary" size="lg" value={data} onClick={() => {
              if (data === voca.engWord) {
                setAnswerCount(answerCount + 1);
                dispatch(showPopup('정답입니다!😎'));
                setUserAnswer('');
                nextVoca();
              } else {
                dispatch(showPopup(`틀렸습니다! 정답은 ${voca.engWord} 입니다.🥹`));
                setWrongCount(wrongCount +1);
                setUserAnswer('');
                setWrongQuiz([...wrongQuiz, { korWord: voca.korWord, engWord: voca.engWord }]);// 틀린 퀴즈의 정보 저장
                nextVoca();
              }
            }}>
              {data}
            </Button>
          </div>
        );
      })}
    </> 
    }
    <CountBlock>
      <Badge bg="success">{answerCount}</Badge><Badge bg="danger">{wrongCount}</Badge>
    </CountBlock>
    </div>
  );
}

export default Voca
