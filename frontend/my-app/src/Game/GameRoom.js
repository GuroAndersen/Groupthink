import React, { useState, useEffect, useCallback } from "react";
import Header from "../Components/Header";
import RecieveCodeComponent from "../Components/RecieveCodeComponent";
import axios from 'axios';
import { useParams, useLocation } from 'react-router-dom';

export default function GameRoom() {
    const { gameCode } = useParams();
    const location = useLocation();
    const { state } = location;
    const [players, setPlayers] = useState([]);
    const [isFormSubmitted, setIsFormSubmitted] = useState(false);
    const isRoomOwner = !gameCode; // If gameCode is not in URL, this user is the room owner

    const fetchGameRoomDetails = useCallback(() => {
        if (gameCode) {
            axios.get(`http://localhost:8080/api/v1/gameroom/gameRoom/code/${gameCode}`)
                .then(response => {
                    console.log("Check response: ", response.data);
                    if (response.data.players) {
                        setPlayers(response.data.players);
                        console.log("Updated players state: ", response.data.players);
                    }
                })
                .catch(error => {
                    console.error("Error fetching game room details:", error);
                });
            }
    }, [gameCode]);

    useEffect(() => {
        fetchGameRoomDetails(); // Fetch on mount and when gameCode changes

        // If navigated from join game with state indicating a new player joined
        if (state?.playerJoined) {
            fetchGameRoomDetails(); // Refetch player list
        }

        const intervalId = setInterval(fetchGameRoomDetails, 5000); // Fetch every 5 seconds to update players on page.

        return () => {
            clearInterval(intervalId);
        };
    }, [gameCode, state, fetchGameRoomDetails]); // Add state to dependency array

    console.log("players: ", players);

return(
    <>
    <Header />
    <div>
            {isRoomOwner ? <RecieveCodeComponent /> : <h2>Game Code: {gameCode}</h2>}
            <h3>Players in Room:</h3>
            <ul>
                {players.map(player => (
                <li key={player.id}>{player.name}</li>
                ))}
            </ul>
        </div>
    </>
    
);   
}