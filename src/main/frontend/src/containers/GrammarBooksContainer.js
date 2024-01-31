import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getGrammarBooks } from "../modules/grammarbooks/grammarBooks";
import GrammarBooks from "../components/GrammarBooks";
import { initializeIndex } from "../modules/quiz/grammarQuiz";

const GrammarBooksContainer = () => {
  const loading = useSelector(
    (state) => state.grammarBooks.grammarBooks.loading
  );
  const data = useSelector((state) => state.grammarBooks.grammarBooks.data);
  const error = useSelector((state) => state.grammarBooks.grammarBooks.error);
  const dispatch = useDispatch();

  useEffect(() => {
    if (data) {
      dispatch(initializeIndex());
      return;
    }
    dispatch(getGrammarBooks());
  }, [data, dispatch]);

  if (loading && !data) return <div>loading...</div>;
  if (error) return <div>{error.message}</div>;

  return <>{data && <GrammarBooks grammarBooks={data} />}</>;
};

export default GrammarBooksContainer;
