import React, { useEffect, useState } from "react";
import styled from "styled-components";
import LogoImg from "../resources/WAVELOGO.png";
import { Link } from "react-router-dom";
import { userNameApi } from "../api/authAPI";

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

const [userName, setUserName] = useState('');

useEffect(() => {
  userNameApi()
    .then(response => {
      setUserName(response.data.name);  // 서버에서 반환한 사용자 이름을 상태에 저장
    })
    .catch(error => {
      console.error('사용자 이름 가져오기 실패', error);
    });
}, []);


  return(
    <Navbar>
      <NavListLeft>
        <NavItem>{userName && <p>안녕하세요, {userName}님!</p>}</NavItem>
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