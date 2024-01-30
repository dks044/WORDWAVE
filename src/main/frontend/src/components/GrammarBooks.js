import { Link } from "react-router-dom";

const GrammarBooks = ({ grammarBooks }) => {
  return (
    <ul>
      {grammarBooks.map((grammarBook) => (
        <li key={grammarBook.id}>
          <Link to={`/grammarbook/${grammarBook.id}`}>{grammarBook.name}</Link>
        </li>
      ))}
      <div></div>
    </ul>
  );
};

export default GrammarBooks;
