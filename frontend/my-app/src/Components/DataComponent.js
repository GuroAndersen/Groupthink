import React, { useState, useEffect } from 'react';
import axios from 'axios';

function DataComponent() {
    const [data, setData] = useState(null);

    useEffect(() => {
        // Fetch data when the component mounts
        axios.get('http://localhost:8080/api/v1/player')
            .then(response => {
                setData(response.data);
            })
            .catch(error => {
                console.error("There was an error fetching data!", error);
            });
    }, []); // The empty array means this useEffect runs once when the component mounts

    return (
        <div>
            {data ? (
                <div>Data from backend: {JSON.stringify(data)}</div>
            ) : (
                <div>Loading data...</div>
            )}
        </div>
    );
}

export default DataComponent;
