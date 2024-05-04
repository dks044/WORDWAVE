import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getVocaBooks } from "../../modules/voca/vocaBook";
import CircleSpinner from "../../components/CircleSpinner"
import VocaBooks from "../../components/voca/VocaBooks";
import styled from "styled-components";
const VocaBooksContainerBlock = styled.div`
  padding: 10% 5% 10%;
  overflow-y: scroll;
`

function VocaBooksContainer(){
  const loading = useSelector(
    (state) => state.vocaBook.vocaBooks?.loading
  );
  const data = useSelector((state) => state.vocaBook.vocaBooks?.data);
  const error = useSelector((state) => state.vocaBook.vocaBooks?.error);
  const dispatch = useDispatch();

  //폴링으로 변경
  useEffect(() => {
    const intervalId =  setInterval( async () => {
      await dispatch(getVocaBooks());
    }, 30000); // 매 30초 마다 실행
  
    return () => clearInterval(intervalId); // 컴포넌트 언마운트 시 인터벌 제거
  }, [dispatch]);




  if (loading && !data) return <CircleSpinner />;
  if (error) return <div>{error.message}</div>;
  
  return (
    <VocaBooksContainerBlock>
      <VocaBooks vocaBooks={data}/>
      <br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
    </VocaBooksContainerBlock>
  )
}


export default React.memo(VocaBooksContainer);