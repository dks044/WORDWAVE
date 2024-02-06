import GrammarBookContainer from "../../containers/grammar/GrammarBookContainer";
import { useParams } from "react-router-dom";

const GrammarBookPage = () => {
  const { grammarBookName } = useParams();

  return (
    <>
      <GrammarBookContainer grammarBookId={grammarBookName} />
    </>
  );
};

export default GrammarBookPage;
