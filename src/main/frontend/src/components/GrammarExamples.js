const GrammarExamples = ({ grammarExamples, onClickExample, isSubmit }) => {
  return (
    <>
      {grammarExamples.map((ge, index) => (
        <button
          key={index}
          onClick={() => onClickExample(ge.isAnswer)}
          disabled={isSubmit}
        >
          {ge.example}
        </button>
      ))}
    </>
  );
};

export default GrammarExamples;
