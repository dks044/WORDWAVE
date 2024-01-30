import GrammarBookContainer from "../containers/GrammarBookContainer";
import { useParams } from "react-router-dom";

const GrammarBookPage = () => {
  const { id } = useParams();

  return (
    <>
      <GrammarBookContainer grammarBookId={parseInt(id, 10)} />
    </>
  );
};

export default GrammarBookPage;
