import LayoutContainer from "./containers/LayoutContainer";
import GrammarPage from "./pages/GrammarPage";
import { Navigate, Route, Routes } from "react-router-dom";
import NotFoundPage from "./pages/NotFoundPage";
import HomePage from "./pages/HomePage"
import LoginPage from "./pages/LoginPage";
import TestPage from "./pages/TestPage";
import { useDispatch, useSelector } from "react-redux";
import { useEffect } from "react";
import { isLoggedIn } from "./modules/auth";

function App() {
  const { isLoging } = useSelector(state=>state.auth);
  console.log(isLoging);

  const dispatch = useDispatch();

  useEffect(() => {
      console.log('check the user..');
      dispatch(isLoggedIn());
    
  }, [dispatch,isLoging]);

  return (
    <Routes>
      <Route path="/" element={<LayoutContainer />}>
        <Route index element={<HomePage />} />
        <Route path="*" element={<NotFoundPage />} />
        <Route path="grammar" element={isLoging ? <GrammarPage /> : <Navigate to="/login" />} />
        <Route path="login" 
        element={isLoging === false ? <LoginPage /> : <Navigate to="/" />} />
        <Route path="test" element={<TestPage />} />
      </Route>
    </Routes>
  );
}

export default App;