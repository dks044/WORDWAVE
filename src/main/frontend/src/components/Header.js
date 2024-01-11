import React from "react";
import styled from "styled-components";
import LogoImg from '../resources/WAVELOGO.png';

const HeaderBlock = styled.div`
    display: flex;
    flex-direction: column;    // flex 요소들을 세로로 배치
    align-items: center;       // 세로 방향으로 중앙에 배치
    width: 100%;               
    height: 10%;
    border-bottom: 1px solid #e9ecef; //확인용
`;

const Logo = styled.img`
    position: absolute;
    top: -5px;
    max-width: 20%;          
    max-height: 10%;          // 로고의 높이를 조금 줄임
    object-fit: contain;      
`;

const Navbar = styled.div`
    display: flex;
    width: 100%;                     // 너비를 조금 줄여서 좌우 여백을 만듦
`;

const NavListLeft = styled.ul`
    display: flex;                  // 리스트 요소들을 가로로 배치
    justify-content: left; // 리스트 요소들을 좌우 끝으로 배치
    padding-left: 0;        // 추가된 부분: 좌측 패딩 제거
    width: 100%;                    // 부모 요소의 전체 너비를 차지
    margin-left: 10px;
`;

const NavListRight = styled.ul`
    display: flex;                  // 리스트 요소들을 가로로 배치
    justify-content: right; // 리스트 요소들을 좌우 끝으로 배치
    padding-left: 0;        // 추가된 부분: 좌측 패딩 제거
    width: 100%;                    // 부모 요소의 전체 너비를 차지
    margin-right: 10px;
`;

const NavItem = styled.li`
    list-style: none;               // 리스트 표시를 없앰
`;

export default function Header(){
    return(
        <>
            <HeaderBlock>
                <Logo src={LogoImg} alt="LogoImg" />
                <Navbar>
                    <NavListLeft>
                        <NavItem>홍길동님 안녕하세요</NavItem>
                    </NavListLeft>
                    <NavListRight>
                        <NavItem>Login | Join</NavItem>
                    </NavListRight>
                </Navbar>
            </HeaderBlock>
            <hr/>
        </>
    )
}
