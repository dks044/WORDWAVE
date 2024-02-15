import GrammarContainer from "../../containers/grammar/GrammarContainer";
import GrammarResultContainer from "../../containers/grammar/GrammarResultContainer";
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
  const { name, grammarIds } = grammarBook;
  return (
    <>
      <ProgressBarCustom now={progressRate} />
      <Title>#{name}</Title>
      {grammarIds && 0 <= progressRate && progressRate < 100 && (
        <GrammarContainer grammarIds={grammarIds} />
      )}
      {progressRate === 100 && (
        <GrammarResultContainer
          grammarIds={grammarIds}
          grammarBookName={name}
        />
      )}
    </>
  );
};

export default GrammarBook;
