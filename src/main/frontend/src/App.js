import React, {useEffect, useState} from 'react';
import axios from 'axios';
import Layout from './components/Layout';
import Home from './pages/Home';
import { Route,Routes } from 'react-router-dom';

function App() {
    return (
        <Routes>
            <Route path='/' element={<Layout/>}>
                <Route index element={<Home />} />
            </Route>
        </Routes>
    );
}

export default App;
