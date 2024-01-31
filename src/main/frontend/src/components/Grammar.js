import GrammarExamplesContainer from "../containers/GrammarExamplesContainer";

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
          <div key={currentGrammar.id}>{currentGrammar.sentence}</div>
          {currentGrammar.grammarExamples.length ? (
            <GrammarExamplesContainer
              grammarExamples={currentGrammar.grammarExamples}
            />
          ) : (
            <div>보기가 없습니다.</div>
          )}
          {isSubmit && !isAnswer && <div>정답: {answer}</div>}
          <button onClick={onNextGrammar} disabled={!isExampleClicked}>
            {isSubmit ? "계속하기" : "확인"}
          </button>
        </>
      )}
    </>
  );
};

export default Grammar;
