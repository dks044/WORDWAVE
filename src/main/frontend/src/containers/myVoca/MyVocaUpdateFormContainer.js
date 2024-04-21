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
  const data = useSelector((state) => state.myVoca.updateFormMyVoca.data);
  const loading = useSelector((state) => state.myVoca.updateFormMyVoca.loading);
  const error = useSelector((state) => state.myVoca.updateFormMyVoca.error);
  const {user} = useSelector(state=>state.auth);
  const dispatch = useDispatch();

  useEffect(()=>{
    dispatch(getUpdateFormMyVoca({myVocaBookId,category}));
    console.log(data);
  },[dispatch,myVocaBookId,category]);


  
  if (loading && !data) return <CircleSpinner />;
  if (error) return <div>{error.message}</div>;

  return(
    <MyVocaUpdateFormBlock>
      <MyVocaUpdateForm myVoca={data} userId={user.id}/>
    </MyVocaUpdateFormBlock>
  )
}

export default React.memo(MyVocaUpdateFormContainer);