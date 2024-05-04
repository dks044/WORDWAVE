import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import CircleSpinner from "../../components/CircleSpinner";
import styled from "styled-components";
import { getValidateMyVocaBook } from "../../modules/myVoca/myVocaBook";
import MyVocaUpdateForm from "../../components/myVoca/MyVocaUpdateForm";
import { getUpdateFormMyVoca } from "../../modules/myVoca/myVoca";

const MyVocaUpdateFormBlock = styled.div`
  margin-left: 2%;
  margin-right: 2%;
  overflow-y: scroll;
  overflow-x: hidden;
`

function MyVocaUpdateFormContainer({myVocaBookId, category}){
  const data = useSelector((state) => state.myVoca.updateFormMyVoca?.data);
  const loading = useSelector((state) => state.myVoca.updateFormMyVoca?.loading);
  const error = useSelector((state) => state.myVoca.updateFormMyVoca?.error);
  const {user} = useSelector(state=>state.auth);
  const dispatch = useDispatch();
  const validateMyVocaBookError = useSelector((state)=>state.myVocaBook.validateMyVocaBook.error);

  useEffect(()=>{
    dispatch(getUpdateFormMyVoca({myVocaBookId,category}));
    dispatch(getValidateMyVocaBook({myVocaBookId,userId:user.id}));
  },[dispatch,myVocaBookId,category,user]);


  
  if (loading && !data) return <CircleSpinner />;
  if (error || validateMyVocaBookError) return <div>잘못된 경로로 접근했습니다.</div>;

  return(
    <MyVocaUpdateFormBlock>
      <MyVocaUpdateForm myVoca={data} userId={user.id}/>
    </MyVocaUpdateFormBlock>
  )
}

export default React.memo(MyVocaUpdateFormContainer);