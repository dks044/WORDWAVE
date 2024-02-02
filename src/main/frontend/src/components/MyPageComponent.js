import React, { useState } from "react";
import { Button, FloatingLabel, Form, Modal, Spinner } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import styled from "styled-components";
import { showPopup } from "../modules/popup";
import { changePw, deleteUser, logout } from "../modules/auth";
import { useNavigate } from "react-router-dom";

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
  const navigate = useNavigate();

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
  const [email, setEmail] = useState('');
  const [deleteMessage,setDeleteMessage] = useState('');

  const onChangeOriginalPassword = (e) => setPassword(e.target.value);
  const onChangeNewPassword = (e) => setNewPassword(e.target.value);
  const onChangeConfirmedPassword = (e) => setConfirmedPassword(e.target.value);
  const onChangeEmail = (e) => setEmail(e.target.value);
  const onChangeDeleteMessage = (e) => setDeleteMessage(e.target.value);

  const onClickChangePwFormButton = async () =>{
    if(newPassword !== confirmedPassword){
      await dispatch(showPopup('새로운 비밀번호와 확인 비밀번호 입력값이 다릅니다.'));
      return;
    }
    if(password === newPassword){
      await dispatch(showPopup('원래 비밀번호와 변경 비밀번호를 같게 설정 할 수 없습니다.'));
      return;
    }
    if(!password || !newPassword || !confirmedPassword){
      await dispatch(showPopup('빈 입력칸이 있는지 확인해주세요.'));
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
  
  const onclickDeleteUserShowButton = () => {
    handleShow();
    setModalTitle('회원 탈퇴🥹');
    setModalBody('deleteUserForm');
  }

  const onClickDeleteUserFormButton = async () =>{
    if(deleteMessage !== '네 탈퇴하겠습니다.' || !deleteMessage){
      await dispatch(showPopup('탈퇴 확인 메시지를 제대로 작성해주세요.'));
      return;
    }
    if(!email || !password || !deleteMessage){
      await dispatch(showPopup('빈 입력칸이 있는지 확인해주세요.'));
      return;
    }

    try {
      setLoading(true); //로딩시작
      await dispatch(deleteUser(email,password));
      await dispatch(logout());
      navigate('/');
      await dispatch(showPopup('계정 탈퇴가 완료됐습니다, 이후에 또 만나길 바랍니다!😎'))
    } catch (error) {
      await dispatch(showPopup('입력하신 비밀번호와 이메일이 회원정보와 일치하지 않습니다.'));
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
        <Button onClick={onclickDeleteUserShowButton} variant="danger">회원 탈퇴</Button>
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
          {modalBody === 'deleteUserForm' && (
            <>
              <p>원래 비밀번호, 가입시 등록한 이메일을 입력해주세요.</p>
              <p>"네 탈퇴하겠습니다." 까지 입력하면 계정 탈퇴가 가능합니다.</p>
              <FloatingLabel controlId="floatingPassword" label="원래 비밀번호">
                <Form.Control type="password" placeholder="원래 비밀번호" onChange={onChangeOriginalPassword}/>
              </FloatingLabel>
              <FloatingLabel controlId="floatingEmail" label="이메일">
                <Form.Control type="email" placeholder="이메일" onChange={onChangeEmail}/>
              </FloatingLabel>
              <FloatingLabel controlId="floatingDeleteMessage" label="정말로 탈퇴하시겠습니까? (네 탈퇴하겠습니다.)">
                <Form.Control type="text" placeholder="네 탈퇴하겠습니다." onChange={onChangeDeleteMessage}/>
              </FloatingLabel>
              <div className="d-grid gap-2">
                <Button onClick={onClickDeleteUserFormButton} variant="danger">회원 탈퇴</Button>
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