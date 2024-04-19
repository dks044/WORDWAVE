import React, { useEffect, useState } from "react";
import styled from "styled-components";
import MyVocaForm from "../../components/myVoca/MyVocaForm";
import { useDispatch, useSelector } from "react-redux";
import { getValidateMyVocaBook } from "../../modules/myVoca/myVocaBook";

const MyVocaFormBlock = styled.div`
  margin-left: 2%;
  margin-right: 2%;
  overflow-y: scroll;
  overflow-x: hidden;
`

function MyVocaFormContainer({myVocaBookId}){
  const {user} = useSelector(state=>state.auth);
  const dispatch = useDispatch();
  const validateMyVocaBookError = useSelector((state)=>state.myVocaBook.validateMyVocaBook.error);
  //현재 단어장페이지가 해당 사용자의 단어장인지 검증
 useEffect(()=>{
  dispatch(getValidateMyVocaBook({myVocaBookId,userId:user.id}));
 },[])

 if(validateMyVocaBookError) return (
 <MyVocaFormBlock>
  <br />
  <h3>현재 사용자의 단어장이 아닙니다!</h3>
 </MyVocaFormBlock>
  )

  return(
    <MyVocaFormBlock>
      <MyVocaForm />
    </MyVocaFormBlock>
  )
}

export default MyVocaFormContainer;