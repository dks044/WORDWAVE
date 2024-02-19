import React from "react";

function Voca({ voca }) {
  console.log(voca);
  return (
    <div>
      {voca.map((v) => (
        <div key={v.id}>
          <p>{v.korWord}</p>
          <p>{v.engWord}</p>
        </div>
      ))}
    </div>
  );
}

export default React.memo(Voca);
