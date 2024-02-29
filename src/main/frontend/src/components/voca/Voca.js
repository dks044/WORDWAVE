import React, { useState } from "react";
import { Badge, Button, Form } from "react-bootstrap";
import { useDispatch } from "react-redux";
import styled from "styled-components";
import { showPopup } from "../../modules/popup";
import { PieChart, Pie, Cell, Tooltip } from 'recharts';

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

function Voca({ voca,nextVoca,done }) {
  const [answerCount,setAnswerCount] = useState(0);
  const [wrongCount,setWrongCount] = useState(0);
  const [userAnswer, setUserAnswer] = useState('');
  const [wrongQuiz,setWrongQuiz] = useState([]);

  const dispatch = useDispatch();
  console.log(done);
  //차트
  const data = [
    { name: '정답 수', value: answerCount },
    { name: '오답 수', value: wrongCount }
  ];
  const COLORS = ['#00C49F', '#FF8042'];

  if (!voca) return null;

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
    {done && 
      <>
        <PieChart width={400} height={400}>
          <Pie
            data={data}
            cx={200}
            cy={200}
            labelLine={false}
            outerRadius={80}
            fill="#8884d8"
            dataKey="value"
          >
            {
              data.map((entry, index) => <Cell key={`cell-${index}`} fill={COLORS[index % COLORS.length]} />)
            }
          </Pie>
          <Tooltip />
        </PieChart>
      </>
    }
    <CountBlock>
      <Badge bg="success">{answerCount}</Badge><Badge bg="danger">{wrongCount}</Badge>
    </CountBlock>
    </div>
  );
}

export default React.memo(Voca);
