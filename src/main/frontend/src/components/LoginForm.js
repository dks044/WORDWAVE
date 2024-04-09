import React, { useState } from 'react';
import { Button, Col, Container, FloatingLabel, Form, InputGroup, Modal, Row, Spinner } from 'react-bootstrap';
import { useDispatch} from 'react-redux';
import { useNavigate } from 'react-router-dom';
import styled from 'styled-components';
import {findId, findPw, login} from '../modules/auth'
import { showPopup } from '../modules/popup';

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
const TitleText = styled.h1`
  font-weight: bolder;
`
const SubTitleText = styled.h3`
  font-weight: bolder;
`

export default function LoginForm(){
  const [loading, setLoading] = useState(false);
  const dispatch = useDispatch();
  const [validLogin,setValidLogin] = useState(false);
  const navigate = useNavigate();
  //Modal(아이디찾기, 비밀번호찾기)
  const [show, setShow] = useState(false);
  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);
  const onClickFindTest = () => setShow(true);

  //로그인
  const handleSubmit = async (event) => {
    event.preventDefault();
    const userName = event.target.elements.floatingInputId.value;
    const password = event.target.elements.floatingInputPassword.value;
    try {
      await dispatch(login(userName,password));
      window.location.href = '/';
    } catch (e) {
      if(e.response && e.response.status === 401){
        setValidLogin(true);
      }
    }
  };
  
  const [emailForFindId, setEmailForFindId] = useState('');
  const [userNameForFindPw, setUserNameForFindPw] = useState('');
  const [emailForFindPw, setEmailForFindPw] = useState('');

  const onChangeEmailForFindId = (e) => {
    setEmailForFindId(e.target.value);
  };
  const onChangeUserNameForFindPw = (e) => {
    setUserNameForFindPw(e.target.value);
  };
  const onChangeEmailForFindPw = (e) => {
    setEmailForFindPw(e.target.value);
  };

  const onClickFindId = async () => {
    const email = emailForFindId;
    console.log(email);
    setLoading(true); //로딩시작

    try {
      await dispatch(findId(email));
      await dispatch(showPopup('입력하신 이메일에 아이디를 보냈습니다.'));
    } catch (error) {
      await dispatch(showPopup('유효하지 않은 이메일입니다.'));
      setEmailForFindId('');
    } finally {
      setLoading(false);
    }
  }
  
  const onClickFindPw = async (event) => {
    const userName = userNameForFindPw;
    const email = emailForFindPw;
    setLoading(true); //로딩시작
    try {
      await dispatch(findPw(userName,email));
      await dispatch(showPopup('입력하신 이메일에 임시 비밀번호를 전송했습니다.'));
    } catch (error) {
      await dispatch(showPopup('유효하지 않은 이메일과 아이디 입니다.'));
      setEmailForFindPw('');
      setUserNameForFindPw('');
    } finally {
      setLoading(false);
    }
  }

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
              <Modal.Title><TitleText>👀 아이디&비밀번호 찾기 {loading ? <Spinner animation="border" /> : null}</TitleText></Modal.Title>
            </Modal.Header>
            <Modal.Body>
              <SubTitleText>아이디 찾기</SubTitleText>
              <p>가입시 입력한 이메일을 입력하세요.</p>
              <InputGroup className="mb-3">
                <Form.Control
                  placeholder="이메일 입력"
                  aria-label="Recipient's username"
                  aria-describedby="basic-addon2"
                  onChange={onChangeEmailForFindId}
                />
                <Button onClick={onClickFindId} variant="outline-secondary" id="button-addon2">
                  아이디 찾기
                </Button>
              </InputGroup>
              <hr />
              <SubTitleText>비밀번호 찾기</SubTitleText>
              <p>가입시 입력한 이메일과 아이디를 입력하세요.</p>
              <InputGroup className="mb-3">
                <Form.Control
                  placeholder="아이디 입력"
                  aria-label="Recipient's username"
                  aria-describedby="basic-addon2"
                  onChange={onChangeUserNameForFindPw}
                />
                <Form.Control
                  placeholder="이메일 입력"
                  aria-label="Recipient's username"
                  aria-describedby="basic-addon2"
                  onChange={onChangeEmailForFindPw}
                />
                <Button onClick={onClickFindPw} variant="outline-secondary" id="button-addon2">
                  비밀번호 찾기
                </Button>
              </InputGroup>
            </Modal.Body>
            <Modal.Footer>
              <Button variant="secondary" onClick={handleClose}>
                닫기
              </Button>
            </Modal.Footer>
          </Modal>
    </LoginFormBlock>
  );
}
