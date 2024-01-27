import LayoutContainer from "./containers/LayoutContainer";
import GrammarPage from "./pages/GrammarPage";
import { Navigate, Route, Routes } from "react-router-dom";
import NotFoundPage from "./pages/NotFoundPage";
import HomePage from "./pages/HomePage"
import LoginPage from "./pages/LoginPage";
import { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import TestPage from "./pages/TestPage";
import { userInfo } from "./modules/auth";

function App() {
  //const [loging,setLoging] = useState(sessionStorage.getItem('isLoging') || '');
  const { isLoging,user } = useSelector(state=>state.auth);
   const dispatch = useDispatch();

  useEffect(() => {
    if(isLoging){
      dispatch(userInfo());
    }
  }, [isLoging, dispatch]);

  console.log('user : =>'+user);
  console.log('is Login : '+sessionStorage.getItem('isLoging'));
  console.log('is Login2 : '+isLoging);
  console.log('user'+user);

  return (
    <Routes>
      <Route path="/" element={<LayoutContainer />}>
        <Route index element={<HomePage />} />
        <Route path="*" element={<NotFoundPage />} />
        <Route path="grammar" element={sessionStorage.getItem('isLoging') ? <GrammarPage /> : <Navigate to="/login" />} />
        <Route path="login" 
        element={sessionStorage.getItem('isLoging') === null || 
                 sessionStorage.getItem('isLoging') === "false" ? <LoginPage /> : <Navigate to="/" />} />
        <Route path="test" element={<TestPage />} />
      </Route>
    </Routes>
  );
}

export default App;
