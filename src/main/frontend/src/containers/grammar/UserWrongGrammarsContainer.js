import { useDispatch, useSelector } from "react-redux";
import { getUserWrongGrammars } from "../../modules/wrong-grammars/wrongGrammars";
import { getGrammarNumOfAllGrammarBooks } from "../../modules/grammarbooks/grammarBooks";
import { useEffect } from "react";
import CircleSpinner from "../../components/CircleSpinner";
import UserWrongGrammars from "../../components/grammar/UserWrongGrammars";

const UserWrongGrammarsContainer = () => {
  const loadingWrongGrammars = useSelector(
    (state) => state.wrongGrammars.userWrongGrammars.loading
  );
  const dataWrongGrammars = useSelector(
    (state) => state.wrongGrammars.userWrongGrammars.data
  );
  const errorWrongGrammars = useSelector(
    (state) => state.wrongGrammars.userWrongGrammars.error
  );
  const loadingGrammarNums = useSelector(
    (state) => state.grammarBooks.grammarNumOfAllGrammarBooks.loading
  );
  const dataGrammarNums = useSelector(
    (state) => state.grammarBooks.grammarNumOfAllGrammarBooks.data
  );
  const errorGrammarNums = useSelector(
    (state) => state.grammarBooks.grammarNumOfAllGrammarBooks.error
  );

  const user = useSelector((state) => state.auth.user);
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(getUserWrongGrammars(user.userName));
    dispatch(getGrammarNumOfAllGrammarBooks());
  }, [dispatch, user.userName]);

  const userGrammarBookData = [];

  if (dataWrongGrammars && dataGrammarNums) {
    for (let grammarBook of dataGrammarNums) {
      userGrammarBookData.push({
        id: grammarBook.id,
        grammarBookName: grammarBook.name,
        grammarNum: grammarBook.grammarNum,
        wrongNum: findWrongGrammarNum(grammarBook.name),
      });
    }
  }

  function findWrongGrammarNum(name) {
    let cnt = 0;
    for (let wrongGrammar of dataWrongGrammars.wrongGrammars) {
      if (wrongGrammar.grammarBookName === name) {
        cnt++;
      }
    }
    return cnt;
  }

  console.log(userGrammarBookData);
  if (
    (loadingWrongGrammars || loadingGrammarNums) &&
    !dataWrongGrammars &&
    !dataGrammarNums
  )
    return <CircleSpinner />;
  if (errorWrongGrammars || errorGrammarNums)
    return (
      <div>
        {errorWrongGrammars}, {errorGrammarNums}
      </div>
    );

  return (
    <>
      {dataWrongGrammars.wrongGrammars && (
        <UserWrongGrammars userGrammarBookData={userGrammarBookData} />
      )}
    </>
  );
};

export default UserWrongGrammarsContainer;
