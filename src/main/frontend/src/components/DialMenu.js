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
    z-index: 5;
    position: absolute;
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
        transform: translateX(-50%) translateY(0%) rotate(360deg);
    `}
`


function DialMenu(){
    const [open,setOpen] = useState(false);
    const onToggle = () =>{
        setOpen(!open);
        console.log(open);
    };
    
    return (
        <CircleButton onClick={onToggle} open={open}>
            <TiWaves size={85}/>
        </CircleButton>
    );

}

export default React.memo(DialMenu);