import React, { useState, useEffect } from "react";
import Header from "../Components/Header";
import RecieveCodeComponent from "../Components/RecieveCodeComponent";
import axios from 'axios';
import { useParams } from 'react-router-dom';

export default function GameRoom() {
    const { gameCode } = useParams();
    const [players, setPlayers] = useState([]);
    const isRoomOwner = !gameCode; // If gameCode is not in URL, this user is the room owner

    useEffect(() => {
        if (gameCode) {
          // Fetch the game room details and set the players list
          axios.get(`http://localhost:8080/api/v1/gameroom/gameRoom/code/${gameCode}`)
            .then(response => {
              // Assuming the response contains a list of players
              setPlayers(response.data.players); // Update the players list
            })
            .catch(error => {
              console.error("Error fetching game room details:", error);
            });
        }
      }, [gameCode]);

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
