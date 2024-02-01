import React, { useState } from "react";
import { Button, FloatingLabel, Form, Modal } from "react-bootstrap";
import { useSelector } from "react-redux";
import styled from "styled-components";

const Title = styled.h1`
  text-align: center;
  font-weight: bolder;
  `

export default function MyPageComponent(){
  const {user} = useSelector(state=>state.auth);
  const [showEmail,setShowEmail] = useState(false);
  const [showPhoneNumber,setShowPhoneNumber] = useState(false);


  function onMouseOverForEmail (){ return setShowEmail(true);}
  function onMouseOutForEmail(){ return setShowEmail(false);}
  function onMouseOverForPhoneNumber() {return setShowPhoneNumber(true);}
  function onMouseOutForPhoneNumber() {return setShowPhoneNumber(false);}
  //modal
  const [show, setShow] = useState(false);
  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);
  const [modalTitle,setModalTitle] = useState('');
  const onclickChangePwButton = () => {
    handleShow();
    setModalTitle('비밀번호 변경');
  }

  return(
    <>
      <Title>VOCA</Title>
      <hr/>
      <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dignissimos enim quod sequi nobis, praesentium, doloribus dolore ullam eum quis repellat repellendus aliquam voluptatibus deserunt harum ex. Qui adipisci consectetur nostrum?</p>
      <br />
      <Title>Grammer</Title>
      <hr/>
      <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dignissimos enim quod sequi nobis, praesentium, doloribus dolore ullam eum quis repellat repellendus aliquam voluptatibus deserunt harum ex. Qui adipisci consectetur nostrum?</p>
      <br/><br/><br/>
      <Title>내 프로필</Title>
      <p>마우스를 올리면 유저정보가 보입니다.</p>
      <hr/>
      <div className="d-grid gap-2">
        <h1>ID : {user.userName}</h1>
        <h3 onMouseOver={onMouseOverForEmail} onMouseOut={onMouseOutForEmail} >Email : {showEmail && user.email}</h3>
        <h4 onMouseOver={onMouseOverForPhoneNumber} onMouseOut={onMouseOutForPhoneNumber}>number : {showPhoneNumber && user.phoneNumber}</h4>
        <Button onClick={onclickChangePwButton} variant="info">비밀번호 변경</Button>
        <Button variant="danger">회원 탈퇴</Button>
      </div>
      <Modal
        show={show}
        onHide={handleClose}
        backdrop="static"
        keyboard={false}
      >
        <Modal.Header closeButton>
          <Modal.Title>{modalTitle}</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <p>원래 비밀번호, 바꿀 비밀번호를 입력하세요.</p>
          <FloatingLabel controlId="floatingPassword" label="원래 비밀번호">
            <Form.Control type="password" placeholder="원래 비밀번호" />
          </FloatingLabel>
          <FloatingLabel controlId="floatingPassword" label="바꿀 비밀번호">
            <Form.Control type="password" placeholder="바꿀 비밀번호" />
          </FloatingLabel>
          <FloatingLabel controlId="floatingPassword" label="바꿀 비밀번호 확인">
            <Form.Control type="password" placeholder="바꿀 비밀번호 확인" />
          </FloatingLabel>
          <div className="d-grid gap-2">
            <Button variant="info">비밀번호 변경</Button>
          </div>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
          <Button variant="primary">Understood</Button>
        </Modal.Footer>
      </Modal>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>

    </>
  )
}