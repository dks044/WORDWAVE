import { Link } from "react-router-dom";
import { Button, Form } from "react-bootstrap";
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

const CheckCustom = styled(Form.Check)`
  //크기
  width: 50px;
  //위치
  position: absolute;
  left: 50%;
  transform: translateX(-30%);
  top: 14%;
`;

const Bubble = styled.div`
  //스타일
  background: #484848;
  color: white;
  border-radius: 5px;
  padding: 7px 12.8px;
  //크기
  width: 205px;
  height: 60px;
  //위치
  position: absolute;
  top: 12%;
  right: 10px;

  &:after {
    content: "";
    position: absolute;
    left: 10px;
    top: 50%;
    width: 0;
    height: 0;
    border: 20px solid transparent;
    border-right-color: #484848;
    border-left: 0;
    margin-top: -20px;
    margin-left: -20px;
  }
`;

const GrammarBooks = ({ grammarBooks, isLoging, onWrongGrammarSwitch }) => {
  return (
    <>
      <Bubble>버튼을 클릭하면 틀린 문제만 풀 수 있어요!</Bubble>
      <Lists>
        {grammarBooks.map((grammarBook) => (
          <ListItem key={grammarBook.id} size="lg">
            <GrammarBookLink to={`/grammarbooks/${grammarBook.name}`}>
              {grammarBook.name}
            </GrammarBookLink>
          </ListItem>
        ))}
      </Lists>
      {isLoging && (
        <CheckCustom
          type="switch"
          id="custom-switch"
          onClick={onWrongGrammarSwitch}
        />
      )}
    </>
  );
};

export default GrammarBooks;
