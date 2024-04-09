import React from "react";
import { Button, Card, Container } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import CloseButton from 'react-bootstrap/CloseButton';
import styled, { css } from "styled-components";
import { FaPencilAlt } from "react-icons/fa";
import { useDispatch, useSelector } from "react-redux";

const CloseButtonContainer = styled.div`
  position: absolute;
  left: 91%;
`
const UpdateButtonContainer = styled.div`
  position: absolute;
  left: 85%;
  cursor: pointer;
`

function MyVocaBooks({myVocaBooks})  {
  const navigate = useNavigate();
  const {user} = useSelector(state=>state.auth);
  const onClickToDelete = (myVocaBookId) =>{
    
  }

  const onClickToUpdate = (myVocaBookId) =>{
    console.log('이동!');
    navigate(`/myvocabooks/update/${myVocaBookId}`);
  }

  return (
    <>
      {myVocaBooks && myVocaBooks.map((myVocaBook) => (
      <Container key={myVocaBook.id} className="d-flex justify-content-center mt-3">
        <Card key={myVocaBook.id} style={{ width: '18rem' }} border="info" className="text-center">
        <CloseButtonContainer>
          <CloseButton />
        </CloseButtonContainer>
        <UpdateButtonContainer>
          <FaPencilAlt onClick={() => onClickToUpdate(myVocaBook.id)}/>
        </UpdateButtonContainer>
          {myVocaBook.imageURL && (
            <Card.Img variant="top" src={myVocaBook.imageURL} />
          )}
          {!myVocaBook.imageURL && (
            <Card.Img variant="top" src={"https://cdn.pixabay.com/photo/2015/11/07/09/18/sunrise-1030600_1280.jpg"} />
          )}
          <Card.Body>
            <Card.Title className="fw-bold">{myVocaBook.name}</Card.Title>
            <Container className="d-flex justify-content-center mt-3">
            <Button onClick={() => navigate(`/myvocabooks/${myVocaBook.id}`)} variant="success">✏️공부하기!✏️</Button>
            </Container>
          </Card.Body>
        </Card>
        <br />
      </Container>
      ))}
  
    </>
  )
}

export default React.memo(MyVocaBooks);

