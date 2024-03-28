import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getAllUserLearnPerformance } from "../../modules/userLearnPerformance/userLearnPerformance";
import MyPageUserLearnPerformance from "../../components/myPage/MyPageUserLearnPerformance";
import CircleSpinner from "../../components/CircleSpinner";


function MyPageUserLearnPerformanceContainer({userId,pageNum}){
  const loading = useSelector((state)=>state.userLearnPerformance.allUserLearnPerformance.loading);
  const data = useSelector((state)=>state.userLearnPerformance.allUserLearnPerformance.data);
  const error = useSelector((state)=>state.userLearnPerformance.allUserLearnPerformance.error);
  const dispatch = useDispatch();

  useEffect(()=>{
    dispatch(getAllUserLearnPerformance({userId, pageNum}));
  }, [userId, pageNum, dispatch]); 

  if (loading && !data) return <CircleSpinner />;
  if (error) return <div>{error.message}</div>;

  return(
   <>
    <MyPageUserLearnPerformance data={data} />
   </>
  )
}

export default React.memo(MyPageUserLearnPerformanceContainer);