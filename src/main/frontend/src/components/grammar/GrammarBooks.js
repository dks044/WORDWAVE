import { Link } from "react-router-dom";
import { Button } from "react-bootstrap";
import styled from "styled-components";

const GrammarBookLink = styled(Link)`
  //스타일
  text-decoration: none;
  color: white;
  line-height: 50px;
  margin: 1px 1px;
  //크기
  width: 100%;
  height: 100%;
  //위치
  position: absolute;
  bottom: 0.05px;
  right: 0.05px;
`;

const ListItem = styled(Button)`
  //스타일
  background-color: #2086ff;
  margin: 10px 10px;
  border-radius: 5px;
  //크기
  width: 200px;
  height: 50px;
  //위치
  position: relative;
`;

const Lists = styled.div`
  //스타일
  display: flex;
  text-align: center;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  //위치
  position: absolute;
  top: 20%;
  left: 50%;
  transform: translateX(-50%);
`;

const GrammarBooks = ({ grammarBooks }) => {
  return (
    <>
      <Lists>
        {grammarBooks.map((grammarBook) => (
          <ListItem key={grammarBook.id} size="lg">
            <GrammarBookLink to={`/grammarbooks/${grammarBook.name}`}>
              {grammarBook.name}
            </GrammarBookLink>
          </ListItem>
        ))}
      </Lists>
    </>
  );
};

export default GrammarBooks;
