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
const StyledSpinner = styled(Spinner)`
  position: absolute;
  top: 30%;
  width: 200px;
  height: 200px;
  & .spinner-border {
    width: 100%;
    height: 100%;
  }
`;
function LayoutContainer() {
  const [isLoading, setIsLoading] = useState(true);
  useEffect(() => {
    const timer = setTimeout(() => setIsLoading(false), 1500);
    return () => clearTimeout(timer);
  }, []);

  return (
    <TemplateBlock>
      <HeaderContainer />
      {isLoading ?
      <SpinnerWrapper>
        <StyledSpinner animation="grow" variant="info" />
      </SpinnerWrapper>
      : <Outlet />}
      <DialMenu />
    </TemplateBlock>
  );
}

export default React.memo(LayoutContainer);
