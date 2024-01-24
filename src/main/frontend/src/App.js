import React, { useEffect, useState } from "react";
import axios from "axios";
import Layout from "./components/Layout";
import { Route, Routes } from "react-router-dom";
import Home from "./pages/Home";
import GrammarPage from "./pages/GrammarPage";
import NotFound from "./pages/NotFound";
import GrammarBook from "./pages/GrammarBook";
import styled, { css, keyframes } from "styled-components";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Layout />}>
        <Route index element={<Home />} />
        <Route path="*" element={<NotFound />} />
        <Route path="grammarbook" element={<GrammarPage />} />
        <Route path="grammarbook/:id" element={<GrammarBook />} />
      </Route>
    </Routes>
  );
}

export default App;
