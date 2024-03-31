import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getMyVocaBooks } from "../../modules/myVoca/myVocaBook";
import CircleSpinner from "../../components/CircleSpinner"
import styled from "styled-components";
import MyVocaBooks from "../../components/myVoca/MyVocaBooks";
import { Badge, Button } from "react-bootstrap";
const MyVocaBooksContainerBlock = styled.div`
  padding: 10% 5% 10%;
  overflow-y: scroll;
`
const Title = styled.h1`
  text-align: center;
  font-weight: bolder;
`


function MyVocaBooksContainer(){
  const loading = useSelector(
    (state) => state.myVocaBook.myVocaBooks.loading
  );
  const data = useSelector((state) => state.myVocaBook.myVocaBooks.data);
  const error = useSelector((state) => state.myVocaBook.myVocaBooks.error);
  const {user} = useSelector(state=>state.auth);
  const dispatch = useDispatch();

  useEffect(() => {
    if (data) return;
    dispatch(getMyVocaBooks( {userId : user.id}));
  }, [data, dispatch, user.id]);

  if (loading && !data) return <CircleSpinner />;
  if (error) return <div>{error.message}</div>;
  
  return (
    <MyVocaBooksContainerBlock>
      <br/>
      <Title>나만의 단어장</Title>
      <hr />
      <div className="d-grid gap-2">
        <Button variant="outline-primary">나만의 단어장 만들기</Button>{' '}
      </div>
      <MyVocaBooks myVocaBooks={data}/>
      <br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
    </MyVocaBooksContainerBlock>
  )
}


export default React.memo(MyVocaBooksContainer);