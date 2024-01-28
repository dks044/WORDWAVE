import React, { useEffect, useState } from "react";
import styled from "styled-components";
import LogoImg from "../resources/WAVELOGO.png";
import { Link, useNavigate } from "react-router-dom";
import { BsFillPersonLinesFill } from "react-icons/bs";
import { IoMdLogOut } from "react-icons/io";
import { useDispatch, useSelector } from "react-redux";
import { Button, Modal } from 'react-bootstrap';
import { logout } from "../modules/auth";


function NavComponent(){
   const Navbar = styled.div`
    font-weight: bold;
    display: flex;
    width: 100%;
  `;

  const NavListLeft = styled.ul`
    display: flex;
    justify-content: left;
    padding-left: 0;
    width: 100%;
    margin-left: 5%;
    margin-top: 5%;
  `;

  const NavListRight = styled.ul`
    display: flex;
    justify-content: right;
    padding-left: 0;
    width: 100%;
    margin-right: 5%;
    margin-top: 5%;
  `;
  const NavListCenter = styled.div`
    display: flex;
    justify-content: center;
    width: 100%;
  `;

  const Logo = styled.img`
  //크기
  max-width: 76px;
  max-height: 76px;
  object-fit: contain;
  //위치
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
  `;

  const NavItem = styled.li`
    list-style: none;
    opacity: 0;
    transition: opacity 2s ease-in-out;
    animation: fadeIn 2s;
    animation-fill-mode: forwards;

    @keyframes fadeIn {
      to {
        opacity: 1;
      }
    }
  `;
  //Icon
    const IconBox = styled.div`
    font-size: 40px;
    color: #0078ff;
    position: relative;
    top: -10%; 
    display: flex;
    justify-content: space-between;
    width: 100px; 
    transition: 0.325s all ease-in;
    cursor: pointer;
    &:hover {
      color: #63e6be;
    }
  `;
  const Icon = styled.i`
    font-size: 40px;
    color: #0078ff;
    transition: 0.325s all ease-in;
    cursor: pointer;
    &:hover {
      color: #63e6be;
    }
  `;

  const { isLoging, user} = useSelector(state=>state.auth);

  //Modal(로그아웃)
  const [show, setShow] = useState(false);
  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);
  
  //로그아웃
  const [onLogout,setOnLogout] = useState(false);
  const handleLogout = () => setOnLogout(true);
  const dispatch = useDispatch();
  const navigate = useNavigate();
  
  console.log(onLogout);
  useEffect(()=>{
    if(onLogout){
      dispatch(logout());
      setShow(false);
      setOnLogout(false);
      navigate('/');
    }
  },[onLogout,show]);


  return(
    <Navbar>
      <NavListLeft>
        {isLoging && user.userName && <NavItem>{user.userName} 반가워요!😄</NavItem>}
      </NavListLeft>
      <NavListCenter>
        <Link to="/">
            <Logo src={LogoImg} alt="LogoImg" />
        </Link>
      </NavListCenter>
      <NavListRight>
        {isLoging && user.id && 
          <NavItem>
            <IconBox>
              <Icon as={BsFillPersonLinesFill}/>
              <Icon as={IoMdLogOut} onClick={handleShow}/>
            </IconBox>
          </NavItem>}
      </NavListRight>
      <Modal show={show} onHide={handleClose} animation={true}>
        <Modal.Header closeButton>
          <Modal.Title>로그아웃</Modal.Title>
        </Modal.Header>
        <Modal.Body>로그아웃 하시겠습니까?🥹</Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            닫기
          </Button>
          <Button variant="primary" onClick={handleLogout}>
            로그아웃
          </Button>
        </Modal.Footer>
      </Modal>
    </Navbar>
  )
}

export default NavComponent;