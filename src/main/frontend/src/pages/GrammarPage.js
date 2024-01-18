import React, { useState } from "react";
import styled from "styled-components";

const StartButton = styled.button`
  //색 설정
  background: #2e2efd;
  //사이즈 설정
  width: 50%;
  height: 50px;
  //포지션 설정
  position: absolute;
  top: 40%;
  transform: translateX(50%);
  //테두리 설정
  border-style: none;
  border-radius: 12px;
  //글자 설정
  text-align: center;
  color: white;
`;

function GrammarPage() {
  //TODO: 버튼 누르면 grammar book 종류 고르고 해당 grammar book 서버에서 가져오기

  return (
    <>
      <StartButton>문법 퀴즈 시작</StartButton>
    </>
  );
}

export default GrammarPage;
