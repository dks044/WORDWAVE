import React, {useEffect, useState} from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import Navigation from './component/nav';
import { Route, Routes } from 'react-router-dom';


function App() {
   const [main, setMain] = useState('')

    useEffect(() => {
        axios.get('/api')
        .then(response => setMain(response.data))
        .catch(error => console.log(error))
    }, []);

    return (
        <>
            <Routes>
                <Route></Route>
            </Routes>
        </>
    );
}

export default App;