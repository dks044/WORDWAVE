import React from "react";
import { Outlet } from "react-router-dom";
import styled from "styled-components";
import DialMenu from "./DialMenu";
import Header from "./Header";

const TemplateBlock = styled.div`
  //스타일
  background: white;
  box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.04);
  margin: 0 auto;
  margin-top: 96px;
  margin-bottom: 15%;
  border-radius: 16px;
  display: flex;
  flex-direction: column;
  //크기
  width: 100vw;
  max-width: 512px;
  height: 100vh;
  max-height: 768px;
  //위치
  position: relative;
`;

function Layout() {
  return (
    <TemplateBlock>
      <Header />
      <Outlet />
      <DialMenu />
    </TemplateBlock>
  );
}

export default React.memo(Layout);
