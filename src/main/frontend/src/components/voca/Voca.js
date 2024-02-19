import React, { useEffect, useState } from "react";
import { Button, Form, InputGroup, ProgressBar } from "react-bootstrap";
import { useDispatch } from "react-redux";
import styled from "styled-components";
import { showPopup } from "../../modules/popup";

const HidenEngWord = styled.h1`
  font-weight: bolder;
`
const KorWord = styled.h2`
  font-weight: bolder;
`

function Voca({ voca,nextVoca }) {
  const [answerCount,setAnswerCount] = useState(0);
  const [wrongCount,setWrongCount] = useState(0);
  const [userAnswer, setUserAnswer] = useState('');
  const dispatch = useDispatch();

  if (!voca) return null;

  return (
    <div>
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
          />
          <label htmlFor="floatingInputCustom">답안 입력(풀네임으로)</label>
          <div className="d-grid gap-2">
            <Button variant="primary" size="lg" onClick={() => {
              if (userAnswer === voca.engWord) {
                setAnswerCount(answerCount + 1);
                dispatch(showPopup('정답입니다!😎'));
                setUserAnswer('');
                nextVoca();
              } else {
                dispatch(showPopup(`틀렸습니다! 정답은 ${voca.engWord} 입니다.🥹`));
                setWrongCount(wrongCount +1);
                setUserAnswer('');
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
    </div>
  );
}

export default React.memo(Voca);
