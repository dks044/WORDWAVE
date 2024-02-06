import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";
import "./index.css";
import reportWebVitals from "./reportWebVitals";
import { BrowserRouter } from "react-router-dom";
import { createGlobalStyle } from "styled-components";
import WaveEffect from "./components/WaveEffect";
import { configureStore } from "@reduxjs/toolkit";
import rootReducer from "./modules/reducers";
import logger from "redux-logger";
import sagaMiddleware, { rootSaga } from "./modules/rootSaga";
import { Provider } from "react-redux";
import "bootstrap/dist/css/bootstrap.min.css";
import storage from "redux-persist/lib/storage";
import persistReducer from "redux-persist/es/persistReducer";
import { PersistGate } from "redux-persist/integration/react";
import persistStore from "redux-persist/es/persistStore";
import {
  FLUSH,
  REHYDRATE,
  PAUSE,
  PERSIST,
  PURGE,
  REGISTER,
} from "redux-persist";

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
::-webkit-scrollbar {
    width: 8px;  
}

::-webkit-scrollbar-thumb {
    height: 30%; 
    background: #217af4; 
    
    border-radius: 10px;
}

::-webkit-scrollbar-track {
    background: rgba(33, 122, 244, .1);  
}
`;

const persistConfig = {
  key: "root",
  storage,
};
const persistedReducer = persistReducer(persistConfig, rootReducer);

const store = configureStore({
  reducer: persistedReducer,
  devTools: process.env.NODE_ENV !== "production",
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware({
      serializableCheck: {
        ignoredActions: [FLUSH, REHYDRATE, PAUSE, PERSIST, PURGE, REGISTER],
      },
    }).concat(sagaMiddleware, logger),
});

const persistor = persistStore(store);

sagaMiddleware.run(rootSaga);

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