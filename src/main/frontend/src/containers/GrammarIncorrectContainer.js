import GrammarIncorrect from "../components/GrammarIncorrect";
import { useSelector } from "react-redux";

const GrammarIncorrectContainer = ({ grammars }) => {
  const incorrectGrammarIds = useSelector(
    (state) => state.grammarQuiz.incorrectGrammarIds
  );
  const grammarIndex = useSelector((state) => state.grammarQuiz.grammarIndex);

  const incorrectGrammars = grammars.filter((grammar) =>
    incorrectGrammarIds.find(
      (incorrectGrammarId) => grammar.id === incorrectGrammarId
    )
  );
  //마지막 grammar까지 오면 보여주기
  return (
    <>
      {grammars.length === grammarIndex && (
        <GrammarIncorrect incorrectGrammars={incorrectGrammars} />
      )}
    </>
  );
};

export default GrammarIncorrectContainer;
