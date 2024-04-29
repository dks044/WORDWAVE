import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getAllUserLearnPerformance } from "../../modules/userLearnPerformance/userLearnPerformance";

import CircleSpinner from "../../components/CircleSpinner";
import MyPageUserLearnPerformance from "../../components/myPage/MyPageUserLearnPerformance";
import { Pagination } from "react-bootstrap";


function MyPageUserLearnPerformanceContainer({userId}){
  const [pageNum, setPageNum] = useState(0);
  const loading = useSelector((state)=>state.userLearnPerformance.allUserLearnPerformance.loading);
  const data = useSelector((state)=>state.userLearnPerformance.allUserLearnPerformance.data);
  const error = useSelector((state)=>state.userLearnPerformance.allUserLearnPerformance.error);
  const dispatch = useDispatch();

  useEffect(()=>{
    dispatch(getAllUserLearnPerformance({userId, pageNum}));
  }, [userId, pageNum, dispatch]); 

  if (loading && !data) return <CircleSpinner />;
  if (error) return <div>{error.message}</div>;

  // 페이지네이션 로직
  const totalPages = data ? data.totalPages : 0;
  const maxPageNumberLimit = 5; // 한 번에 보여줄 최대 페이지 번호 개수
  const paginationRange = 2; // 현재 페이지 양옆으로 보여줄 페이지 번호 개수

  let pages = [];
  let startPage = Math.max(pageNum - paginationRange, 0);
  let endPage = Math.min(startPage + maxPageNumberLimit - 1, totalPages - 1);

  if (totalPages > maxPageNumberLimit && pageNum + paginationRange >= totalPages) {
    startPage = totalPages - maxPageNumberLimit;
    endPage = totalPages - 1;
  }

  for (let i = startPage; i <= endPage; i++) {
    pages.push(i);
  }

  return (
    <>
      <MyPageUserLearnPerformance data={data} />
      <div>
        <Pagination>
          {pageNum > 0 && <Pagination.Prev onClick={() => setPageNum(pageNum - 1)} />}
          
          {startPage > 0 && (
            <>
              <Pagination.Item onClick={() => setPageNum(0)}>1</Pagination.Item>
              {startPage > 1 && <Pagination.Ellipsis />}
            </>
          )}

          {pages.map(page => (
            <Pagination.Item key={page} active={page === pageNum} onClick={() => setPageNum(page)}>
              {page + 1}
            </Pagination.Item>
          ))}

          {endPage < totalPages - 1 && (
            <>
              {endPage < totalPages - 2 && <Pagination.Ellipsis />}
              <Pagination.Item onClick={() => setPageNum(totalPages - 1)}>{totalPages}</Pagination.Item>
            </>
          )}
          
          {pageNum < totalPages - 1 && <Pagination.Next onClick={() => setPageNum(pageNum + 1)} />}
        </Pagination>
      </div>
    </>
  );
}

export default React.memo(MyPageUserLearnPerformanceContainer);
