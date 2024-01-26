import LayoutContainer from "./containers/LayoutContainer";
import GrammarPage from "./pages/GrammarPage";
import { Navigate, Route, Routes } from "react-router-dom";
import NotFoundPage from "./pages/NotFoundPage";
import HomePage from "./pages/HomePage"
import LoginPage from "./pages/LoginPage";
import { useDispatch, useSelector } from "react-redux";
import { useEffect } from "react";
import { isLoggenIn } from "./modules/auth";

function App() {
  //인증된 사용자인지 검사(토큰검사)
  const { data} = useSelector(
    state => state.auth.auth
  ) || {
    loading: false,
    data: null,
    error: null
  };
  const dispatch = useDispatch();
  useEffect(() => {
    if (data) return;
    dispatch(isLoggenIn());
  }, [data,dispatch]);;


  return (
    <Routes>
      <Route path="/" element={<LayoutContainer />}>
        <Route index element={<HomePage />} />
        <Route path="*" element={<NotFoundPage />} />
        <Route path="grammar" element={data ? <GrammarPage /> : <Navigate to="/login" />} />
        <Route path="login" element={<LoginPage />} />
      </Route>
    </Routes>
  );
}

export default App;
