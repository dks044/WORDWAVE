import React, {useEffect, useState} from 'react';
import axios from 'axios';
import { createGlobalStyle } from 'styled-components';
import GmarketSansTTFLight from './fonts/GmarketSansTTFLight.ttf';

function App() {
    const GlobalStyle = createGlobalStyle`
        @font-face {
            font-family: 'GmarketSansTTFLight';
            src: url(${GmarketSansTTFLight}) format('truetype');
            font-weight: normal;
            font-style: normal;
        }

        body {
            font-family: 'GmarketSansTTFLight', sans-serif;
            background: linear-gradient(to right, #89CFF0 0%, #B2FFFF 50%, #89CFF0 100%);
        }
    `;




    return (
        <>
            <GlobalStyle />
            <h1>WORDWAVE 입니다, 반갑습니다 ENGLISH 공부 페이지 입니다</h1>
        </>
    );
}

export default App;