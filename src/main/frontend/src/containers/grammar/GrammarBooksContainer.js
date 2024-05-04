import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import styled from "styled-components";
import { getGrammarBooks } from "../../modules/grammar/grammarBook";
import CircleSpinner from "../../components/CircleSpinner";
import GrammarBooks from "../../components/grammar/GrammarBooks";

const GrammarBooksContainerBlock = styled.div`
  padding: 10% 5% 10%;
  overflow-y: scroll;
`

function GrammarBooksContainer(){
  const loading = useSelector((state)=>state.grammarBook.grammarBooks?.loading);
  const data = useSelector((state) => state.grammarBook.grammarBooks?.data);
  const error = useSelector((state) => state.grammarBook.grammarBooks?.error);
  const dispatch = useDispatch();

  //폴링으로 변경
  useEffect(() => {
    const intervalId =  setInterval( async () => {
      await dispatch(getGrammarBooks());
    }, 30000); // 매 30초 마다 실행
  
    return () => clearInterval(intervalId); // 컴포넌트 언마운트 시 인터벌 제거
  }, [dispatch]);


  if (loading && !data) return <CircleSpinner />;
  if (error) return <div>{error.message}</div>;

  return(
    <GrammarBooksContainerBlock>
      <GrammarBooks grammarBooks={data}/>
      <br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
    </GrammarBooksContainerBlock>
  )
}

export default React.memo(GrammarBooksContainer);