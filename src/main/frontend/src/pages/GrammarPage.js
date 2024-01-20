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
    // fetch("/api/grammarbook/all", { method: "GET" })
    //   .then((response) => response.json())
    //   .then((grammarBooks) => setGrammarBooks(grammarBooks))
    //   .catch((error) => console.error("Error:", error));

    //Use only during development
    const emptyGrammarBooks = [
      { id: 5, name: "test book1", grammars: [] },
      { id: 6, name: "test book2", grammars: [] },
    ];
    setGrammarBooks(emptyGrammarBooks);

    setClick(!click);
  }, [click]);

  const handleButtonClick = (data) => {
    //TODO:
    //1. 각 grammarbook을 클릭하면 해당 id의 grammarbook GET 요청가져오기
    //2. 가져온 데이터를 하위 퀴즈 페이지에 props로 전달
  };

  return (
    <>
      <StartButton onClick={getGrammarBooks} hidden={click}>
        문법 퀴즈 시작
      </StartButton>
      <GrammarBookContainer>
        {grammarBooks &&
          grammarBooks.map((grammarbook) => (
            <GrammarBookButton
              key={grammarbook.id}
              onClick={handleButtonClick(grammarbook.id)}
            >
              {grammarbook.name}
            </GrammarBookButton>
          ))}
      </GrammarBookContainer>
    </>
  );
}

export default GrammarPage;
