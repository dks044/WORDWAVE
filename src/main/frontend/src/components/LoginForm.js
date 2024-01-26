import React from 'react';
import { Button, Col, Form, Row } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

export default function LoginForm(){
  const navigate = useNavigate();

  //로그인 로직 수행 api 추가 해야함
  const handleSubmit = (event) => {
    event.preventDefault();
    
  };
  const LoginFormBlock = styled.div`
    position: absolute;
    padding-top: 40%;
    left: 50%;
    transform: translateX(-50%);
  `


  return (
  <LoginFormBlock>
        <Row className="justify-content-md-center">
          <Col xs={18} md={12}>
            <Form onSubmit={handleSubmit}>
              <Form.Group className="mb-3" controlId="formBasicEmail">
                <Form.Control type="text" placeholder="ID" />
              </Form.Group>
              <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Control type="password" placeholder="PASSWORD"/>
              </Form.Group>
              <Button variant="outline-primary" type="submit">LOGIN</Button>
            </Form>
          </Col>
        </Row>
      </LoginFormBlock>
  );
}
