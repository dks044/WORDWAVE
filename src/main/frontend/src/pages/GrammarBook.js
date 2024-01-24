import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import styled from "styled-components";
import GrammarQuiz from "./GrammarQuiz";

const BookName = styled.div`
  //스타일
  text-align: center;
  margin: 10px 0;
`;

const GrammarBook = () => {
  const { id } = useParams();
  const [grammarBook, setGrammarBook] = useState(null);

  useEffect(() => {
    // fetch(`/api/grammarbook/${id}`, { method: "GET" })
    //   .then((response) => response.json())
    //   .then((grammarBook) => setGrammarBook(grammarBook))
    //   .catch((error) => console.error("Error:", error));

    //Use only during development
    const testGrammarBook = {
      id: 1,
      name: "현재와 현재진행",
      grammars: [
        {
          id: 1,
          sentence: "Three cats are in the pet store. They are very cute.",
          grammarBookName: "현재와 현재진행",
        },
        {
          id: 2,
          sentence: "Today isn't Saturday. It's Sunday.",
          grammarBookName: "현재와 현재진행",
        },
        {
          id: 3,
          sentence: "Are those cooKies gook? Yes, they're delicious.",
          grammarBookName: "현재와 현재진행",
        },
        {
          id: 4,
          sentence: "Jonathan is late for school, but he's still sleeping.",
          grammarBookName: "현재와 현재진행",
        },
        {
          id: 5,
          sentence: "It's cloudy, but it's not snowing.",
          grammarBookName: "현재와 현재진행",
        },
      ],
    };
    setGrammarBook(testGrammarBook);
  }, [id]);

  if (!grammarBook) {
    return <div>Loading...</div>;
  }

  return (
    <>
      <BookName>{grammarBook.name}</BookName>
      <GrammarQuiz grammarBook={grammarBook}></GrammarQuiz>
    </>
  );
};

export default GrammarBook;
