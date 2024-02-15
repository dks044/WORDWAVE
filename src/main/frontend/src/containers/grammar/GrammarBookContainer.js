import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { createSelector } from "@reduxjs/toolkit";
import { getGrammarBook } from "../../modules/grammarbooks/grammarBooks";
import { getUserWrongGrammarBook } from "../../modules/wrong-grammars/wrongGrammars";
import GrammarBook from "../../components/grammar/GrammarBook";
import CircleSpinner from "../../components/CircleSpinner";
import NotFoundPage from "../../pages/NotFoundPage";

const selectLoading = createSelector(
  [
    (state) => state.grammarBooks.grammarBook.loading,
    (state) => state.wrongGrammars.userWrongGrammarBook.loading,
    (state) => state.wrongGrammars.isClickWrongGrammarSwitch,
  ],
  (
    grammarBookLoading,
    userWrongGrammarBookLoading,
    isClickWrongGrammarSwitch
  ) =>
    isClickWrongGrammarSwitch ? userWrongGrammarBookLoading : grammarBookLoading
);

const selectData = createSelector(
  [
    (state) => state.grammarBooks.grammarBook.data,
    (state) => state.wrongGrammars.userWrongGrammarBook.data,
    (state) => state.wrongGrammars.isClickWrongGrammarSwitch,
  ],
  (grammarBookData, userWrongGrammarBookData, isClickWrongGrammarSwitch) =>
    isClickWrongGrammarSwitch ? userWrongGrammarBookData : grammarBookData
);

const selectError = createSelector(
  [
    (state) => state.grammarBooks.grammarBook.error,
    (state) => state.wrongGrammars.userWrongGrammarBook.error,
    (state) => state.wrongGrammars.isClickWrongGrammarSwitch,
  ],
  (grammarBookError, userWrongGrammarBookError, isClickWrongGrammarSwitch) =>
    isClickWrongGrammarSwitch ? userWrongGrammarBookError : grammarBookError
);

const GrammarBookContainer = ({ grammarBookName }) => {
  const loading = useSelector(selectLoading);
  const data = useSelector(selectData);
  const error = useSelector(selectError);
  const grammarIndex = useSelector((state) => state.grammarQuiz.grammarIndex);
  const isClickWrongGrammarSwitch = useSelector(
    (state) => state.wrongGrammars.isClickWrongGrammarSwitch
  );
  const userName = useSelector((state) => state.auth.user.userName);
  const dispatch = useDispatch();

  useEffect(() => {
    if (isClickWrongGrammarSwitch) {
      dispatch(
        getUserWrongGrammarBook({
          userName: userName,
          grammarBookName: grammarBookName,
        })
      );
    } else {
      dispatch(getGrammarBook(grammarBookName));
    }
  }, [isClickWrongGrammarSwitch, userName, grammarBookName, dispatch]);

  if (loading && !data) return <CircleSpinner />;
  if (error) return <NotFoundPage />;

  const progressRate = (grammarIndex / data.grammarIds.length) * 100;

  return (
    <>
      {data && <GrammarBook grammarBook={data} progressRate={progressRate} />}
    </>
  );
};

export default GrammarBookContainer;
