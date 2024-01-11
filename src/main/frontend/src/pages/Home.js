import React from "react";
import styled from "styled-components";

//임시
const TempStyle = styled.div`
    margin-top: 45px;
    font-size: 20px;
    text-align: center;
`;

const Home = () => {
    return (
        <div>
            <TempStyle>TempHome</TempStyle>
        </div>
    )
}

export default React.memo(Home);