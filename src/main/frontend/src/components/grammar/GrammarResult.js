import { Link } from "react-router-dom";
import styled from "styled-components";
import { PieChart, Pie, Cell, Tooltip } from "recharts";

const ResultBox = styled.div`
  //스타일
  text-align: center;
  //위치
  position: absolute;
  top: 20%;
  left: 50%;
  transform: translateX(-50%);
`;

const COLORS = ["#0088FE", "#FF8042"];

const GrammarResult = ({ wrongGrammarsSize, grammarsSize }) => {
  const data = [
    { name: "맟춘 개수", value: grammarsSize - wrongGrammarsSize },
    { name: "틀린 개수", value: wrongGrammarsSize },
  ];

  return (
    <ResultBox>
      <PieChart width={512} height={400}>
        <Pie
          data={data}
          cx={256}
          cy={180}
          innerRadius={60}
          outerRadius={100}
          fill="#8884d8"
          paddingAngle={5}
          dataKey="value"
        >
          {data.map((entry, index) => (
            <Cell key={`cell-${index}`} fill={COLORS[index % COLORS.length]} />
          ))}
        </Pie>
        <Tooltip />
      </PieChart>
      <p>차트를 클릭해보세요!</p>
      <Link to={"/grammarbooks"}>다른 문법 익히기</Link>
    </ResultBox>
  );
};

export default GrammarResult;
