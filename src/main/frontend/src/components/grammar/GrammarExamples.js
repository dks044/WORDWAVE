import { ButtonGroup, ToggleButton } from "react-bootstrap";
import styled from "styled-components";

const ExampleGroup = styled(ButtonGroup)`
  //크기
  width: 80%;
  //위치
  top: 60%;
  left: 50%;
  transform: translateX(-50%);
`;

const ExampleButton = styled(ToggleButton)`
  border-color: #63e6be;
  font-size: 30px;
  background-color: ${(props) =>
    props.disabled && props.isAnswer && "#63e6be"} !important;
  background-color: ${(props) =>
    props.disabled && !props.isAnswer && "#E83B46"} !important;
`;

const GrammarExamples = ({ grammarExamples, onClickExample, isSubmit }) => {
  return (
    <ExampleGroup>
      {grammarExamples.map((ge, idx) => (
        <ExampleButton
          key={idx}
          id={`ge-${idx}`}
          variant={isSubmit ? "secondary" : "outline-success"}
          name="grammarExample"
          isAnswer={ge.isAnswer}
          onClick={() => onClickExample(ge.isAnswer)}
          disabled={isSubmit}
        >
          {ge.example}
        </ExampleButton>
      ))}
    </ExampleGroup>
  );
};

export default GrammarExamples;
