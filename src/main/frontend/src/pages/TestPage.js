import React from "react";
import { useSelector } from "react-redux";

function TestPage(){
  const { auth } = useSelector(state=>state.auth);
  console.log(auth);
  return(
    <>
      <p>ssibal</p>
      
    </>
  )
}

export default React.memo(TestPage);