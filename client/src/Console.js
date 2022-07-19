import { useState, useEffect } from 'react';
import './Console.css';
import ConsoleCard from './ConsoleCard';
import ConsoleForm from './ConsoleForm.js';

function Console() {

    const [console, setConsole] = useState([]);
    const [showForm, setShowForm] = useState(false);
    const [showDetailsForm, setShowDetailsForm] = useState(false);
    const [scopedConsole, setScopedConsole] = useState({});
    const [error, setError] = useState();

    useEffect(() => {
        fetchFromAPI();
    }, []);

    function fetchFromAPI() {
        fetch("http://localhost:8080/console")
            .then(response => response.json())
            .then(result => { console.log(JSON.stringify(result)); setConsole(result); })
            .catch(console.log);
    }

    function addClick() {
        setScopedConsole({ consoleId: 0, model: "", manufacturer: "", memory_amount: "", processor: "", price: 0, quantity: 0 });
        setShowForm(true);
    }

    function notify({ action, console, error }) {

        if (error) {
            setError(error);
            setShowForm(false);
            setShowDetailsForm(false);
            return;
        }
        return invoice(action, console);
        }

    function invoice(action, console) {

    }
    

    
    return (
        <>
            {error && <div className="alert alert-danger">{error}</div>}
            <div>
                <h1 id='consoleTitle'>Consoles</h1>
                <button className="btn btn-primary" type="button" onClick={addClick}>Pick a Console</button>
                <table id='console'>
                    <tr>
                        <th>Model</th>
                        <th>Manufacturer</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Processor</th>
                        <th>Memory_amount</th>
                    </tr>
                    <tbody>
                        {console.map(c => <ConsoleCard key={c.ConsoleCard.consoleId} console={c} notify={notify} />)}
                    </tbody>
                </table>
            </div>
            
        </>
    )
}
   
export default Console;
