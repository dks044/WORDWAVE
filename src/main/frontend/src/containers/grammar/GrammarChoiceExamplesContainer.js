import GrammarChoiceExamples from "../../components/grammar/GrammarChoiceExamples";
import { useDispatch, useSelector } from "react-redux";
import { useCallback } from "react";
import { clickExample } from "../../modules/quiz/grammarQuiz";

const GrammarChoiceExamplesContainer = ({ grammarExamples }) => {
  const isSubmit = useSelector((state) => state.grammarQuiz.isSubmit);
  const dispatch = useDispatch();

  const onClickGrammarChoiceExamples = useCallback(
    (isAnswer) => {
      dispatch(clickExample(isAnswer));
    },
    [dispatch]
  );

  return (
    <GrammarChoiceExamples
      grammarExamples={grammarExamples}
      onClickExample={onClickGrammarChoiceExamples}
      isSubmit={isSubmit}
    />
  );
};

export default GrammarChoiceExamplesContainer;
