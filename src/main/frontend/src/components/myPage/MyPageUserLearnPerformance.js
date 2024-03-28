import React from "react";
import { Table } from "react-bootstrap";

function MyPageUserLearnPerformance({ data }) {
  if (!data) return <p>데이터가 없어요.</p>

  return (
    <>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>#</th>
            <th>카테고리</th>
            <th>정답 수</th>
            <th>오답 수</th>
            <th>마지막 시도</th>
          </tr>
        </thead>
        <tbody>
          {data.content.map((item, index) => (
            <tr key={index}>
              <td>{index + 1}</td>
              <td>{item.category}</td>
              <td>{item.answerCount}</td>
              <td>{item.wrongCount}</td>
              <td>{item.lastAttempted}</td>
            </tr>
          ))}
        </tbody>
      </Table>
    </>
  );
}

export default React.memo(MyPageUserLearnPerformance);
