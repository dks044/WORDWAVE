import React, { useState } from "react";
import { Button, Card, Container, Modal } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import styled, { css } from "styled-components";
import { FaPencilAlt } from "react-icons/fa";
import { useDispatch, useSelector } from "react-redux";
import {deleteMyVocaBookAPI} from "../../api/myVocaAPI";
import { FaTrashAlt } from "react-icons/fa";

const CloseButtonContainer = styled.div`
  position: absolute;
  left: 91%;
  color:skyblue;
  transition: 0.35s all ease-in-out;
  cursor: pointer;
  &:hover {
    color: mintcream;
  }
`
const UpdateButtonContainer = styled.div`
  position: absolute;
  left: 85%;
  color:skyblue;
  cursor: pointer;
  transition: 0.35s all ease-in-out;
  &:hover {
    color: mintcream;
  }

`

function MyVocaBooks({myVocaBooks})  {
  const navigate = useNavigate();
  const {user} = useSelector(state=>state.auth);
  const [myVocaBookId,setMyVocaBookId] = useState(null);

  //modal
  const [show, setShow] = useState(false);
  const handleClose = () => {
    setShow(false);
    setMyVocaBookId(null);
  }
  const handleShow = () => setShow(true);
  const [modalText, setModalText] = useState('');

  const onClickToDeleteModal = (myVocaBookId,name) =>{
    handleShow();
    setModalText(name);
    setMyVocaBookId(myVocaBookId);
  }
  const onClickToDelete = () =>{
    deleteMyVocaBookAPI({myVocaBookId});
    window.location.href = '/myvocabooks';
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
          <FaTrashAlt onClick={()=>onClickToDeleteModal(myVocaBook.id,myVocaBook.name)}/>
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
      <Modal
        show={show}
        onHide={handleClose}
        backdrop="static"
        keyboard={false}
      >
        <Modal.Header closeButton>
          <Modal.Title>삭제</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          '{modalText}'을 삭제하시겠습니까?
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            닫기
          </Button>
          <Button variant="danger" onClick={()=>onClickToDelete()}>삭제하기</Button>
        </Modal.Footer>
      </Modal>
    </>

  )
}

export default React.memo(MyVocaBooks);

