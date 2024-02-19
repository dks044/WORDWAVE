import React from "react";

function Voca({ voca,nextVoca }) {
  if (!voca) return null;
  return (
    <>
      <p>{voca.korWord}</p>
      <p>{voca.engWord}</p>
      <button onClick={nextVoca}>Next</button>
    </>
  );
}

export default React.memo(Voca);
