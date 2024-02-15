import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getGrammarBooks } from "../../modules/grammarbooks/grammarBooks";
import GrammarBooks from "../../components/grammar/GrammarBooks";
import {
  initializeIndex,
  clearIncorrectGrammarIds,
} from "../../modules/quiz/grammarQuiz";
import CircleSpinner from "../../components/CircleSpinner";
import NotFoundPage from "../../pages/NotFoundPage";
import {
  clickWrongGrammarSwitch,
  initializeWrongGrammarSwitch,
} from "../../modules/wrong-grammars/wrongGrammars";

const GrammarBooksContainer = () => {
  const loading = useSelector(
    (state) => state.grammarBooks.grammarBooks.loading
  );
  const data = useSelector((state) => state.grammarBooks.grammarBooks.data);
  const error = useSelector((state) => state.grammarBooks.grammarBooks.error);
  const isLoging = useSelector((state) => state.auth.isLoging);
  const dispatch = useDispatch();

  const handleWrongGrammarSwitch = () => {
    dispatch(clickWrongGrammarSwitch());
  };

  useEffect(() => {
    if (data) {
      dispatch(initializeIndex());
      dispatch(clearIncorrectGrammarIds());
      dispatch(initializeWrongGrammarSwitch());
      return;
    }
    dispatch(getGrammarBooks());
  }, [data, dispatch]);

  if (loading && !data) return <CircleSpinner />;
  if (error) return <NotFoundPage />;

  return (
    <>
      {data && (
        <GrammarBooks
          grammarBooks={data}
          isLoging={isLoging}
          onWrongGrammarSwitch={handleWrongGrammarSwitch}
        />
      )}
    </>
  );
};

export default GrammarBooksContainer;
