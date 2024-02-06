import GrammarExamples from "../../components/grammar/GrammarExamples";
import { useDispatch, useSelector } from "react-redux";
import { useCallback } from "react";
import { clickExample } from "../../modules/quiz/grammarQuiz";

const GrammarExamplesContainer = ({ grammarExamples }) => {
  const isSubmit = useSelector((state) => state.grammarQuiz.isSubmit);
  const dispatch = useDispatch();

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
