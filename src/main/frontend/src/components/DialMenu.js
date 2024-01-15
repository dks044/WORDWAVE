import React, { useState } from "react";
import styled, { css } from "styled-components";
import { TiWaves } from "react-icons/ti";

const CircleButton = styled.button`
    //색 설정
    background: skyblue;
    color: white;
    //사이즈 설정
    width: 100px;
    height: 100px;
    border-radius: 50%;
    //포지션 설정
    position: absolute;
    z-index: 5;
    bottom: -30px;
    left: 50%;
    transform: translateX(-50%);
    align-items: center;
    justify-content: center;
    //테두리 설정
    border: none;
    outline: none;
    //이벤트 설정
    cursor: pointer;
    &:hover {
        background: #63e6be;
    }
    &:active {
        background: #20c997;
    }
    //애니메이션 설정
    transition: 0.325s all ease-in;
    //사용자정의 이벤트 설정
    ${props =>
        props.open &&
        css`
        background: #2E2EFD;
        &:hover {
            background: #5783FB;
        }
        &:active {
            background: #0040FC;
        }
        transform: translateX(-50%) translateY(0%) rotate(180deg);
        
    `}
`
const CircleMenu = styled.div`
    //색 설정
    background: skyblue;
    color: white;
    //사이즈 설정
    width: 100px;
    height: 100px;
    border-radius: 50%;
    //포지션 설정
    position: absolute;
    z-index: 4;
    bottom: -30px;
    left: 50%;
    transform: translateX(-50%); 
    //애니메이션 설정
    transition: 0.25s all ease-in-out;
    //초기 상태 설정
    width: 0;
    height: 0;
    opacity: 0; // 투명도를 0으로 설정
    bottom: -15px; // 0의 크기에서 시작할 때의 위치

    ${props =>
        props.open &&
        css`
            width: 300px;
            height: 300px;
            bottom: -122px;
            opacity: 1; // open일 때 투명도를 1로 설정
        `
    }
`;



function DialMenu(){
    const [open,setOpen] = useState(false);
    const onToggle = () =>{
        setOpen(!open);
        console.log(open);
    };
    
    return (
        <>
            <CircleMenu open={open}>
            
            </CircleMenu>
            <CircleButton onClick={onToggle} open={open}>
                <TiWaves size={85}/>
            </CircleButton>
        </>
    );

}

export default React.memo(DialMenu);