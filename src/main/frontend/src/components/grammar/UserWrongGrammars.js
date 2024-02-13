import { BarChart, CartesianGrid, XAxis, YAxis, Tooltip, Bar } from "recharts";
import styled from "styled-components";

const BarBox = styled.div`
  position: absolute;
  right: 15%;
  top: 50%;
  transform: translateY(-50%);
`;

const TooltipBox = styled.div`
  background-color: rgba(245, 245, 245, 0.8);
  padding: 10px;
`;

const CustomTooltip = ({ active, payload }) => {
  if (active && payload && payload.length) {
    return (
      <TooltipBox className="custom-tooltip">
        <p className="content">{`전체 문제 수: ${payload[1].value}`}</p>
        <p className="content">{`틀린 문제 수: ${payload[0].value}`}</p>
      </TooltipBox>
    );
  }
  return null;
};

const UserWrongGrammars = ({ userGrammarBookData }) => {
  return (
    <BarBox>
      <BarChart
        width={500}
        height={500}
        data={userGrammarBookData}
        layout="vertical"
        margin={{
          top: 5,
          right: 30,
          left: 20,
          bottom: 5,
        }}
      >
        <CartesianGrid strokeDasharray="3 3" />
        <XAxis type="number" unit="개" />
        <YAxis type="category" width={250} dataKey="grammarBookName" />
        <Tooltip content={<CustomTooltip />} />
        <Bar dataKey="wrongNum" stackId="a" fill="#F07F87" />
        <Bar dataKey="grammarNum" unit="개" stackId="a" fill="#96DEF5" />
      </BarChart>
    </BarBox>
  );
};

export default UserWrongGrammars;
