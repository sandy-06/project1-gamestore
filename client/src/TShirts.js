import { useState, useEffect } from 'react';
import './TShirt.css';
import TShirtCard from './TShirtCard';
import TShirtForm from './TShirtForm.js';

function TShirtCard() {

    const [tShirt, setTShirt] = useState([]);
    const [showForm, setShowForm] = useState(false);
    const [showDetailsForm, setShowDetailsForm] = useState(false);
    const [scopedTShirt, setScopedTShirt] = useState({});
    const [error, setError] = useState();

    useEffect(() => {
        fetchFromAPI();
    }, []);

    function fetchFromAPI() {
        fetch("http://localhost:8080/tShirt")
            .then(response => response.json())
            .then(result => { console.log(JSON.stringify(result)); setTShirt(result); })
            .catch(console.log);
    }

    function addClick() {
        setScopedGame({ tShirtId: 0, color: "", size:"", description: "", price: 0, quantity: 0 });
        setShowForm(true);
    }

    function notify({ action, tShirt, error }) {

        if (error) {
            setError(error);
            setShowForm(false);
            setShowDetailsForm(false);
            return;
        }
        return invoice(action, tShirt);
    }

    function invoice(action, tShirt) {
        return invoice

    }



    return (
        <>
            {error && <div className="alert alert-danger">{error}</div>}
            <div>
                <h1 id='tShirtTitle'>T-Shirts</h1>
                <button className="btn btn-primary" type="button" onClick={addClick}>Pick a T-Shirt</button>
                <table id='tShirt'>
                    <tr>
                        <th>Color</th>
                        <th>Size</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Quantity</th>

                    </tr>
                    <tbody>
                        {tShirt.map(t => <tShirtCard key={t.tShirtCard.tShirtId} tShirt={t} notify={notify} />)}
                    </tbody>
                </table>
            </div>

        </>
    )
}

export default TShirt;
