import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";
import { BrowserRouter } from "react-router-dom";
import { createGlobalStyle } from "styled-components";
import GmarketSansTTFLight from "./fonts/GmarketSansTTFLight.ttf";
import WaveEffect from "./components/WaveEffect";

const root = ReactDOM.createRoot(document.getElementById("root"));
const GlobalStyle = createGlobalStyle`
@font-face {
    font-family: 'GmarketSansTTFLight';
    src: url(${GmarketSansTTFLight}) format('truetype');
    font-weight: normal;
    font-style: normal;
}

#root {
  //스타일  
  font-family: 'GmarketSansTTFLight', sans-serif;
  background: linear-gradient(to right, #89CFF0 0%, #B2FFFF 50%, #89CFF0 100%);
  justify-content: center;
  display: flex;
  align-items: center;
  overflow-x: hidden;
  //크기
  width: 100vw;
  height: 100vh;
  //위치
  position: relative;
}
`;

root.render(
  <BrowserRouter>
    <GlobalStyle />
    <WaveEffect />
    <App />
  </BrowserRouter>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
