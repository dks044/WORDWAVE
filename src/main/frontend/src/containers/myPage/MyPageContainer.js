import React from "react";
import styled from "styled-components";
import MyPageComponent from "../../components/myPage/MyPageComponent";

const MyPageContainerBlock = styled.div`
  overflow-y: scroll;
  padding-top: 10%;
  padding-left: 5%;
  padding-right: 5%;
  
`


export default function MyPageContainer(){
 return (
  <MyPageContainerBlock>
      <MyPageComponent />
  </MyPageContainerBlock>
 ) 
}