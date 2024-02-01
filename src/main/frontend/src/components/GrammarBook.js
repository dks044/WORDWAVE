import GrammarContainer from "../containers/GrammarContainer";
import styled from "styled-components";

const Title = styled.h2`
  text-align: center;
`;

const GrammarBook = ({ grammarBook }) => {
  const { name, grammars } = grammarBook;
  return (
    <>
      <Title>{name}</Title>
      {grammars && <GrammarContainer grammars={grammars} />}
    </>
  );
};

export default GrammarBook;
