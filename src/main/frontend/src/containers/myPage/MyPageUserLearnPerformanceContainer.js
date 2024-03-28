import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getAllUserLearnPerformance } from "../../modules/userLearnPerformance/userLearnPerformance";

import CircleSpinner from "../../components/CircleSpinner";
import MyPageUserLearnPerformance from "../../components/myPage/MyPageUserLearnPerformance";


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

    // 페이지네이션 버튼을 위한 로직
  const totalPages = data ? data.totalPages : 0;
  const pages = Array.from({ length: totalPages }, (_, index) => index);

  return(
   <>
    <MyPageUserLearnPerformance data={data} />
    <div>
        {/* 페이지네이션 버튼 */}
        {pages.map(page => (
          <button key={page} onClick={() => setPageNum(page)}>
            {page + 1}
          </button>
        ))}
      </div>
   </>
  )
}

export default React.memo(MyPageUserLearnPerformanceContainer);