import React, { useState } from 'react';
import { Button, Col, FloatingLabel, Form, Row } from 'react-bootstrap';
import { useDispatch} from 'react-redux';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import {login, userInfo} from '../modules/auth'

export default function LoginForm(){
  const dispatch = useDispatch();
  const [validLogin,setValidLogin] = useState(false);

  const navigate = useNavigate();

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
                <Button variant="outline-primary" type="submit">LOGIN</Button>
                {validLogin === true ? <ValidMessage>아이디와 비밀번호를 다시 확인해주세요.</ValidMessage> : <></>}
              </Form>
            </Col>
          </Row>
    </LoginFormBlock>
  );
}
