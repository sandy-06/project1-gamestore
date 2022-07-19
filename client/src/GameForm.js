import { useState } from 'react';

function GameForm({ game: initialGame, notify }) {

    const [game, setGame] = useState(initialGame);
    const isAdd = initialGame.gameId === 0;

    function handleChange(evt) {
        const clone = { ...game };
        clone[evt.target.name] = evt.target.value;
        setGame(clone);
    }

    function handleSubmit(evt) {
        evt.preventDefault();

        const url = `http://localhost:8080/game`;
        const method = isAdd ? "POST" : "PUT";
        const expectedStatus = isAdd ? 201 : 200;

        const init = {
            method,
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json"
            },
            body: JSON.stringify(game)
        };

        fetch(url, init)
            .then(response => {

                if (response.status === expectedStatus) {
                    if (isAdd) {
                        return response.json();
                    } else {
                        return console;
                    }
                }
                return Promise.reject(`Didn't receive expected status: ${expectedStatus}`);
            })
            .then(result => notify({
                action: isAdd ? "add" : "edit",
                tShirt: result
            }))
            .catch(error => notify({ error: error }));
    }

    return (
        <>
            <h1>{isAdd ? "Add" : "Edit"} Game</h1>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="title">Title</label>
                    <input type="text" id="title" name="title"
                        className="form-control"
                        value={game.title} onChange={handleChange} />
                </div>
                <div className="mb-3">
                    <label htmlFor="description">description</label>
                    <input type="text" id="description" name="description"
                        className="form-control"
                        value={game.description} onChange={handleChange} />
                </div>
              
                
                <div className="mb-3">
                    <label htmlFor="price">Price</label>
                    <input type="text" id="price" name="price"
                        className="form-control"
                        value={game.price} onChange={handleChange} />

                </div>
                <div className="mb-3">
                    <label htmlFor="quantity">Quantity</label>
                    <input type="text" id="quantity" name="quantity"
                        className="form-control"
                        value={game.quantity} onChange={handleChange} />
                </div>

                <div className="mb-3">
                    <button className="btn btn-primary mr-3" type="submit">Save</button>
                    <button className="btn btn-secondary" type="button" onClick={() => notify({ action: "cancel" })}>Cancel</button>
                </div>
            </form>
        </>
    );
}

export default GameForm;