import React from "react";
import styled from "styled-components";

const TempStyle = styled.div`
    margin-top: 45px;
    font-size: 50px;
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