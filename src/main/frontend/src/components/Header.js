import React from "react";
import styled from "styled-components";
import LogoImg from '../resources/WAVELOGO.png';

const HeaderBlock = styled.div`
    display: flex;
    flex-direction: column;    // flex 요소들을 세로로 배치
    align-items: center;       
    width: 100%;               
    height: 10%;
    border-bottom: 1px solid #e9ecef; 
`;

const Logo = styled.img`
    position: absolute;
    top: -5px;
    max-width: 20%;          
    max-height: 10%;          
    object-fit: contain;      
`;

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

const NavItem = styled.li`
    list-style: none;               
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
        </>
    )
}
