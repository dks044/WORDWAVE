import React from "react";
import { AiFillAlert } from "react-icons/ai";
import styled from "styled-components";
const IsNotDataBlock = styled.div`
  padding-left: 5%;
  padding-right: 5%;
  padding-top: 50%;
`
const Title = styled.h1`
  color: red;
  text-align: center;
`
export default function IsNotData(){
  return(
    <IsNotDataBlock>
      <Title><AiFillAlert size={100}/></Title>
      <Title>데이터가 없습니다!</Title>
    </IsNotDataBlock>
  )
}