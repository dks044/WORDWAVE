import React, { useState, useEffect } from "react";
import { Outlet } from "react-router-dom";
import styled from "styled-components";
import DialMenu from "../components/DialMenu";
import HeaderContainer from "./HeaderContainer";
import { Spinner } from "react-bootstrap";

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
const SpinnerWrapper = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
`;

function LayoutContainer() {
  const [isLoading, setIsLoading] = useState(true);
  useEffect(() => {
    const timer = setTimeout(() => setIsLoading(false), 1000);
    return () => clearTimeout(timer);
  }, []);

  return (
    <TemplateBlock>
      <HeaderContainer />
      {isLoading ?
      <SpinnerWrapper>
        <Spinner animation="grow" variant="info" size="100" />
      </SpinnerWrapper>
      : <Outlet />}
      <DialMenu />
    </TemplateBlock>
  );
}

export default React.memo(LayoutContainer);
