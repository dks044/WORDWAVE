import axios from "axios";
import Layout from "./containers/Layout";
import GrammarPage from "./pages/GrammarPage";
import { Route, Routes } from "react-router-dom";
import NotFoundPage from "./pages/NotFoundPage";
import HomePage from "./pages/HomePage"

function App() {
  return (
    <Routes>
      <Route path="/" element={<Layout />}>
        <Route index element={<HomePage />} />
        <Route path="*" element={<NotFoundPage />} />
        <Route path="grammar" element={<GrammarPage />} />
      </Route>
    </Routes>
  );
}

export default App;
