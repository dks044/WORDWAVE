import React, { useState } from "react";
import { Button, Col, Form, Row, FloatingLabel, Container, Modal, Spinner, InputGroup } from "react-bootstrap";
import { useDispatch } from "react-redux";
import styled from "styled-components";
import { sendEmailCode, signUp } from "../modules/auth";
import { useNavigate } from "react-router-dom";
import { showPopup } from "../modules/popup";


const SignUpFormBlock = styled.div`
  width: 80%;
  position: absolute;
  top: 15%;
  left: 50%;
  transform: translateX(-50%);
`
const SignUpTitle = styled.h1`
  text-align: center;
`
const ModalTitle = styled.h2`
  font-weight: bolder;
`
const ValidCodeMessage = styled.h3`
  color: red;
`

function SignUpForm() {
  const [loading, setLoading] = useState(false);
  const [errorMessage,setErrorMessage] = useState('');
  const dispatch = useDispatch();
  const navigate = useNavigate();

  //modal
  const [show, setShow] = useState(false);
  const handleClose = () => {
    setShow(false);
    setErrorMessage('');
  };
  const handleShow = () => setShow(true);
  //toast

  //비밀번호 유효성검사
  function isPasswordValid(password) {
    const hasAlphabet = /[a-zA-Z]/.test(password);
    const hasSpecialCharacter = /[^0-9a-zA-Z]/.test(password);
    const isLengthValid = password.length >= 10 && password.length <= 20;

    return hasAlphabet && hasSpecialCharacter && isLengthValid;
  }



  //전화번호 자동 하이폰
  const autoHyphen = (event) => {
    let phoneNumber = event.target.value;
    phoneNumber = phoneNumber
      .replace(/[^0-9]/g, '')
      .replace(/^(\d{3})(\d{0,4})(\d{0,4})$/g, (match, p1, p2, p3) => {
        return `${p1}-${p2}-${p3}`.replace(/(\-)$/g, '');
      });
    event.target.value = phoneNumber;
  }

  // 전화번호 유효성 검사 함수
  function isPhoneNumberValid(phoneNumber) {
    return /^010-(\d{4})-(\d{4})$/.test(phoneNumber);
  }

  const handleSubmit = async (event) => {
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
      setErrorMessage('비밀번호는 10자 이상, 20자 이하여야 하며, 각각 영문자 한개, 특수문자 한개씩 포함되어야 합니다.');
      return;
    }
  
    if(!isPhoneNumberValid(phoneNumber)){
      handleShow();
      setErrorMessage('전화번호는 010으로 시작하고, 숫자가 총 11개여야 합니다.');
      return;
    }
    try {
      await dispatch(signUp(userName,password,email,phoneNumber));
      await dispatch(showPopup('회원가입에 성공하였습니다.'));
      navigate('/'); 
    } catch (error) {
      handleShow();
      setErrorMessage('이미 가입된 사용자이거나, 이메일입니다, 다시 확인해주세요.');
      return;
    }
  };

  const [email, setEmail] = useState('');
  const onChangeEmail = (e) => setEmail(e.target.value);
  const onChangeEmailCode = (e) => setEmailCode(e.target.value);
  const onClickEmailCodeSend = async () => {
    if(!email){
      await dispatch(showPopup('이메일을 입력하지 않았습니다.'));
      return;
    }
    try {
      setLoading(true);
      const response = await dispatch(sendEmailCode(email));
      if (response === "이미 이메일에 코드를 전송했습니다.") {
          await dispatch(showPopup('이미 인증 코드가 발송된 이메일입니다.(문의 : wordwave492@gmail.com'));
      } else {
          await dispatch(showPopup('입력하신 이메일에 인증코드가 전송 됐습니다.'));
      }
    } catch (error) {
      console.log(error);
    } finally {
      setLoading(false);
    }
  }
  const [codeValid,setCodeValid] = useState(false);
  const [emailCode,setEmailCode] = useState('');

  const onClickEmailCodeValid = async () => {
    
  }

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
              <Form.Control type="text" placeholder="아이디를 입력하세요" name="userName" />
            </FloatingLabel>

            <FloatingLabel
              controlId="floatingInputPassword"
              label="비밀번호 입력"
              className="mb-3"
            >
              <Form.Control onInput={(e) => e.target.value = e.target.value.replace(/[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, '')} type="password" placeholder="비밀번호를 입력하세요" name="password"/>
            </FloatingLabel>

            <FloatingLabel
              controlId="floatingInputEmail"
              label="이메일 입력"
              className="mb-3"
            >
              <Form.Control type="email" placeholder="이메일을 입력하세요" name="email" onChange={onChangeEmail} />
              <div className="d-grid gap-2">
                <Button onClick={onClickEmailCodeSend}>이메일 인증코드 전송{loading ? <Spinner animation="border" variant="light"/> : null}</Button>
              </div>
            </FloatingLabel>

            <InputGroup className="mb-3">
              <Form.Control
                placeholder="이메일 인증코드 입력하기"
                aria-label="Recipient's username"
                aria-describedby="basic-addon2"
                onChange={onChangeEmailCode}
              />
              <Button variant="outline-primary" id="button-addon2">
                인증코드 인증
              </Button>
            </InputGroup>

            <FloatingLabel
              controlId="floatingInputPhone"
              label="전화번호 입력"
              className="mb-3"
            >
            <Form.Control onInput={autoHyphen} type="text" placeholder="전화번호를 입력하세요" name="phoneNumber" maxLength="13"/>
            </FloatingLabel>
            <Container className="d-flex justify-content-center mt-3">
              <Button variant="outline-primary" type="submit" size="lg">가입하기</Button>
              {codeValid && (<ValidCodeMessage>이메일 인증 확인완료.</ValidCodeMessage>)}
            </Container>
          </Form>
        </Col>
      </Row>
      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title><ModalTitle>😥회원가입 오류</ModalTitle></Modal.Title>
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
