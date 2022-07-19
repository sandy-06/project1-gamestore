import { useState, useEffect } from 'react';
import './Game.css';
import GameCard from './gameCard';
import GameForm from './GameForm.js';

function GameCard() {

    const [game, setGame] = useState([]);
    const [showForm, setShowForm] = useState(false);
    const [showDetailsForm, setShowDetailsForm] = useState(false);
    const [scopedGame, setScopedGame] = useState({});
    const [error, setError] = useState();

    useEffect(() => {
        fetchFromAPI();
    }, []);

    function fetchFromAPI() {
        fetch("http://localhost:8080/game")
            .then(response => response.json())
            .then(result => { console.log(JSON.stringify(result)); setGame(result); })
            .catch(console.log);
    }

    function addClick() {
        setScopedGame({ gameId: 0, title:"", description:"", price: 0, quantity: 0 });
        setShowForm(true);
    }

    function notify({ action, game, error }) {

        if (error) {
            setError(error);
            setShowForm(false);
            setShowDetailsForm(false);
            return;
        }
        return invoice(action, game);
    }

    function invoice(action, game) {

    }



    return (
        <>
            {error && <div className="alert alert-danger">{error}</div>}
            <div>
                <h1 id='gameTitle'>Games</h1>
                <button className="btn btn-primary" type="button" onClick={addClick}>Pick a Game</button>
                <table id='game'>
                    <tr>
                        <th>Title</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        
                    </tr>
                    <tbody>
                        {game.map(g => <gameCard key={g.GameCard.gameId} game={g} notify={notify} />)}
                    </tbody>
                </table>
            </div>

        </>
    )
}

export default Game;
