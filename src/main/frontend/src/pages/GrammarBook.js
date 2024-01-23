import React, { useState, useEffect } from "react";
import { useParams } from "react-router-dom";

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
      name: "Present and Ongoing",
      grammars: [
        {
          id: 1,
          sentence: "Three cats are in the pet store. They are very cute.",
          grammarBookName: "Present and Ongoing",
        },
        {
          id: 2,
          sentence: "Today isn't Saturday. It's Sunday.",
          grammarBookName: "Present and Ongoing",
        },
        {
          id: 3,
          sentence: "Are those cooKies gook? Yes, they're delicious.",
          grammarBookName: "Present and Ongoing",
        },
        {
          id: 4,
          sentence: "Jonathan is late for school, but he's still sleeping.",
          grammarBookName: "Present and Ongoing",
        },
        {
          id: 5,
          sentence: "It's cloudy, but it's not snowing.",
          grammarBookName: "Present and Ongoing",
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
      <div>{grammarBook.name}</div>
      <ul>
        {grammarBook.grammars.map((grammar) => (
          <li key={grammar.id}>{grammar.sentence}</li>
        ))}
      </ul>
    </>
  );
};

export default GrammarBook;
