import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { getGrammarBook } from "../modules/grammarbooks/grammarBooks";
import GrammarIncorrectContainer from "./GrammarIncorrectContainer";
import GrammarBook from "../components/GrammarBook";

const GrammarBookContainer = ({ grammarBookId }) => {
  const loading = useSelector(
    (state) => state.grammarBooks.grammarBook.loading
  );
  const data = useSelector((state) => state.grammarBooks.grammarBook.data);
  const error = useSelector((state) => state.grammarBooks.grammarBook.error);

  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(getGrammarBook(grammarBookId));
  }, [grammarBookId, dispatch]);

  if (loading && !data) return <div>loading...</div>;
  if (error) return <div>error!!</div>;

  return (
    <>
      {data && (
        <>
          <GrammarBook grammarBook={data} />
          <GrammarIncorrectContainer grammars={data.grammars} />
        </>
      )}
    </>
  );
};

export default GrammarBookContainer;
