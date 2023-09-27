import React, { useEffect, useState } from "react";
import axios from 'axios';
import Header from "./Header";

export default function GiveCodeComponent() {

    const [gameRoomCode, setGameRoomCode] = useState('');

    // For demonstration purposes, I'm hardcoding the gameRoomId.
    // In a real-world scenario, you'd get this from user input or some other source.
    const gameRoomId = "YOUR_GAME_ROOM_ID"; // Replace with the actual game room ID

    useEffect(() => {
        axios.get(`/api/gameRoom/code/${gameRoomCode}`)
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
            <Header />
            <h2>Your Game Room Code: {gameRoomCode}</h2>
        </div>
    );
}
