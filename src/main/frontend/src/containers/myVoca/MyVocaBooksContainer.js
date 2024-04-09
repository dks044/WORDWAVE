import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getMyVocaBooks } from "../../modules/myVoca/myVocaBook";
import CircleSpinner from "../../components/CircleSpinner"
import styled from "styled-components";
import MyVocaBooks from "../../components/myVoca/MyVocaBooks";
import { Badge, Button, Spinner } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
const MyVocaBooksContainerBlock = styled.div`
  padding: 10% 5% 10%;
  overflow-y: scroll;
`
const Title = styled.h1`
  text-align: center;
  font-weight: bolder;
`


function MyVocaBooksContainer(){
  const [isImport,setIsImport] = useState(false);
  const loading = useSelector(
    (state) => state.myVocaBook.myVocaBooks.loading
  );
  const data = useSelector((state) => state.myVocaBook.myVocaBooks.data);
  const error = useSelector((state) => state.myVocaBook.myVocaBooks.error);
  const {user} = useSelector(state=>state.auth);
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const onNavigate = () =>{
    navigate('/myvocabooks/create');
  }

  
  useEffect(() => {
    dispatch(getMyVocaBooks({ userId: user.id }));
  },[]);


  useEffect(() => {
    if(data) return;
    dispatch(getMyVocaBooks({ userId: user.id }));
  }, [dispatch,data,user.id]); // 의존성 배열에서는 user.id만을 추적

  if (loading && !data) return <CircleSpinner />;
  if (error) return <div>{error.message}</div>;
  
  const onImport = () =>{
    dispatch(getMyVocaBooks({ userId: user.id }));
  }

  return (
    <MyVocaBooksContainerBlock>
      <br/>
      <Title>
        나만의 단어장
        <span><Button variant="info" onClick={onImport}>불러오기</Button></span>
      </Title>
      <hr />
      <div className="d-grid gap-2">
        <Button variant="outline-primary" onClick={onNavigate}>나만의 단어장 만들기</Button>
      </div>
      <MyVocaBooks myVocaBooks={data}/>
      <br /><br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
    </MyVocaBooksContainerBlock>
  )
}


export default React.memo(MyVocaBooksContainer);