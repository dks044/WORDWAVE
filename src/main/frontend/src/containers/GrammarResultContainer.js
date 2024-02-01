import GrammarResult from "../components/GrammarResult";
import { useSelector } from "react-redux";

const GrammarResultContainer = ({ grammars }) => {
  const incorrectGrammarIds = useSelector(
    (state) => state.grammarQuiz.incorrectGrammarIds
  );
  const grammarIndex = useSelector((state) => state.grammarQuiz.grammarIndex);

  return (
    <>
      {grammars.length === grammarIndex && (
        <GrammarResult
          correctRate={
            ((grammars.length - incorrectGrammarIds.length) / grammars.length) *
            100
          }
        />
      )}
    </>
  );
};

export default GrammarResultContainer;
