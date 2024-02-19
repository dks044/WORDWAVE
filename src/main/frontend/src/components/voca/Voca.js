import React from "react";

function Voca({ voca,nextVoca }) {
  if (!voca) return null;
  //한글단어(뜻) 제시하는 퀴즈일경우
  //영어단어 제시하는 퀴즈일경우
  return (
    <>
      <p>{voca.korWord}</p>
      <p>{voca.engWord}</p>
      <button onClick={nextVoca}>Next</button>
    </>
  );
}

export default React.memo(Voca);
