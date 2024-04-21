import LayoutContainer from "./containers/LayoutContainer";
import { Navigate, Route, Routes } from "react-router-dom";
import NotFoundPage from "./pages/NotFoundPage";
import HomePage from "./pages/HomePage"
import LoginPage from "./pages/LoginPage";
import SignUpPage from "./pages/SignUpPage";
import VocaBooksPage from "./pages/voca/VocaBooksPage";
import GrammarPage from "./pages/grammar/GrammarPage";
import GrammarBookPage from "./pages/grammar/GrammarBookPage";
import GrammarBooksPage from "./pages/grammar/GrammarBooksPage";
import { useDispatch, useSelector } from "react-redux";
import { useEffect, useState } from "react";
import { isLoggedIn } from "./modules/auth";
import { ToastContainer } from "react-bootstrap";   
import ToastComponent from "./components/ToastComponent";
import { closePopup } from "./modules/popup";
import MyPage from "./pages/MyPage";
import VocaBookPage from "./pages/voca/VocaBookPage";
import VocaPage from "./pages/voca/VocaPage";
import MyVocaBooksPage from "./pages/myVoca/MyVocaBooksPage";
import MyVocaBookFormPage from "./pages/myVoca/MyVocaBookFormPage";
import MyVocaBookPage from "./pages/myVoca/MyVocaBookPage"
import MyVocaBookUpdateFormPage from "./pages/myVoca/MyVocaBookUpdateFormPage";
import MyVocaFormPage from "./pages/myVoca/MyVocaFormPage";
import MyVocaUpdateFormPage from "./pages/myVoca/MyVocaUpdateFormPage";
import MyVocaPage from "./pages/myVoca/MyVocaPage";

function App() {
  //authenticated
  const { isLoging } = useSelector(state=>state.auth);
  const {isOpen, message} = useSelector(state=>state.popup);
  const dispatch = useDispatch();
  console.log(isLoging);
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
          <Route path="grammarbooks" element={isLoging ? <GrammarBooksPage /> : <Navigate to="/login" />} />
          <Route path="grammarbooks/:grammarBookId/" 
          element={isLoging ? <GrammarBookPage /> : <Navigate to="/login" />}/>
          <Route path="grammarbooks/:grammarBookId/:category" 
          element={isLoging ? <GrammarPage /> : <Navigate to="/login" />}/>
          {/* MyVoca */}
          <Route path="myvocabooks" element={isLoging ? <MyVocaBooksPage /> : <Navigate to="/login" />} />
          <Route path="myvocabooks/create" 
          element={isLoging ? <MyVocaBookFormPage /> : <Navigate to="/login" />} />
          <Route path="myvocabooks/update/:myVocaBookId/" 
          element={isLoging ? <MyVocaBookUpdateFormPage /> : <Navigate to="/login" />} />
          <Route path="myvocabooks/:myVocaBookId" 
          element={isLoging ? <MyVocaBookPage /> : <Navigate to="/login" />}/>
          <Route path="myvocabooks/:myVocaBookId/:category" 
          element={isLoging ? <MyVocaPage /> : <Navigate to="/login" />}/> {/* 나만의 영단어 퀴즈 */}
          <Route path="myvocabooks/:myVocaBookId/create" 
          element={isLoging ? <MyVocaFormPage /> : <Navigate to="/login" />}/>
          <Route path="myvocabooks/:myVocaBookId/update/:category" 
          element={isLoging ? <MyVocaUpdateFormPage /> : <Navigate to="/login" />}/>
        </Route>
      </Routes>
    </>
  );
}

export default App;