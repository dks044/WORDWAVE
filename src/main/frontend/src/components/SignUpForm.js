import React from "react";
import { Button, Col, Form, Row, FloatingLabel, Container } from "react-bootstrap";
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

function SignUpForm() {
  return (
    <SignUpFormBlock>
      <Row className="justify-content-md-center">
        <Col xs={18} md={20}>
          <SignUpTitle>회원가입</SignUpTitle>
          <Form>
            <FloatingLabel
              controlId="floatingInputId"
              label="아이디 입력"
              className="mb-3"
            >
              <Form.Control type="text" placeholder="아이디를 입력하세요" />
            </FloatingLabel>

            <FloatingLabel
              controlId="floatingInputPassword"
              label="비밀번호 입력"
              className="mb-3"
            >
              <Form.Control type="password" placeholder="비밀번호를 입력하세요" />
            </FloatingLabel>

            <FloatingLabel
              controlId="floatingInputEmail"
              label="이메일 입력"
              className="mb-3"
            >
              <Form.Control type="email" placeholder="이메일을 입력하세요" />
            </FloatingLabel>

            <FloatingLabel
              controlId="floatingInputPhone"
              label="전화번호 입력"
              className="mb-3"
            >
              <Form.Control type="text" placeholder="전화번호를 입력하세요" />
            </FloatingLabel>
            <Container className="d-flex justify-content-center mt-3">
              <Button variant="outline-primary" type="submit" size="lg">가입하기</Button>
            </Container>
          </Form>
        </Col>
      </Row>
    </SignUpFormBlock>
  )
}

export default SignUpForm;
