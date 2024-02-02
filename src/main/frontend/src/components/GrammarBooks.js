import { Link } from "react-router-dom";
import styled from "styled-components";

const GrammarBookLink = styled(Link)`
  //스타일
  text-decoration: none;
  color: white;
  align-items: center;
  justify-content: center;
  margin: 1px 1px;
  //크기
  width: 100%;
  height: 100%;
  //위치
  position: absolute;
  display: flex;
`;

const ListItem = styled.div`
  //스타일
  background-color: #2086ff;
  margin: 10px 10px;
  border-radius: 5px;
  box-shadow: 0 4px 5px rgba(0, 0, 0, 0.6);
  //크기
  width: 200px;
  height: 50px;
  //위치
  position: relative;
  &:active {
    box-shadow: none;
  }
`;

const Lists = styled.div`
  //스타일
  display: flex;
  text-align: center;
  align-items: center;
  justify-content: center;
  flex-direction: column;
`;

const GrammarBooks = ({ grammarBooks }) => {
  return (
    <>
      <Lists>
        {grammarBooks.map((grammarBook) => (
          <ListItem key={grammarBook.id}>
            <GrammarBookLink to={`/grammarbooks/${grammarBook.id}`}>
              {grammarBook.name}
            </GrammarBookLink>
          </ListItem>
        ))}
      </Lists>
    </>
  );
};

export default GrammarBooks;
