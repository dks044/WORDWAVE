import React from 'react';
import { PieChart, Pie, Sector, Cell, ResponsiveContainer } from 'recharts';
import styled from 'styled-components';


// const AnimatedContainer = styled.div`
//   transition: 0.25s all ease-in-out;
// `

const COLORS = ['#1692f0','#ca6c98'];

const RADIAN = Math.PI / 180;
const renderCustomizedLabel = ({ cx, cy, midAngle, innerRadius, outerRadius, percent, index, name }) => {
  const radius = innerRadius + (outerRadius - innerRadius) * 0.5;
  const x = cx + radius * Math.cos(-midAngle * RADIAN);
  const y = cy + radius * Math.sin(-midAngle * RADIAN);

  return (
    <text x={x} y={y} fill="black" textAnchor={x > cx ? 'start' : 'end'} dominantBaseline="central" fontWeight="bold">
      {`${name}: ${(percent * 100).toFixed(0)}%`}
    </text>
  );
};

const SimplePieChart = ({data}) => {
  return (
    // <AnimatedContainer>
      <ResponsiveContainer width="100%" height={230}>
        <PieChart width={780} height={780}>
          <Pie
            data={data}
            cx="50%"
            cy="50%"
            labelLine={false}
            label={renderCustomizedLabel}
            outerRadius={80}
            fill="#8884d8"
            dataKey="value"
            nameKey="name" // name 키를 사용하게 설정
          >
            {data.map((entry, index) => (
              <Cell key={`cell-${index}`} fill={COLORS[index % COLORS.length]} />
            ))}
          </Pie>
        </PieChart>
      </ResponsiveContainer>
    // </AnimatedContainer>
  );
};

export default SimplePieChart;
