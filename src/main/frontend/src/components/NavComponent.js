import React, { useEffect, useState } from "react";
import styled from "styled-components";
import LogoImg from "../resources/WAVELOGO.png";
import { Link } from "react-router-dom";
import { BsFillPersonLinesFill } from "react-icons/bs";
import { IoMdLogOut } from "react-icons/io";
import { useSelector } from "react-redux";
import { Button, Modal } from 'react-bootstrap';

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
  `;

  const { isLoging, user} = useSelector(state=>state.auth);
  
  //Modal(로그아웃)
  const [show, setShow] = useState(false);
  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);


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

  return(
    <Navbar>
      <NavListLeft>
        {isLoging ? <NavItem>{user.userName} 반가워요!😄</NavItem> : <></>}
      </NavListLeft>
      <NavListCenter>
        <Link to="/">
            <Logo src={LogoImg} alt="LogoImg" />
        </Link>
      </NavListCenter>
      <NavListRight>
        {isLoging ? <NavItem>
                      <IconBox>
                        <Icon as={BsFillPersonLinesFill}/>
                        <Icon as={IoMdLogOut} onClick={handleShow}/>
                      </IconBox>
                    </NavItem> : <></>}
      </NavListRight>
      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Modal heading</Modal.Title>
        </Modal.Header>
        <Modal.Body>Woohoo, you are reading this text in a modal!</Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
          <Button variant="primary" onClick={handleClose}>
            Save Changes
          </Button>
        </Modal.Footer>
      </Modal>
    </Navbar>
  )
}

export default NavComponent;