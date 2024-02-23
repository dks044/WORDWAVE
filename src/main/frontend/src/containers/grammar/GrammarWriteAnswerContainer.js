import { useDispatch, useSelector } from "react-redux";
import { popWriteAnswer, clickExample } from "../../modules/quiz/grammarQuiz";
import styled from "styled-components";
import { ToggleButton } from "react-bootstrap";
import { useCallback } from "react";

const Answers = styled.div`
  //스타일
  flex-wrap: wrap;
  //크기
  width: 100%;
  //위치
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
`;

const Answer = styled(ToggleButton)`
  //스타일
  margin: 5px 5px;
  text-align: center;

  &:disabled {
    background-color: #f2f2f2;
    color: #ccc;
    cursor: not-allowed;
  }
`;

const GrammarWriteAnswerContainer = ({ examples, isSubmit }) => {
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
          variant="secondary"
          onClick={() => handleAnswerClick(idx)}
          disabled={isSubmit} //적용 안됨...
        >
          {answer}
        </Answer>
      ))}
    </Answers>
  );
};

export default GrammarWriteAnswerContainer;
