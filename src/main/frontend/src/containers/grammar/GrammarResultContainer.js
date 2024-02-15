import { useEffect } from "react";
import GrammarResult from "../../components/grammar/GrammarResult";
import { useSelector, useDispatch } from "react-redux";
import { saveUserWrongGrammars } from "../../modules/wrong-grammars/wrongGrammars";

const GrammarResultContainer = ({ grammarIds, grammarBookName }) => {
  const wrongGrammarIds = useSelector(
    (state) => state.grammarQuiz.incorrectGrammarIds
  );
  const grammarIndex = useSelector((state) => state.grammarQuiz.grammarIndex);
  const user = useSelector((state) => state.auth.user);
  const dispatch = useDispatch();

  let now = new Date();
  let year = now.getFullYear();
  let month = ("0" + (now.getMonth() + 1)).slice(-2);
  let day = ("0" + now.getDate()).slice(-2);
  let hours = ("0" + now.getHours()).slice(-2);
  let minutes = ("0" + now.getMinutes()).slice(-2);
  let seconds = ("0" + now.getSeconds()).slice(-2);
  let lastTryTime =
    year +
    "-" +
    month +
    "-" +
    day +
    "T" +
    hours +
    ":" +
    minutes +
    ":" +
    seconds;

  useEffect(() => {
    if (grammarIds.length === grammarIndex) {
      const wrongGrammarsDto = {
        userName: user.userName,
        wrongGrammarIds: wrongGrammarIds,
        grammarBookName: grammarBookName,
        lastTryTime: lastTryTime,
      };
      dispatch(saveUserWrongGrammars(wrongGrammarsDto));
    }
  }, [
    dispatch,
    grammarIds,
    grammarIndex,
    user.userName,
    wrongGrammarIds,
    grammarBookName,
    lastTryTime,
  ]);

  return (
    <>
      {grammarIds.length === grammarIndex && (
        <GrammarResult
          wrongGrammarsSize={wrongGrammarIds.length}
          grammarsSize={grammarIds.length}
        />
      )}
    </>
  );
};

export default GrammarResultContainer;
