import React from "react";
import styled from "styled-components";
import { TiWaves } from "react-icons/ti";

const CircleButton = styled.button`
    //색 설정
    background: grey;
    color: white;
    //사이즈 설정
    width: 80px;
    height: 80px;
    border-radius: 50%;
    //포지션 설정
    z-index: 5;
    position: absolute;
    bottom: -20px;
    left: 50%;
    transform: translateX(-50%); /* Add this line */
    align-items: center;
    justify-content: center;
    //테두리 설정
    //border: 1px solid #E7E7E7;
    border: none;
    outline: none;

`


function DialMenu(){
    
    return (
        <CircleButton>
            <TiWaves size={65}/>
        </CircleButton>
    );

}

export default React.memo(DialMenu);