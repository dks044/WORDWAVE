import React from "react";
import styled from "styled-components";
import NavComponent from "../components/NavComponent";

const HeaderBlock = styled.div`
  display: flex;
  flex-direction: column; // flex 요소들을 세로로 배치
  align-items: center;
  width: 100%;
  height: 10%;
  min-height: 77.8px;
  border-bottom: 1px solid #e9ecef;
`;
  
export default function HeaderContainer() {
  return (
    <>
      <HeaderBlock>
        <NavComponent />
      </HeaderBlock>
    </>
  );
}