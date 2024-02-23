import styled from "styled-components";
import GrammarWriteExamplesContainer from "../../containers/grammar/GrammarWriteExamplesContainer";
import GrammarWriteAnswerContainer from "../../containers/grammar/GrammarWriteAnswerContainer";

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

const Sentence = styled.p`
  font-size: 20px;
`;

const SentenceBox = styled.div`
  //스타일
  text-align: center;
  //크기
  width: 80%;
  //위치
  position: relative;
  top: 20%;
  left: 50%;
  transform: translateX(-50%);
`;

function splitKoreanOrSentence(currentGrammarIndex, sentence, korean) {
  if (currentGrammarIndex % 2 === 0) {
    return { quiz: sentence, examples: korean.split(" ") };
  }
  return { quiz: korean, examples: sentence.split(" ") };
}

const GrammarWrite = ({
  currentGrammar,
  onNextGrammar,
  isExampleClicked,
  isAnswer,
  isSubmit,
  currentGrammarIndex,
}) => {
  const { id, korean, sentence } = currentGrammar;

  const { quiz, examples } = splitKoreanOrSentence(
    currentGrammarIndex,
    sentence,
    korean
  );

  return (
    <>
      <SentenceBox key={id}>
        <Sentence>{quiz}</Sentence>
        <GrammarWriteAnswerContainer examples={examples} />
      </SentenceBox>

      {examples && (
        <GrammarWriteExamplesContainer quiz={quiz} examples={examples} />
      )}

      {isSubmit && isAnswer && <Answer>정답입니다!</Answer>}
      {isSubmit && !isAnswer && (
        <Answer>틀렸어요..나중에 다시 풀어봐요!</Answer>
      )}
      <NextButton onClick={onNextGrammar} disabled={!isExampleClicked}>
        {isSubmit ? "계속하기" : "확인"}
      </NextButton>
    </>
  );
};

export default GrammarWrite;
