import LayoutContainer from "./containers/LayoutContainer";
import GrammarPage from "./pages/GrammarPage";
import { Navigate, Route, Routes } from "react-router-dom";
import NotFoundPage from "./pages/NotFoundPage";
import HomePage from "./pages/HomePage"
import LoginPage from "./pages/LoginPage";
import SignUpPage from "./pages/SignUpPage";
import { useDispatch, useSelector } from "react-redux";
import { useEffect, useRef, useState } from "react";
import { isLoggedIn } from "./modules/auth";
import { ToastContainer } from "react-bootstrap";
import ToastComponent from "./components/ToastComponent";
import { closePopup } from "./modules/popup";

function App() {
  //authenticated
  const { isLoging } = useSelector(state=>state.auth);
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
  const prevIsOpen = useRef(isOpen);
  
  useEffect(() => {
    if(prevIsOpen.current !== isOpen && isOpen) {
        setShow(true);
    }
    prevIsOpen.current = isOpen;
  }, [isOpen, show, message]);
  //toast

  return (
    <>
      <ToastContainer position='middle-center'>
        <ToastComponent show={show} onClose={toggleShow} message={message}/>
      </ToastContainer>
      <Routes>
        <Route path="/" element={<LayoutContainer />}>
          <Route index element={<HomePage />} />
          <Route path="*" element={<NotFoundPage />} />
          <Route path="grammar" element={isLoging ? <GrammarPage /> : <Navigate to="/login" />} />
          <Route path="login" 
          element={isLoging === false ? <LoginPage /> : <Navigate to="/" />} />
          <Route path="signup" 
          element={isLoging === false ? <SignUpPage /> : <Navigate to="/" />} />
        </Route>
      </Routes>
    </>
  );
}

export default App;