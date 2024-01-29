import React from "react";
import LogoImg from "../resources/WAVELOGO.png";
import styled from "styled-components";
import { Toast } from "react-bootstrap";

const ToastLogo = styled.img`
  width: 20px;  
  height: 20px; 
`;

function ToastComponent({show, onClose,message}){
  return(
    <>
      <Toast show={show} onClose={onClose}>
          <Toast.Header>
            <ToastLogo
              src={LogoImg}
              className="rounded me-2"
              alt=""
            />
            <strong className="me-auto">WORDWAVE</strong>
            {/* <small>11 mins ago</small> */}
          </Toast.Header>
          <Toast.Body>{message}</Toast.Body>
      </Toast>
    </>
  )
}

export default React.memo(ToastComponent);