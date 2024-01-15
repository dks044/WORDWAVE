import React from "react"
import styled from "styled-components";

const NotFoundContainer = styled.div`
    flex: 1;
    justify-content: center;
    text-align: center;
    padding-top: 30%;
    
`

function NotFound(){
    return(
        <NotFoundContainer>
            <h1>404</h1>
            <h3>죄송합니다.
            요청하신 페이지를 찾을 수 없습니다.</h3>

        </NotFoundContainer>
    )
}

export default React.memo(NotFound);