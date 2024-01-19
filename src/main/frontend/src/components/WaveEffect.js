import React from "react";
import styled, { keyframes } from "styled-components";

const waveAnimation = keyframes`
   from {
        transform: rotate(0deg);
    }
   to {
        transform: rotate(360deg);
    }
`;
const WaveEffectContainer = styled.div`
  position: absolute;
  width: 100%;
  height: 100%;
  /* overflow-x: hidden; */
`;

const WaveOne = styled.div`
  position: absolute;
  top: 20%;
  left: 50%;
  width: 200vw;
  height: 200vw;
  margin-left: -100vw;
  margin-top: -196vw;
  border-radius: 40%;

  animation: ${waveAnimation} 10000ms infinite linear;
  opacity: 0.5;
  background: #0af;
`;
const WaveTwo = styled.div`
  position: absolute;
  top: 20%;
  left: 50%;
  width: 200vw;
  height: 200vw;
  margin-left: -100vw;
  margin-top: -196vw;
  border-radius: 40%;

  animation: ${waveAnimation} 13500ms infinite linear;
  opacity: 0.1;
  background: yellow;
`;
const WaveThree = styled.div`
  position: absolute;
  top: 20%;
  left: 50%;
  width: 200vw;
  height: 200vw;
  margin-left: -100vw;
  margin-top: -196vw;
  border-radius: 40%;

  animation: ${waveAnimation} 11000ms infinite linear;
  opacity: 0.1;
  background: #e8a;
`;

export default function WaveEffect() {
  return (
    <WaveEffectContainer>
      <WaveOne />
      <WaveTwo />
      <WaveThree />
    </WaveEffectContainer>
  );
}
