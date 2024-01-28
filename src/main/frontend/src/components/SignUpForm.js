import React from "react";
import { Button, Col, Form, Row } from "react-bootstrap";
import styled from "styled-components";

const SignUpFormBlock = styled.div`
  width: 80%;
  position: absolute;
  top: 25%;
  left: 50%;
  transform: translateX(-50%);
`


function SignUpForm(){
  return(
    <SignUpFormBlock>
        <Row className="justify-content-md-center">
          <Col xs={18} md={20}>
            <h1>회원가입</h1>
            <Form >
              <Form.Group className="mb-3">
                <Form.Label>아이디</Form.Label>
                <Form.Control type="text" placeholder="아이디를 입력하세요"/>
              </Form.Group>

              <Form.Group className="mb-3">
                <Form.Label>비밀번호</Form.Label>
                <Form.Control type="password" placeholder="비밀번호를 입력하세요"/>
              </Form.Group>

              <Form.Group className="mb-3">
                <Form.Label>이메일</Form.Label>
                <Form.Control type="email" placeholder="이메일을 입력하세요"/>
              </Form.Group>

              <Form.Group className="mb-3">
                <Form.Label>전화번호</Form.Label>
                <Form.Control type="text" placeholder="전화번호를 입력하세요"/>
              </Form.Group>
              <Button variant="primary" type="submit">
                가입하기
              </Button>
            </Form>
          </Col>
        </Row>
      </SignUpFormBlock>  
  )
}


export default SignUpForm;