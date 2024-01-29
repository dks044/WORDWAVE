import React, { useState } from "react";
import { Button, Col, Form, Row, FloatingLabel, Container, Modal } from "react-bootstrap";
import styled from "styled-components";

const SignUpFormBlock = styled.div`
  width: 80%;
  position: absolute;
  top: 25%;
  left: 50%;
  transform: translateX(-50%);
`
const SignUpTitle = styled.h1`
  text-align: center;
`
const ModalTitle = styled.h2`
  font-weight: bolder;
`

function SignUpForm() {
  //modal
  const [show, setShow] = useState(false);
  const handleClose = () => {
    setShow(false);
    setErrorMessage('');
  };
  const handleShow = () => setShow(true);
  const [errorMessage,setErrorMessage] = useState('');

  //비밀번호 유효성검사
  function isPasswordValid(password) {
    if(password.length < 14 || password.length > 21) {
      return false;
    }
  
    let alphabetCount = 0;
    let differentCount = 0;
  
    for(let i = 0; i < password.length; i++){
      const word = password[i];
      if(/[a-zA-Z]/.test(word)) alphabetCount++;
      if(!/[0-9a-zA-Z]/.test(word)) differentCount++;
    }
  
    return !(alphabetCount < 1 || differentCount < 1);
  }

  const handleSubmit = (event) => {
    event.preventDefault();
    const userName = event.target.elements.floatingInputUserName.value;
    const password = event.target.elements.floatingInputPassword.value;
    const email = event.target.elements.floatingInputEmail.value;
    const phoneNumber = event.target.elements.floatingInputPhone.value;

    if(!userName || !password || !email || !phoneNumber){
      handleShow();
      setErrorMessage('빈 입력칸이 있는지 확인해주세요.');
      return;
    }

    if(!isPasswordValid(password)){
      handleShow();
      setErrorMessage('비밀번호는 14자 이상, 21자 이하여야 하며, 대문자, 소문자, 특수문자가 각각 1자 이상 포함되어야 합니다.');
      return;
    }
    
  };

  return (
    <SignUpFormBlock>
      <Row className="justify-content-md-center">
        <Col xs={18} md={20}>
          <SignUpTitle>회원가입</SignUpTitle>
          <Form onSubmit={handleSubmit}>
            <FloatingLabel
              controlId="floatingInputUserName"
              label="아이디 입력"
              className="mb-3"
            >
              <Form.Control onInput={(e) => e.target.value = e.target.value.replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, '')} type="text" placeholder="아이디를 입력하세요" name="userName" />
            </FloatingLabel>

            <FloatingLabel
              controlId="floatingInputPassword"
              label="비밀번호 입력"
              className="mb-3"
            >
              <Form.Control type="password" placeholder="비밀번호를 입력하세요" name="password"/>
            </FloatingLabel>

            <FloatingLabel
              controlId="floatingInputEmail"
              label="이메일 입력"
              className="mb-3"
            >
              <Form.Control type="email" placeholder="이메일을 입력하세요" name="email" />
            </FloatingLabel>

            <FloatingLabel
              controlId="floatingInputPhone"
              label="전화번호 입력"
              className="mb-3"
            >
              <Form.Control type="text" placeholder="전화번호를 입력하세요" name="phoneNumber"/>
            </FloatingLabel>
            <Container className="d-flex justify-content-center mt-3">
              <Button variant="outline-primary" type="submit" size="lg">가입하기</Button>
            </Container>
          </Form>
        </Col>
      </Row>
      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title><ModalTitle>회원가입 오류</ModalTitle></Modal.Title>
        </Modal.Header>
        <Modal.Body>{errorMessage}</Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
        </Modal.Footer>
      </Modal>
    </SignUpFormBlock>
  )
}

export default SignUpForm;
