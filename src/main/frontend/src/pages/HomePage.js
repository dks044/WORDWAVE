import React from "react";
import styled from "styled-components";

const HomeContainer = styled.div`
  overflow-y: scroll;
  text-align: center;
`;

const HomeTitle = styled.img`
    width: 100%;
    height: 100;
`

const HomePage = () => {
    return (
        <HomeContainer>
            <br /><br />
            <HomeTitle src="https://wordwave-bucket.s3.ap-northeast-2.amazonaws.com/resource/%ED%99%88%ED%99%94%EB%A9%B4.png"/>
            <br /><br /><br />
            <br/>
            <h4>☝️<strong>3600개</strong>의 영단어 퀴즈</h4><br/>
            <h4>✌️<strong>기초 문법</strong> 수록 </h4><br/>
            <h4>👌반복학습을 유도하는 <strong>랜덤 퀴즈 방식</strong></h4><br/>
            <h4>🤘<strong>나만의 영어단어장</strong></h4><br/>
            <h4>🖐<strong>학습이력 저장시스템</strong></h4><br/>

            <h4><strong>밑에 다이얼 버튼을 클릭하고 공부를 시작하세요😄</strong></h4>
            
            <br/>
            <br/><br/><br/><br/>
        </HomeContainer>
    )
}

export default React.memo(HomePage);

