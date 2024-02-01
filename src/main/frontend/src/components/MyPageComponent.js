import React, { useState } from "react";
import { Button, FloatingLabel, Form, Modal, Spinner } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import styled from "styled-components";
import { showPopup } from "../modules/popup";
import { changePw } from "../modules/auth";

const Title = styled.h1`
  text-align: center;
  font-weight: bolder;
  `

export default function MyPageComponent(){
  const {user} = useSelector(state=>state.auth);
  const [showEmail,setShowEmail] = useState(false);
  const [showPhoneNumber,setShowPhoneNumber] = useState(false);
  const [loading, setLoading] = useState(false);
  const dispatch = useDispatch();

  function onMouseOverForEmail (){ return setShowEmail(true);}
  function onMouseOutForEmail(){ return setShowEmail(false);}
  function onMouseOverForPhoneNumber() {return setShowPhoneNumber(true);}
  function onMouseOutForPhoneNumber() {return setShowPhoneNumber(false);}
  //modal
  const [show, setShow] = useState(false);
  const handleClose = () =>{
    setShow(false);
    setModalBody('');
    setModalTitle('');
  }
  const handleShow = () => setShow(true);
  const [modalTitle,setModalTitle] = useState('');
  const [modalBody,setModalBody] = useState('');
  const onclickChangePwShowButton = () => {
    handleShow();
    setModalTitle('비밀번호 변경');
    setModalBody('pwForm');
  }

  const [password, setPassword] = useState('');
  const [newPassword, setNewPassword] = useState('');
  const [confirmedPassword, setConfirmedPassword] = useState('');

  const onChangeOriginalPassword = (e) => setPassword(e.target.value);
  const onChangeNewPassword = (e) => setNewPassword(e.target.value);
  const onChangeConfirmedPassword = (e) => setConfirmedPassword(e.target.value);

  const onClickChangePwFormButton = async () =>{
    if(newPassword !== confirmedPassword){
      showPopup('변경 비밀번호와 변경 확인 비밀번호가 다릅니다.');
      return;
    }
    if(password === newPassword){
      showPopup('원래 비밀번호와 변경 하실 비밀번호가 같습니다!');
      return;
    }

    try {
      setLoading(true); //로딩시작
      await dispatch(changePw(password,newPassword));
      await dispatch(showPopup('비밀번호를 새로운 변경했습니다, 다음에 새로운 비밀번호로 로그인하세요.'))
    } catch (error) {
      await dispatch(showPopup('원래비밀번호와 입력하신 비밀번호가 다릅니다.'));
      return;
    } finally {
      setLoading(false);
    }
  }
  
  return(
    <>
      <Title>🆎VOCA🆑</Title>
      <hr/>
      <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dignissimos enim quod sequi nobis, praesentium, doloribus dolore ullam eum quis repellat repellendus aliquam voluptatibus deserunt harum ex. Qui adipisci consectetur nostrum?</p>
      <br />
      <Title>💁🏼‍♂️Grammer💁🏼‍♀️</Title>
      <hr/>
      <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dignissimos enim quod sequi nobis, praesentium, doloribus dolore ullam eum quis repellat repellendus aliquam voluptatibus deserunt harum ex. Qui adipisci consectetur nostrum?</p>
      <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
      <Title>내 프로필</Title>
      <p>마우스를 올리면 유저정보가 보입니다.</p>
      <hr/>
      <div className="d-grid gap-2">
        <h1>ID : {user.userName}</h1>
        <h3 onMouseOver={onMouseOverForEmail} onMouseOut={onMouseOutForEmail} >Email : {showEmail && user.email}</h3>
        <h4 onMouseOver={onMouseOverForPhoneNumber} onMouseOut={onMouseOutForPhoneNumber}>number : {showPhoneNumber && user.phoneNumber}</h4>
        <Button onClick={onclickChangePwShowButton} variant="info">비밀번호 변경</Button>
        <Button variant="danger">회원 탈퇴</Button>
      </div>
      <Modal
        show={show}
        onHide={handleClose}
        backdrop="static"
        keyboard={false}
      >
        <Modal.Header closeButton>
          <Modal.Title>{modalTitle} {loading ? <Spinner animation="border" /> : null}</Modal.Title>
        </Modal.Header>
        <Modal.Body> 
          {modalBody === 'pwForm' && (
            <>
              <p>원래 비밀번호, 변경 하고싶은 비밀번호를 입력하세요.</p>
              <FloatingLabel controlId="floatingOriginPassword" label="원래 비밀번호">
                <Form.Control type="password" placeholder="원래 비밀번호" onChange={onChangeOriginalPassword}/>
              </FloatingLabel>
              <FloatingLabel controlId="floatingNewPassword" label="변경 비밀번호">
                <Form.Control type="password" placeholder="바꿀 비밀번호" onChange={onChangeNewPassword}/>
              </FloatingLabel>
              <FloatingLabel controlId="floatingNewConfirmPassword" label="변경 비밀번호 확인">
                <Form.Control type="password" placeholder="바꿀 비밀번호 확인" onChange={onChangeConfirmedPassword}/>
              </FloatingLabel>
              <div className="d-grid gap-2">
                <Button onClick={onClickChangePwFormButton} variant="info">비밀번호 변경</Button>
              </div>
            </>
          )}
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
        </Modal.Footer>
      </Modal>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>
      <br></br>

    </>
  )
}