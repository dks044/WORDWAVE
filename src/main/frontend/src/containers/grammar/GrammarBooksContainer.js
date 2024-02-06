import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getGrammarBooks } from "../../modules/grammarbooks/grammarBooks";
import GrammarBooks from "../../components/grammar/GrammarBooks";
import {
  initializeIndex,
  clearIncorrectGrammarIds,
} from "../../modules/quiz/grammarQuiz";
import CircleSpinner from "../../components/CircleSpinner";

const GrammarBooksContainer = () => {
  const loading = useSelector(
    (state) => state.grammarBooks.grammarBooks.loading
  );
  const data = useSelector((state) => state.grammarBooks.grammarBooks.data);
  const error = useSelector((state) => state.grammarBooks.grammarBooks.error);
  const dispatch = useDispatch();

  //각 GrammarBook마다 오답 문제만 나오는 체크 버튼 추가하기
  //이 체크 버튼은 isLoging=true여야 보임

  useEffect(() => {
    if (data) {
      dispatch(initializeIndex());
      dispatch(clearIncorrectGrammarIds());
      return;
    }
    dispatch(getGrammarBooks());
  }, [data, dispatch]);

  if (loading && !data) return <CircleSpinner />;
  if (error) return <div>{error.message}</div>;

  return <>{data && <GrammarBooks grammarBooks={data} />}</>;
};

export default GrammarBooksContainer;
