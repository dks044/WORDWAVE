import React, { useCallback, useState, useEffect } from "react";
import { Link, Outlet } from "react-router-dom";
import styled from "styled-components";

const StartButton = styled.button`
  //스타일
  background: #2e2efd;
  border-style: none;
  border-radius: 12px;
  text-align: center;
  color: white;
  //크기
  width: 50%;
  height: 50px;
  //위치
  position: absolute;
  top: 40%;
  transform: translateX(50%);

  visibility: ${(props) => (props.hidden ? "hidden" : "visible")};
`;

const GrammarBookContainer = styled.div`
  //스타일
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  overflow-y: auto;
  flex-wrap: wrap;
  gap: 10px;
  //크기
  height: 80%;
  //위치
  position: relative;
`;

const GrammarBookLink = styled(Link)`
  //스타일
  display: flex;
  flex-direction: column;
  justify-content: center;
  text-decoration: none;
  background: ${(props) => (props.diff ? "#2e2efd" : "#008FFF")};
  /* border-radius: 12px; */
  text-align: center;
  color: white;
  margin: 10px 10px 10px 10px;
  //크기
  width: 45%;
  height: 50px;
`;

const Span = styled.span`
  //스타일
  display: block;
  margin: 0 2px;
`;

function GrammarPage() {
  const [grammarBooks, setGrammarBooks] = useState();

  useEffect(() => {
    //   fetch("/api/grammarbook/all", { method: "GET" })
    //     .then((response) => response.json())
    //     .then((grammarBooks) => setGrammarBooks(grammarBooks))
    //     .catch((error) => console.error("Error:", error));

    // Use only during development
    const emptyGrammarBooks = [
      { id: 1, name: "현재와 현재진행", grammars: [] },
      { id: 2, name: "과거와 과거진행", grammars: [] },
      { id: 3, name: "현재 완료", grammars: [] },
      { id: 4, name: "미래", grammars: [] },
      { id: 5, name: "조동사", grammars: [] },
      { id: 6, name: "수동태", grammars: [] },
      { id: 7, name: "의문문", grammars: [] },
      { id: 8, name: "-ing와 to + 동사원형", grammars: [] },
      { id: 9, name: "명사와 대명사", grammars: [] },
      { id: 10, name: "수량 표현", grammars: [] },
      { id: 11, name: "형용사와 부사", grammars: [] },
      { id: 12, name: "전치사와 구동사", grammars: [] },
      { id: 13, name: "접속사와 절", grammars: [] },
      { id: 14, name: "다양한 문장들", grammars: [] },
      { id: 15, name: "불규칙 동사", grammars: [] },
      { id: 16, name: "주의해야할 형태 변화", grammars: [] },
      { id: 17, name: "축약형", grammars: [] },
      { id: 18, name: "주의해야 할 명사와 the 용법", grammars: [] },
      { id: 19, name: "사람과 사물을 가리키는 대명사", grammars: [] },
      { id: 20, name: "알아두면 유용한 형용사 + 전치사 표현", grammars: [] },
      { id: 21, name: "알아두면 유용한 동사 표현", grammars: [] },
    ];
    setGrammarBooks(emptyGrammarBooks);
  }, []);

  if (!grammarBooks) {
    return <div>Loading...</div>;
  }

  return (
    <>
      <GrammarBookContainer>
        {grammarBooks &&
          grammarBooks.map((grammarbook, index) => (
            <GrammarBookLink
              to={`/grammarbook/${grammarbook.id}`}
              key={grammarbook.id}
              diff={index % 2 === 0}
            >
              <Span>{grammarbook.name}</Span>
            </GrammarBookLink>
          ))}
      </GrammarBookContainer>
      <Outlet />
    </>
  );
}

export default GrammarPage;
