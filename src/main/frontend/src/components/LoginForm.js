import React, { useState } from 'react';
import { Button, Col, Form, Row } from 'react-bootstrap';
import { useDispatch} from 'react-redux';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import {login} from '../modules/auth'

export default function LoginForm(){
  const dispatch = useDispatch();
  const [validLogin,setValidLogin] = useState(false);

  const navigate = useNavigate();

  const handleSubmit = async (event) => {
    event.preventDefault();
    const userName = event.target.elements.formBasicEmail.value;
    const password = event.target.elements.formBasicPassword.value;
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
    top: 35%;
    left: 50%;
    transform: translateX(-50%);
  `
  const ValidMessage = styled.p`
    color: red;
  `

  return (
    <LoginFormBlock>
          <Row className="justify-content-md-center">
            <Col xs={18} md={20}>
              <Form onSubmit={handleSubmit}>
                <Form.Group className="mb-3" controlId="formBasicEmail">
                  <Form.Control type="text" placeholder="ID" name="userName"/>
                </Form.Group>
                <Form.Group className="mb-3" controlId="formBasicPassword">
                  <Form.Control type="password" placeholder="PASSWORD" name="password"/>
                </Form.Group>
                <Button variant="outline-primary" type="submit">LOGIN</Button>
                {validLogin === true ? <ValidMessage>아이디와 비밀번호를 다시 확인해주세요.</ValidMessage> : <></>}
              </Form>
            </Col>
          </Row>
    </LoginFormBlock>
  );
}
