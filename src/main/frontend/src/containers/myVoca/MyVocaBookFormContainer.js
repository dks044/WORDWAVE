import React from "react";
import MyVocaBookForm from "../../components/myVoca/MyVocaBookForm";
import styled from "styled-components";

const MyVocaBookFormBlock = styled.div`
  margin-left: 5%;
  margin-right: 5%;
  overflow-y: scroll;
`

function MyVocaBookFormContainer(){
  return (
    <MyVocaBookFormBlock>
      <MyVocaBookForm />
    </MyVocaBookFormBlock>
  )
}

export default React.memo(MyVocaBookFormContainer);