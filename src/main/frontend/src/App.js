import LayoutContainer from "./containers/LayoutContainer";
import GrammarPage from "./pages/GrammarPage";
import { Navigate, Route, Routes } from "react-router-dom";
import NotFoundPage from "./pages/NotFoundPage";
import HomePage from "./pages/HomePage"
import LoginPage from "./pages/LoginPage";
import { useEffect, useState } from "react";
import { useSelector } from "react-redux";

function App() {
  const [loging,setLoging] = useState(sessionStorage.getItem('isLoging') || '');
  const { isLoging } = useSelector(state=>state.auth);

  useEffect(() => {
    if(isLoging) return setLoging(true);
  }, [loging,isLoging]);

  console.log('is Login : '+sessionStorage.getItem('isLoging'));

  return (
    <Routes>
      <Route path="/" element={<LayoutContainer />}>
        <Route index element={<HomePage />} />
        <Route path="*" element={<NotFoundPage />} />
        <Route path="grammar" element={sessionStorage.getItem('isLoging') ? <GrammarPage /> : <Navigate to="/login" />} />
        <Route path="login" 
        element={sessionStorage.getItem('isLoging') === null || 
                 sessionStorage.getItem('isLoging') === "false" ? <LoginPage /> : <Navigate to="/" />} />
      </Route>
    </Routes>
  );
}

export default App;
