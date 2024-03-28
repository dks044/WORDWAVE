import React from "react";
import { useState } from "react";
import { Table } from "react-bootstrap";

function MyPageUserLearnPerformance({ data }) {
  const [currentPage, setCurrentPage] = useState(1);
  const itemsPerPage = 10; // 한 페이지에 보여줄 항목 수

  
  if(!data) return <p>데이터가 없어요.</p>

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

        </tbody>
      </Table>
    </>
  );
}

export default React.memo(MyPageUserLearnPerformance);