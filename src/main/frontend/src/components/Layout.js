import React from "react";
import { Outlet } from "react-router-dom";
import styled from "styled-components";
import DialMenu from "./DialMenu";

const TemplateBlock = styled.div`
    //색 설정
    background: white;
    box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.04);
    //사이즈 설정
    width: 100%;
    max-width: 512px;
    height: 100vh;
    max-height: 768px;
    //포지션 설정
    position : relative;
    border-radius: 16px;
    display: flex;
    flex-direction: column;
    //마진&패딩 설정
    margin: 0 auto;
    margin-top: 96px;
    margin-bottom: 32px;
`;


function Layout(){
    return (
        <TemplateBlock>
            <DialMenu />
            <Outlet />
        </TemplateBlock>
    )
}




export default React.memo(Layout);