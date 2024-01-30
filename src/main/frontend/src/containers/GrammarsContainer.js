import Grammars from "../components/Grammars";
import { useSelector, useDispatch } from "react-redux";
import { initializeIndex, increaseIndex } from "../modules/quiz/grammarQuiz";

const GrammarsContainer = ({ grammars }) => {
  const currentGrammarIndex = useSelector(
    (state) => state.grammarQuiz.grammarIndex
  );
  const dispatch = useDispatch();

  const handleNextGrammar = () => {
    currentGrammarIndex >= grammars.length
      ? dispatch(initializeIndex())
      : dispatch(increaseIndex());
  };
  const isLastGrammar = currentGrammarIndex >= grammars.length - 1;
  return (
    <Grammars
      currentGrammar={grammars[currentGrammarIndex]}
      onNextGrammar={handleNextGrammar}
      disableNext={isLastGrammar}
    />
  );
};

export default GrammarsContainer;
