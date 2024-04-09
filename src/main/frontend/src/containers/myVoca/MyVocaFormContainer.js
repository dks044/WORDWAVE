import React from "react";
import styled from "styled-components";
import MyVocaForm from "../../components/myVoca/MyVocaForm";

const MyVocaFormBlock = styled.div`
  width: 80%;
  position: absolute;
  top: 15%;
  left: 50%;
  transform: translateX(-50%);
`

function MyVocaFormContainer(){
  return(
    <MyVocaFormBlock>
      <MyVocaForm />
    </MyVocaFormBlock>
  )
}