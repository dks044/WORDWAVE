import React, {useEffect, useState} from 'react';
import axios from 'axios';

function App() {
   const [main, setMain] = useState('')

    useEffect(() => {
        axios.get('/api')
        .then(response => setMain(response.data))
        .catch(error => console.log(error))
    }, []);

    return (
        <div>
            테스트 {main}
        </div>
    );
}

export default App;