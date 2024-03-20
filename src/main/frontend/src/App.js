import LayoutContainer from "./containers/LayoutContainer";
import { Navigate, Route, Routes } from "react-router-dom";
import NotFoundPage from "./pages/NotFoundPage";
import HomePage from "./pages/HomePage"
import LoginPage from "./pages/LoginPage";
import SignUpPage from "./pages/SignUpPage";
import VocaBooksPage from "./pages/voca/VocaBooksPage";
import GrammarBooksPage from "./pages/grammar/GrammarBooksPage";
import { useDispatch, useSelector } from "react-redux";
import { useEffect, useState } from "react";
import { isLoggedIn, logout } from "./modules/auth";
import { ToastContainer } from "react-bootstrap";   
import ToastComponent from "./components/ToastComponent";
import { closePopup } from "./modules/popup";
import MyPage from "./pages/MyPage";
import VocaBookPage from "./pages/voca/VocaBookPage";
import VocaPage from "./pages/voca/VocaPage";


function App() {
  //authenticated
  const { isLoging } = useSelector(state=>state.auth);
  console.log(isLoging);
  const {isOpen, message} = useSelector(state=>state.popup);
  const dispatch = useDispatch();
  console.log(isLoging);

  useEffect(() => {
      console.log('check the user..');
      dispatch(isLoggedIn());
  }, [dispatch,isLoging]);

  //authenticated
  //toast
  const [show, setShow] = useState(false);
  const toggleShow = () => setShow(!show);
  useEffect(() => {
    if(isOpen) {
      setShow(true);
    }
    if(!isOpen){
      setShow(false);
    }
  },[isOpen]);
  
  useEffect(() => {
    if(!show) {
      dispatch(closePopup());
    }
  }, [show, dispatch]);

  return (
    <>
      <ToastContainer  position='static' style={{ zIndex: 5, top: '59%', left: '50%', transform: 'translate(-50%, -50%)' }}>
        <ToastComponent  show={show} onClose={() => {
          dispatch(closePopup());
          setShow(false);
        }} message={message}/>
      </ToastContainer>
      <Routes>
        <Route path="/" element={<LayoutContainer />}>
          <Route index element={<HomePage />} />
          <Route path="*" element={<NotFoundPage />} />
          <Route path="mypage" element={isLoging ? <MyPage /> : <Navigate to="/login" />} />
          <Route path="login" 
          element={isLoging === false ? <LoginPage /> : <Navigate to="/" />} />
          <Route path="signup" 
          element={isLoging === false ? <SignUpPage /> : <Navigate to="/" />} />
          {/* VOCA */}
          <Route path="vocabooks" 
          element={isLoging ? <VocaBooksPage /> : <Navigate to="/login" />}/>
          <Route path="vocabooks/:vocaBookId/" 
          element={isLoging ? <VocaBookPage /> : <Navigate to="/login" />}/>
          <Route path="vocabooks/:vocaBookId/:category" 
          element={isLoging ? <VocaPage /> : <Navigate to="/login" />}/>
          {/* Grammar */}
          <Route path="grammars" element={isLoging ? <GrammarBooksPage /> : <Navigate to="/login" />} />
        </Route>
      </Routes>
    </>
  );
}

export default App;