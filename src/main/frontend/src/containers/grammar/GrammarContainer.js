import Grammar from "../../components/grammar/Grammar";
import { useSelector, useDispatch } from "react-redux";
import {
  increaseIndex,
  initializeClickExampleAndSubmit,
  clickSubmitButton,
  addIncorrectGrammarId,
} from "../../modules/quiz/grammarQuiz";

const GrammarContainer = ({ grammars }) => {
  const currentGrammarIndex = useSelector(
    (state) => state.grammarQuiz.grammarIndex
  );
  const isExampleClicked = useSelector(
    (state) => state.grammarQuiz.isExampleClicked
  );
  const isSubmit = useSelector((state) => state.grammarQuiz.isSubmit);
  const isAnswer = useSelector((state) => state.grammarQuiz.isAnswer);
  const dispatch = useDispatch();

  const handleNextGrammar = () => {
    dispatch(clickSubmitButton());
    if (isSubmit) {
      dispatch(initializeClickExampleAndSubmit());
      dispatch(increaseIndex());
      if (!isAnswer) {
        dispatch(addIncorrectGrammarId(grammars[currentGrammarIndex].id));
      }
    }
    if (currentGrammarIndex >= grammars.length) {
      return;
    }
  };
  return (
    <Grammar
      currentGrammar={grammars[currentGrammarIndex]}
      onNextGrammar={handleNextGrammar}
      isExampleClicked={isExampleClicked}
      isAnswer={isAnswer}
      isSubmit={isSubmit}
    />
  );
};

export default GrammarContainer;
