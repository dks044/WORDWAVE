import GrammarExamplesContainer from "../containers/GrammarExamplesContainer";
import styled from "styled-components";

const Sentence = styled.div`
  padding-left: 10px;
`;

const NextButton = styled.button`
  //스타일
  background: skyblue;
  color: white;
  border: none;
  outline: none;
  border-radius: 50%;
  align-items: center;
  justify-content: center;
  opacity: 1;
  font-size: 100%;
  //크기
  width: 100px;
  height: 100px;
  //위치
  position: relative;
  z-index: 6;
  bottom: -57.017%;
  left: 50%;
  transform: translateX(-50%);
  //애니메이션
  &:disabled {
    background: #0f78ff;
    opacity: 0;
  }
`;

const Grammar = ({
  currentGrammar,
  onNextGrammar,
  isExampleClicked,
  isAnswer,
  isSubmit,
  answer,
}) => {
  return (
    <>
      {currentGrammar && (
        <>
          <Sentence key={currentGrammar.id}>
            <p>{currentGrammar.sentence}</p>
          </Sentence>

          {currentGrammar.grammarExamples.length ? (
            <GrammarExamplesContainer
              grammarExamples={currentGrammar.grammarExamples}
            />
          ) : (
            <div>보기가 없습니다.</div>
          )}
          {isSubmit && !isAnswer && <div>정답: {answer}</div>}
          <NextButton onClick={onNextGrammar} disabled={!isExampleClicked}>
            {isSubmit ? "계속하기" : "확인"}
          </NextButton>
        </>
      )}
    </>
  );
};

export default Grammar;
