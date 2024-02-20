import GrammarChoice from "../../components/grammar/GrammarChoice";
import { getGrammarById } from "../../modules/grammars/grammars";
import { useSelector, useDispatch } from "react-redux";
import {
  increaseIndex,
  initializeClickExampleAndSubmitAndAnswer,
  clickSubmitButton,
  addIncorrectGrammarId,
} from "../../modules/quiz/grammarQuiz";
import CircleSpinner from "../../components/CircleSpinner";
import NotFoundPage from "../../pages/NotFoundPage";
import { useEffect } from "react";
import GrammarWrite from "../../components/grammar/GrammarWrite";

const GrammarContainer = ({ grammarIds }) => {
  const currentGrammarIndex = useSelector(
    (state) => state.grammarQuiz.grammarIndex
  );
  const isExampleClicked = useSelector(
    (state) => state.grammarQuiz.isExampleClicked
  );
  const isSubmit = useSelector((state) => state.grammarQuiz.isSubmit);
  const isAnswer = useSelector((state) => state.grammarQuiz.isAnswer);
  const loading = useSelector((state) => state.grammars.grammar.loading);
  const data = useSelector((state) => state.grammars.grammar.data);
  const error = useSelector((state) => state.grammars.grammar.error);
  const isChoice = useSelector((state) => state.grammars.isChoice);
  const dispatch = useDispatch();

  const handleNextGrammar = () => {
    dispatch(clickSubmitButton());
    if (isSubmit) {
      if (!isAnswer) {
        dispatch(addIncorrectGrammarId(grammarIds[currentGrammarIndex]));
      }
      dispatch(increaseIndex());
    }
  };

  useEffect(() => {
    dispatch(initializeClickExampleAndSubmitAndAnswer());
    if (currentGrammarIndex < grammarIds.length) {
      dispatch(
        getGrammarById({
          id: grammarIds[currentGrammarIndex],
          isChoice: isChoice,
        })
      );
    }
  }, [dispatch, grammarIds, currentGrammarIndex, isChoice]);

  if (loading || !data) return <CircleSpinner />;
  if (error) return <NotFoundPage />;

  return (
    <>
      {isChoice ? (
        <GrammarChoice
          currentGrammar={data}
          onNextGrammar={handleNextGrammar}
          isExampleClicked={isExampleClicked}
          isAnswer={isAnswer}
          isSubmit={isSubmit}
        />
      ) : (
        <GrammarWrite currentGrammar={data} />
      )}
    </>
  );
};

export default GrammarContainer;
