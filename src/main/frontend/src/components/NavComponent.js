import React, { useEffect, useState } from "react";
import styled from "styled-components";
import LogoImg from "../resources/WAVELOGO.png";
import { Link } from "react-router-dom";
import { userInfoApi } from "../api/authAPI";
import { useSelector } from "react-redux";

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
    margin-left: 10px;
  `;

  const NavListRight = styled.ul`
    display: flex;
    justify-content: right;
    padding-left: 0;
    width: 100%;
    margin-right: 10px;
  `;
  const NavListCenter = styled.div`
    display: flex;
    justify-content: center;
    padding-left: 0;
    width: 100%;
    margin-right: 10px;
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
  

  return(
    <Navbar>
      <NavListLeft>
        {isLoging ? <p> {user.userName}</p> : <p> 그래시발아</p>}
      </NavListLeft>
      <NavListCenter>
        <Link to="/">
            <Logo src={LogoImg} alt="LogoImg" />
        </Link>
      </NavListCenter>
      <NavListRight>
        <NavItem>Login | Join</NavItem>
      </NavListRight>
    </Navbar>
  )
}

export default NavComponent;