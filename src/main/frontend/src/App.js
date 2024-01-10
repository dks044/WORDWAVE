import React, {useEffect, useState} from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import { createGlobalStyle } from 'styled-components';



function App() {
    const GlobalStyle = createGlobalStyle`
        body {
            background: linear-gradient(to right, #89CFF0 0%, #B2FFFF 50%, #89CFF0 100%);
        }
    `




    return (
        <>
            <GlobalStyle />
            배경화면 입니다~
        </>
    );
}

export default App;