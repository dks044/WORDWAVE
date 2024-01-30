import GrammarsContainer from "../containers/GrammarsContainer";

const GrammarBook = ({ grammarBook }) => {
  const { name, grammars, ...rest } = grammarBook;
  return (
    <>
      <h2>{name}</h2>
      {grammars && <GrammarsContainer grammars={grammars} />}
    </>
  );
};

export default GrammarBook;
