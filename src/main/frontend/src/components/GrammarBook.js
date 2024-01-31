import GrammarContainer from "../containers/GrammarContainer";

const GrammarBook = ({ grammarBook }) => {
  const { name, grammars } = grammarBook;
  return (
    <>
      <h2>{name}</h2>
      {grammars && <GrammarContainer grammars={grammars} />}
    </>
  );
};

export default GrammarBook;
