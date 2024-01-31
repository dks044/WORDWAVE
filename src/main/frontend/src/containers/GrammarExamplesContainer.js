import GrammarExamples from "../components/GrammarExamples";
import { useDispatch, useSelector } from "react-redux";
import { useCallback, useEffect } from "react";
import { clickExample, setAnswer } from "../modules/quiz/grammarQuiz";

const GrammarExamplesContainer = ({ grammarExamples }) => {
  const isSubmit = useSelector((state) => state.grammarQuiz.isSubmit);
  const dispatch = useDispatch();
  const answer = grammarExamples.find((ge) => ge.isAnswer === true).example;

  useEffect(() => {
    dispatch(setAnswer(answer));
  }, [dispatch, answer]);

  const onClickGrammarExample = useCallback(
    (isAnswer) => {
      dispatch(clickExample(isAnswer));
    },
    [dispatch]
  );

  return (
    <GrammarExamples
      grammarExamples={grammarExamples}
      onClickExample={onClickGrammarExample}
      isSubmit={isSubmit}
    />
  );
};

export default GrammarExamplesContainer;
