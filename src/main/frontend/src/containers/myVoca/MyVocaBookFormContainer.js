import React from "react";
import MyVocaBookForm from "../../components/myVoca/MyVocaBookForm";
import styled from "styled-components";

const MyVocaBookFormBlock = styled.div`
  width: 80%;
  position: absolute;
  top: 15%;
  left: 50%;
  transform: translateX(-50%);
`

function MyVocaBookFormContainer(){
  return (
    <MyVocaBookFormBlock>
      <MyVocaBookForm />
    </MyVocaBookFormBlock>
  )
}

export default React.memo(MyVocaBookFormContainer);