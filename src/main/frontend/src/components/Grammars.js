import GrammarExamples from "./GrammarExamples";

const Grammars = ({ currentGrammar, onNextGrammar, disableNext }) => {
  return (
    <>
      <div key={currentGrammar.id}>{currentGrammar.sentence}</div>
      <GrammarExamples grammarExamples={currentGrammar.grammarExamples} />
      <hr />
      <button onClick={onNextGrammar} disabled={disableNext}>
        Next
      </button>
    </>
  );
};

export default Grammars;
