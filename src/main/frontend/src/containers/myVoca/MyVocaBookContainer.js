import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import styled from "styled-components";
import {getMyVocaBook} from "../../modules/myVoca/myVocaBook"
import CircleSpinner from "../../components/CircleSpinner";
import MyVocaBook from "../../components/myVoca/MyVocaBook";

const MyVocaBookContainerBlock = styled.div`
  padding: 10% 15% 10%;
  overflow-y: scroll;
`

function MyVocaBookContainer( {myVocaBookId} ){
  console.log(myVocaBookId);
  const loading = useSelector((state) => state.myVocaBook.myVocaBook.loading);
  const data = useSelector((state) => state.myVocaBook.myVocaBook.data);
  const error = useSelector((state) => state.myVocaBook.myVocaBook.error);
  const dispatch = useDispatch();

  useEffect(()=>{
    dispatch(getMyVocaBook({myVocaBookId}));

  },[dispatch,myVocaBookId])

  if (loading && !data) return <CircleSpinner />;

  if (error) return <div>{error.message}</div>;
  return (
    <MyVocaBookContainerBlock>
      <MyVocaBook myVocaBook={data} />
      <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
    </MyVocaBookContainerBlock>
  )
}


export default MyVocaBookContainer;