import Layout from "./components/Layout";
import { Route, Routes } from "react-router-dom";
import Home from "./pages/Home";
import NotFound from "./pages/NotFound";
import GrammarBooksPage from "./pages/GrammarBooksPage";
import GrammarBookPage from "./pages/GrammarBookPage";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Layout />}>
        <Route index element={<Home />} />
        <Route path="*" element={<NotFound />} />
        <Route path="grammarbooks" element={<GrammarBooksPage />} />
        <Route path="grammarbook/:id" element={<GrammarBookPage />} />
      </Route>
    </Routes>
  );
}

export default App;
