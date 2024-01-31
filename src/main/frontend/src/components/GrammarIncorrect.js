const GrammarIncorrect = ({ incorrectGrammars }) => {
  const answer = (grammarExamples) =>
    grammarExamples.find((ge) => ge.isAnswer === true).example;

  return (
    <>
      {incorrectGrammars.map((incorrectGrammar) => (
        <div key={incorrectGrammar.id}>
          <div>{incorrectGrammar.sentence}</div>
          <div>{answer(incorrectGrammar.grammarExamples)}</div>
        </div>
      ))}
    </>
  );
};

export default GrammarIncorrect;
