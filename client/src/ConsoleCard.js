function ConsoleCard({ console, notify }) {

    function handleDelete() {
        fetch(`http://localhost:8080/console/${console.consoleId}`, { method: "DELETE" })
            .then(() => notify({ action: "delete", console: console }))
            .catch(error => notify({ action: "delete", error: error }));
    }

    return (
        <tr key={console.consoleId}>
            <td>{console.model}</td>
            <td>{console.manufacturer}</td>
            <td>{console.price}</td>
            <td>{console.quantity}</td>
            <td>{console.processor}</td>
            <td>{console.memory_amount}</td>
            <td>
                <button id="deleteButton" className="btn btn-danger mr-3" type="button" onClick={handleDelete}>Delete</button>
                <button id="editButton" className="btn btn-secondary" type="button" onClick={() => notify({ action: "edit-form", console: console })}>Edit</button>
                <button id="detailsButton" className="btn btn-secondary" type="button" onClick={() => notify({ action: "details", console: console })}>Details</button>
            </td>
        </tr>
    );
}

export default ConsoleCard;
