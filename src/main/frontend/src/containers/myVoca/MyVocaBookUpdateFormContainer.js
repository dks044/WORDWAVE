import React, { useEffect } from "react";
import MyVocaBookUpdateForm from "../../components/myVoca/MyVocaBookUpdateForm";
import { useDispatch, useSelector } from "react-redux";
import { getMyVocaBookOne } from "../../modules/myVoca/myVocaBook";
import CircleSpinner from "../../components/CircleSpinner";
import styled from "styled-components";

const MyVocaBookUpdateFormBlock = styled.div`
  margin-left: 5%;
  margin-right: 5%;
  overflow-y: scroll;
`

function MyVocaBookUpdateFormContainer({myVocaBookId}){
  const data = useSelector((state) => state.myVocaBook.myVocaBookOne.data);
  const loading = useSelector((state) => state.myVocaBook.myVocaBookOne.loading);
  const error = useSelector((state) => state.myVocaBook.myVocaBookOne.error);
  const {user} = useSelector(state=>state.auth);
  const dispatch = useDispatch();

  useEffect(()=>{
    dispatch(getMyVocaBookOne({myVocaBookId, userId: user.id}));
  },[dispatch,myVocaBookId,user])


   if (loading && !data) return <CircleSpinner />;
   if (error) return (
    <MyVocaBookUpdateFormBlock>
      <p>잘못된 경로로 접근했습니다!</p>
    </MyVocaBookUpdateFormBlock>
   )
   return(
    <MyVocaBookUpdateFormBlock>
      <MyVocaBookUpdateForm myVocaBook={data}/>
    </MyVocaBookUpdateFormBlock>
  )
}

export default MyVocaBookUpdateFormContainer;