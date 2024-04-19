import React from "react";
import styled from "styled-components";
import MyVocaForm from "../../components/myVoca/MyVocaForm";
import { useSelector } from "react-redux";

const MyVocaFormBlock = styled.div`
  margin-left: 5%;
  margin-right: 5%;
  overflow-y: scroll;
`

function MyVocaFormContainer({myVocaBookId}){
  const {user} = useSelector(state=>state.auth);



  return(
    <MyVocaFormBlock>
      <MyVocaForm />
    </MyVocaFormBlock>
  )
}

export default MyVocaFormContainer;