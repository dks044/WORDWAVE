import GrammarExamplesContainer from "../containers/GrammarExamplesContainer";
import styled from "styled-components";

const Sentence = styled.p`
  font-size: 30px;
`;

const SentenceBox = styled.div`
  //스타일
  text-align: center;
  //크기
  width: 80%;
  //위치
  position: absolute;
  top: 40%;
  left: 50%;
  transform: translateX(-50%);
`;

const NextButton = styled.button`
  //스타일
  background: #63e6be;
  color: white;
  border: none;
  outline: none;
  border-radius: 50%;
  align-items: center;
  justify-content: center;
  opacity: 1;
  font-size: 130%;
  //크기
  width: 100px;
  height: 100px;
  //위치
  position: absolute;
  z-index: 6;
  bottom: -30px;
  left: 50%;
  transform: translateX(-50%);
  //애니메이션
  transition: opacity 0.2s ease-out;
  &:disabled {
    opacity: 0;
  }
`;

const Answer = styled.div`
  //위치
  position: absolute;
  top: 60%;
  left: 50%;
  transform: translateX(-50%);
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
          <SentenceBox key={currentGrammar.id}>
            <Sentence>{currentGrammar.sentence}</Sentence>
          </SentenceBox>

          {currentGrammar.grammarExamples.length ? (
            <GrammarExamplesContainer
              grammarExamples={currentGrammar.grammarExamples}
            />
          ) : (
            <div>보기가 없습니다.</div>
          )}
          {isSubmit && isAnswer && <Answer>정답입니다!</Answer>}
          {isSubmit && !isAnswer && (
            <Answer>틀렸어요..나중에 다시 풀어봐요!</Answer>
          )}
          <NextButton onClick={onNextGrammar} disabled={!isExampleClicked}>
            {isSubmit ? "계속하기" : "확인"}
          </NextButton>
        </>
      )}
    </>
  );
};

export default Grammar;
