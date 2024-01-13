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
            <p>알수없는 페이지 입니다.</p>
        </NotFoundContainer>
    )
}

export default React.memo(NotFound);