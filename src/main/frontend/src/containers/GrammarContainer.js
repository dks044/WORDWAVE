import Grammar from "../components/Grammar";
import { useSelector, useDispatch } from "react-redux";
import {
  initializeIndex,
  increaseIndex,
  initializeClickExampleAndSubmit,
  clickSubmitButton,
} from "../modules/quiz/grammarQuiz";

const GrammarContainer = ({ grammars }) => {
  const currentGrammarIndex = useSelector(
    (state) => state.grammarQuiz.grammarIndex
  );
  const isExampleClicked = useSelector(
    (state) => state.grammarQuiz.isExampleClicked
  );
  const isSubmit = useSelector((state) => state.grammarQuiz.isSubmit);
  const answer = useSelector((state) => state.grammarQuiz.answer);
  const isAnswer = useSelector((state) => state.grammarQuiz.isAnswer);
  const dispatch = useDispatch();

  const handleNextGrammar = () => {
    dispatch(clickSubmitButton());
    if (isSubmit) {
      dispatch(initializeClickExampleAndSubmit());
      currentGrammarIndex >= grammars.length - 1
        ? dispatch(initializeIndex())
        : dispatch(increaseIndex());
    }
  };
  return (
    <Grammar
      currentGrammar={grammars[currentGrammarIndex]}
      onNextGrammar={handleNextGrammar}
      isExampleClicked={isExampleClicked}
      isAnswer={isAnswer}
      isSubmit={isSubmit}
      answer={answer}
    />
  );
};

export default GrammarContainer;
