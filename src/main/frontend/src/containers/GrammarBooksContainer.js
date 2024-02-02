import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getGrammarBooks } from "../modules/grammarbooks/grammarBooks";
import GrammarBooks from "../components/GrammarBooks";
import {
  initializeIndex,
  clearIncorrectGrammarIds,
} from "../modules/quiz/grammarQuiz";
import { Spinner } from "react-bootstrap";

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
      dispatch(clearIncorrectGrammarIds());
      return;
    }
    dispatch(getGrammarBooks());
  }, [data, dispatch]);

  if (error) return <div>{error.message}</div>;

  return (
    <>
      {data ? (
        <GrammarBooks grammarBooks={data} />
      ) : (
        <Spinner animation="border" />
      )}
    </>
  );
};

export default GrammarBooksContainer;
