import React, { useState } from 'react';
import { Button, Col, Container, FloatingLabel, Form, Modal, Row } from 'react-bootstrap';
import { useDispatch} from 'react-redux';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import {login, userInfo} from '../modules/auth'

const LoginFormBlock = styled.div`
  width: 80%;
  position: absolute;
  top: 25%;
  left: 50%;
  transform: translateX(-50%);
`
const ValidMessage = styled.p`
  color: red;
`
const LoginTitle = styled.h1`
  text-align: center;
`
const FindIdText = styled.h5`
  display: inline; 
  color: red;
  cursor: pointer;
  transition: 0.225s all ease-in;
  &:hover {
    color: #63e6be;
  }
`
const FindPasswordText = styled.h5`
  display: inline; 
  color: red;
  cursor: pointer;
  transition: 0.225s all ease-in;
  &:hover {
    color: #63e6be;
  }
`

export default function LoginForm(){
  const dispatch = useDispatch();
  const [validLogin,setValidLogin] = useState(false);
  const navigate = useNavigate();
  //Modal(아이디찾기, 비밀번호찾기)
  const [show, setShow] = useState(false);
  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);
  const onClickFindTest = () => setShow(true);

  const handleSubmit = async (event) => {
    event.preventDefault();
    const userName = event.target.elements.floatingInputId.value;
    const password = event.target.elements.floatingInputPassword.value;
    try {
      await dispatch(login(userName,password));
      navigate(-1); 
    } catch (error) {
      console.error('로그인 실패:', error);
      setValidLogin(true);
    }
  };

  return (
    <LoginFormBlock>
          <Row className="justify-content-md-center">
            <Col xs={18} md={20}>
              <LoginTitle>로그인</LoginTitle>
              <Form onSubmit={handleSubmit}>
                <FloatingLabel
                  controlId="floatingInputId"
                  label="아이디 입력"
                  className="mb-3"
                >
                  <Form.Control type="text" placeholder="ID" name="userName" />
                </FloatingLabel>
                <FloatingLabel
                  controlId="floatingInputPassword"
                  label="비밀번호 입력"
                  className="mb-3"
                >
                  <Form.Control type="password" placeholder="PASSWORD" name="password"/>
                </FloatingLabel>
                <Container className="d-flex justify-content-center mt-3">
                  <Button variant="outline-primary" type="submit" size="lg">로그인</Button>
                </Container>
                {validLogin === true ? <ValidMessage>아이디와 비밀번호를 다시 확인해주세요.</ValidMessage> : <></>}
              </Form>
            </Col>
          </Row>
          <hr />
          <h5>흑시 <FindIdText onClick={onClickFindTest}>아이디</FindIdText>나 <FindPasswordText onClick={onClickFindTest}>비밀번호</FindPasswordText>를 잊어버리셨나요?</h5>
          <Modal
            size="lg"
            show={show}
            onHide={handleClose}
            backdrop="static"
            keyboard={false}
          >
            <Modal.Header closeButton>
              <Modal.Title><h1>아이디&비밀번호 찾기</h1></Modal.Title>
            </Modal.Header>
            <Modal.Body>
              <Form>
                <Form.Group className="mb-3" controlId="formBasicEmail">
                  <h2>아이디 찾기</h2>
                  <Form.Label>이메일 입력</Form.Label>
                  <Form.Control type="email" placeholder="Enter email" />
                  <Form.Text className="text-muted">
                    우리는 귀하의 이메일을 다른 누구와도 공유하지 않습니다.
                  </Form.Text>
                  <br />
                  <Button variant="outline-primary" type="submit" size="sm">아이디 찾기!</Button>
                </Form.Group>
              </Form>
            </Modal.Body>
            <Modal.Footer>
              <Button variant="secondary" onClick={handleClose}>
                Close
              </Button>
              <Button variant="primary">Understood</Button>
            </Modal.Footer>
          </Modal>
    </LoginFormBlock>
  );
}
