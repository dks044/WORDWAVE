import React, { useCallback, useState } from "react";
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
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;

const GrammarBookButton = styled.button`
  //스타일
  background: #2e2efd;
  border-style: none;
  border-radius: 12px;
  text-align: center;
  color: white;
  //크기
  width: 50%;
  height: 50px;
  margin: 10px 0 10px 0;
`;

function GrammarPage() {
  const [click, setClick] = useState(false);
  const [grammarBooks, setGrammarBooks] = useState();

  const getGrammarBooks = useCallback(() => {
    fetch("/api/grammarbook/all", { method: "GET" })
      .then((response) => response.json())
      .then((grammarBooks) => setGrammarBooks(grammarBooks))
      .catch((error) => console.error("Error:", error));

    setClick(!click);
  }, [click]);

  const handleButtonClick = (data) => {
    // 버튼 클릭 이벤트 처리
    console.log(`${data}`);
  };

  return (
    <>
      <StartButton onClick={getGrammarBooks} hidden={click}>
        문법 퀴즈 시작
      </StartButton>
      <GrammarBookContainer>
        {grammarBooks &&
          Object.keys(grammarBooks).map((book) => (
            <GrammarBookButton
              key={book}
              onClick={() => handleButtonClick(book)}
            >
              {book}
            </GrammarBookButton>
          ))}
      </GrammarBookContainer>
    </>
  );
}

export default GrammarPage;
