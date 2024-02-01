import React, { useEffect } from "react";
import { Button } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import styled from "styled-components";
import { showPopup } from "../modules/popup";

const HomeContainer = styled.div`
  //크기
  flex: 1;
  justify-content: center;
  text-align: center;
  //위치
  position: inherit;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
`;



const HomePage = () => {
    return (
        <HomeContainer>
            <h2>환영합니다!</h2>
            <h1>WORDWAVE</h1>
            <p>밑에 다이얼 메뉴 버튼을 눌러 시작하세요</p>
        </HomeContainer>
    )
}

export default React.memo(HomePage);

