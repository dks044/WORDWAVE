import { Link } from "react-router-dom";
import styled from "styled-components";

const ResultBox = styled.div`
  //위치
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translateX(-50%);
`;

const GrammarResult = ({ correctRate }) => {
  return (
    <ResultBox>
      <div>{correctRate}%</div>
      <Link to={"/grammarbooks"}>다른 문법 익히기</Link>
    </ResultBox>
  );
};

export default GrammarResult;
