import { useDispatch, useSelector } from "react-redux";
import { useCallback, useMemo } from "react";
import { addWriteAnswer } from "../../modules/quiz/grammarQuiz";
import styled, { css } from "styled-components";
import { Button } from "react-bootstrap";

const Examples = styled.div`
  //스타일
  display: flex;
  align-items: center;
  justify-content: center;
  flex-wrap: wrap;
  //크기
  width: 80%;
  //위치
  position: absolute;
  bottom: 30%;
  left: 50%;
  transform: translateX(-50%);
`;

const Example = styled(Button)`
  //스타일
  background-color: #f2f2f2;
  margin: 0 5px;
  text-align: center;

  ${(props) =>
    props.$clicked &&
    css`
      display: none;
    `}
`;

function shuffle(array) {
  //Fisher-Yates shuffle
  for (let index = array.length - 1; index > 0; index--) {
    const randomPosition = Math.floor(Math.random() * (index + 1));

    const temporary = array[index];
    array[index] = array[randomPosition];
    array[randomPosition] = temporary;
  }
  return array;
}

const GrammarWriteExamplesContainer = ({ quiz, examples }) => {
  const writeAnswerIsClick = useSelector(
    (state) => state.grammarQuiz.writeAnswerIsClick
  );
  const dispatch = useDispatch();

  const shuffledExamples = useMemo(() => {
    return shuffle(examples);
  }, [examples]);

  const handleEampleClick = useCallback(
    (ex) => {
      dispatch(addWriteAnswer(ex));
    },
    [dispatch]
  );

  /**
   * GrammarWrtieAnswerContainer에서는 특정 ex를 클릭하면 아예 제거하고
   * 해당 ex는 Example에서 다시 나타나도록하기
   * stack.length === shuffledExamples.length면 정답과 비교하고 clickExample 디스패치하기
   */

  return (
    <Examples>
      {shuffledExamples.map((ex, idx) => (
        <Example
          key={idx}
          variant="light"
          onClick={() => handleEampleClick(ex)}
          $clicked={writeAnswerIsClick[ex]}
        >
          {ex}
        </Example>
      ))}
    </Examples>
  );
};

export default GrammarWriteExamplesContainer;
