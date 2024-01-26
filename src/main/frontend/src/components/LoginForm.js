import React from 'react';
import { Button, Form } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';

export default function LoginForm(){
  const navigate = useNavigate();

  const handleSubmit = (event) => {
    event.preventDefault();
    // 폼 데이터 처리
    // navigate('/some-path'); // 필요한 경로로 리디렉션
  };

  return (
    <Form onSubmit={handleSubmit}>
      <Form.Group className="mb-3" controlId="formBasicEmail">
        <Form.Control type="text" placeholder="ID" />
      </Form.Group>

      <Form.Group className="mb-3" controlId="formBasicPassword">
        <Form.Control type="password" placeholder="PASSWORD" />
      </Form.Group>

      <Button variant="outline-primary" type="submit">LOGIN</Button>
    </Form>
  );
}
