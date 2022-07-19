import { useState } from 'react';

function TShirtForm({ game: initialTShirt, notify }) {

    const [game, setTShirt] = useState(initialTShirt);
    const isAdd = initialTShirt.tShirtId === 0;

    function handleChange(evt) {
        const clone = { ...tShirt };
        clone[evt.target.name] = evt.target.value;
        setTShirt(clone);
    }

    function handleSubmit(evt) {
        evt.preventDefault();

        const url = `http://localhost:8080/tShirt`;
        const method = isAdd ? "POST" : "PUT";
        const expectedStatus = isAdd ? 201 : 200;

        const init = {
            method,
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json"
            },
            body: JSON.stringify(tShirt)
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
            <h1>{isAdd ? "Add" : "Edit"} T-Shirt</h1>
            <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <label htmlFor="color">Color</label>
                    <input type="text" id="color" name="color"
                        className="form-control"
                        value={tShirt.color} onChange={handleChange} />
                </div>
                <div className="mb-3">
                    <label htmlFor="size">Size</label>
                    <input type="text" id="size" name="sizer"
                        className="form-control"
                        value={tShirt.size} onChange={handleChange} />
                </div>
                <div className="mb-3">
                    <label htmlFor="description">description</label>
                    <input type="text" id="description" name="description"
                        className="form-control"
                        value={tShirt.description} onChange={handleChange} />
                </div>


                <div className="mb-3">
                    <label htmlFor="price">Price</label>
                    <input type="text" id="price" name="price"
                        className="form-control"
                        value={tShirt.price} onChange={handleChange} />

                </div>
                <div className="mb-3">
                    <label htmlFor="quantity">Quantity</label>
                    <input type="text" id="quantity" name="quantity"
                        className="form-control"
                        value={tShirt.quantity} onChange={handleChange} />
                </div>

                <div className="mb-3">
                    <button className="btn btn-primary mr-3" type="submit">Save</button>
                    <button className="btn btn-secondary" type="button" onClick={() => notify({ action: "cancel" })}>Cancel</button>
                </div>
            </form>
        </>
    );
}

export default TShirtForm;