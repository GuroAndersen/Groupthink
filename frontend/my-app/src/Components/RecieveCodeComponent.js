import React, { useEffect, useState } from "react";
import axios from 'axios';

export default function RecieveCodeComponent() {

    const [gameRoomCode, setGameRoomCode] = useState('');

    useEffect(() => {
        axios.post(`http://localhost:8080/api/v1/gameroom/gameRoom`)
            .then(response => {
                const fetchedCode = response.data.code;
                setGameRoomCode(fetchedCode); // Set the fetched code to state
            })
            .catch(error => {
                console.error("Error fetching game room code:", error);
            });
    }, []); // The empty array means this useEffect runs once when the component mounts

    return (
        
        <div>
           
            <h2>Your Game Room Code: {gameRoomCode}</h2>
        </div>
    );
}