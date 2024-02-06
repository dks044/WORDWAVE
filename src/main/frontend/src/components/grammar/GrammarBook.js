import GrammarContainer from "../../containers/grammar/GrammarContainer";
import styled from "styled-components";
import { ProgressBar } from "react-bootstrap";

const ProgressBarCustom = styled(ProgressBar)`
  border-radius: 0;
  height: 10px;
`;

const Title = styled.h2`
  //스타일
  text-align: center;
  //위치
  position: absolute;
  top: 20%;
  left: 50%;
  transform: translateX(-50%);
`;

const GrammarBook = ({ grammarBook, progressRate }) => {
  const { name, grammars } = grammarBook;
  return (
    <>
      <ProgressBarCustom now={progressRate} />
      <Title>#{name}</Title>
      {grammars && <GrammarContainer grammars={grammars} />}
    </>
  );
};

export default GrammarBook;
