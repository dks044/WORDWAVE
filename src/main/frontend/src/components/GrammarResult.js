import { Link } from "react-router-dom";

const GrammarResult = ({ correctRate }) => {
  return (
    <>
      <div>{correctRate}%</div>
      <Link to={"/grammarbooks"}>문법 페이지로 돌아가기</Link>
    </>
  );
};

export default GrammarResult;
