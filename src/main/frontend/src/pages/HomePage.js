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


const HomePage = () => {
    return (
        <HomeContainer>
            <br /><br /><br />
            <h1>WORDWAVE</h1>
            <br/>
            <p>☝️<strong>3600개</strong>의 영단어 퀴즈</p>
            <p>✌️<strong>기초 문법</strong> 수록 </p>
            <p>👌반복학습을 유도하는 <strong>랜덤 퀴즈 방식</strong></p>
            <p>🤘<strong>나만의 영어단어장</strong></p>
            <p>🖐<strong>학습이력 저장시스템</strong></p>
            <br/>
            <h5>😄밑에 <strong>다이얼 버튼</strong>을 클릭하고 공부를 시작하세요😀</h5>
        </HomeContainer>
    )
}

export default React.memo(HomePage);

