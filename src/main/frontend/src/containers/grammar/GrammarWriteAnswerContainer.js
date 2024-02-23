import { useDispatch, useSelector } from "react-redux";
import { popWriteAnswer, clickExample } from "../../modules/quiz/grammarQuiz";
import styled, { css } from "styled-components";
import { Button } from "react-bootstrap";
import { useCallback } from "react";

const Answers = styled.div`
  //스타일
  display: flex;
  align-items: center;
  justify-content: center;
  flex-wrap: wrap;
  border-bottom: 1px solid;
  //크기
  width: 80%;
  //위치
  position: absolute;
  /* top: 40%; */
  left: 50%;
  transform: translateX(-50%);
`;

const Answer = styled(Button)`
  //스타일
  background-color: #f2f2f2;
  margin: 0 5px;
  text-align: center;

  ${(props) =>
    props.clicked &&
    css`
      display: none;
    `}
`;

const GrammarWriteAnswerContainer = ({ examples }) => {
  const writeAnswer = useSelector((state) => state.grammarQuiz.writeAnswer);
  const dispatch = useDispatch();

  const handleAnswerClick = useCallback(
    (idx) => {
      dispatch(popWriteAnswer(idx));
    },
    [dispatch]
  );

  if (writeAnswer && examples && writeAnswer.length === examples.length) {
    const realAnswer = examples.join(" ");
    const userAnswer = writeAnswer.join(" ");
    dispatch(clickExample(realAnswer === userAnswer ? true : false));
  }

  return (
    <Answers>
      {writeAnswer.map((answer, idx) => (
        <Answer
          key={idx}
          variant="light"
          onClick={() => handleAnswerClick(idx)}
        >
          {answer}
        </Answer>
      ))}
    </Answers>
  );
};

export default GrammarWriteAnswerContainer;
