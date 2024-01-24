import React from "react";
import styled from "styled-components";

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
const Hr = styled.hr`
  width: 30%;
`;

const Home = () => {
  return (
    <HomeContainer>
      <h2>환영합니다!</h2>
      <h1>WORDWAVE</h1>
      <Hr></Hr>
      <p>밑에 다이얼 메뉴 버튼을 눌러 시작하세요</p>
    </HomeContainer>
  );
};

export default React.memo(Home);
