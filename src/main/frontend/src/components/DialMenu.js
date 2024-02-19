import React, { useState } from "react";
import styled, { css } from "styled-components";
import { TiWaves } from "react-icons/ti";
import { Link } from "react-router-dom";
import { FaBook } from "react-icons/fa6";
import { FaSpellCheck } from "react-icons/fa";

const CircleButton = styled.button`
  //스타일
  background: skyblue;
  color: white;
  border: none;
  outline: none;
  border-radius: 50%;
  align-items: center;
  justify-content: center;
  //크기
  width: 100px;
  height: 100px;
  //위치
  position: absolute;
  z-index: 5;
  bottom: -30px;
  left: 50%;
  transform: translateX(-50%);
  //이벤트 설정
  cursor: pointer;
  &:hover {
    background: #63e6be;
  }
  &:active {
    background: #20c997;
  }
  //애니메이션 설정
  transition: 0.325s all ease-in;
  //사용자정의 이벤트 설정
  ${(props) =>
    props.open &&
    css`
      background: #2e2efd;
      &:hover {
        background: #5783fb;
      }
      &:active {
        background: #0040fc;
      }
      transform: translateX(-50%) translateY(0%) rotate(180deg);
    `}
`;
const CircleMenu = styled.div`
  //스타일
  background: skyblue;
  color: white;
  border-radius: 50%;
  opacity: 0; // 투명도를 0으로 설정
  //크기
  width: 0;
  height: 0;
  //위치
  position: absolute;
  z-index: 4;
  left: 50%;
  bottom: -15px; // 0의 크기에서 시작할 때의 위치
  transform: translateX(-50%);
  //애니메이션
  transition: 0.25s all ease-in-out;

  ${(props) =>
    props.open &&
    css`
      width: 300px;
      height: 300px;
      bottom: -122px;
      opacity: 1; // open일 때 투명도를 1로 설정
    `}
`;

const GrammarLink = styled(Link)`
  //스타일
  color: black;
  text-decoration: none;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  font-weight: bolder;
  //사이즈 설정
  width: 100px;
  height: 100px;
  //다이얼 메뉴내 GrammaarLink의 위치
  position: absolute;
  left: 50%;
  top: 5%;
  transform: translateX(-50%);
  transition: 0.35s all ease-in-out;
  &:hover {
    color: #54535a;
  }
  &:active {
    color: #2c2b2d;
  }
`;


const VocaLink = styled(Link)`
  //스타일
  color: black;
  text-decoration: none;
  font-weight: bolder;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  //사이즈 설정
  width: 100px;
  height: 100px;
  //다이얼 메뉴내 GrammaarLink의 위치
  position: absolute;
  left: 60%;
  top: 15%;
  transform: rotate( 45deg );
  transition: 0.35s all ease-in-out;
  &:hover {
    color: #54535a;
  }
  &:active {
    color: #2c2b2d;
  }
`;

function DialMenu() {
  const [open, setOpen] = useState(false);
  const onToggle = () => {
    setOpen(!open);
    // console.log(open);
  };

  return (
    <>
      <CircleMenu open={open}>
        {open && (
          <GrammarLink to="/grammarbook" onClick={onToggle} open={open}>
            <FaSpellCheck size={40}/>
            Grammar
          </GrammarLink>
        )}
        {open && (
          <VocaLink to="/vocabooks" onClick={onToggle} open={open}>
            <FaBook size={50}/>
            VOCA
          </VocaLink>
        )}
      </CircleMenu>
      <CircleButton onClick={onToggle} open={open}>
        <TiWaves size={85} />
      </CircleButton>
    </>
  );
}

export default React.memo(DialMenu);
