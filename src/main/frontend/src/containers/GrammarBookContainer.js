import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getGrammarBook } from "../modules/grammarbooks/grammarBooks";
import GrammarResultContainer from "./GrammarResultContainer";
import GrammarBook from "../components/GrammarBook";

const GrammarBookContainer = ({ grammarBookId }) => {
  const loading = useSelector(
    (state) => state.grammarBooks.grammarBook.loading
  );
  const data = useSelector((state) => state.grammarBooks.grammarBook.data);
  const error = useSelector((state) => state.grammarBooks.grammarBook.error);
  const grammarIndex = useSelector((state) => state.grammarQuiz.grammarIndex);
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(getGrammarBook(grammarBookId));
  }, [grammarBookId, dispatch]);

  if (loading && !data) return <div>loading...</div>;
  if (error) return <div>error!!</div>;

  const progressRate = (grammarIndex / data.grammars.length) * 100;

  return (
    <>
      {data && (
        <>
          <GrammarBook grammarBook={data} progressRate={progressRate} />
          <GrammarResultContainer grammars={data.grammars} />
        </>
      )}
    </>
  );
};

export default GrammarBookContainer;
