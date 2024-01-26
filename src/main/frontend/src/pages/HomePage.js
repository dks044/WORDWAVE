import React from "react";
import styled from "styled-components";

const HomeContainer = styled.div`
    flex: 1;
    justify-content: center;
    text-align: center;
    padding-top: 30%;
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