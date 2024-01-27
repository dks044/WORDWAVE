import React from "react";
import ReactDOM from "react-dom/client";
// import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";
import { BrowserRouter } from "react-router-dom";
import { createGlobalStyle } from "styled-components";
import WaveEffect from "./components/WaveEffect";
import { configureStore } from "@reduxjs/toolkit";
import rootReducer from "./modules";
import logger from "redux-logger";
import { Provider } from "react-redux";
import 'bootstrap/dist/css/bootstrap.min.css';
import storage from 'redux-persist/lib/storage/session'
import persistReducer from "redux-persist/es/persistReducer";
import { PersistGate } from "redux-persist/integration/react";
import persistStore from "redux-persist/es/persistStore";
import './index.css';


const root = ReactDOM.createRoot(document.getElementById("root"));
const GlobalStyle = createGlobalStyle`

#root {
    background: linear-gradient(to right, #89CFF0 0%, #B2FFFF 50%, #89CFF0 100%);
    justify-content: center;
    align-items: center;
    overflow-x: hidden;
    overflow-y: auto;
    position: relative;
}
`;

const persistConfig = {
  key: 'root',
  storage,
};
const persistedReducer = persistReducer(persistConfig, rootReducer);

const store = configureStore({
  reducer: persistedReducer,
  middleware: (getDefaultMiddleware) => getDefaultMiddleware().concat(logger)
});

const persistor = persistStore(store);

root.render(
  <BrowserRouter>
    <GlobalStyle />
    <WaveEffect />
    <Provider store={store}>
      <PersistGate loading={null} persistor={persistor}>
        <App />
      </PersistGate>
    </Provider>
  </BrowserRouter>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
