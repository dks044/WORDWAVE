const GrammarExamples = ({ grammarExamples }) => {
  return (
    <>
      {grammarExamples.map((ge, index) => (
        <button key={index}>{ge.example}</button>
      ))}
    </>
  );
};

export default GrammarExamples;
