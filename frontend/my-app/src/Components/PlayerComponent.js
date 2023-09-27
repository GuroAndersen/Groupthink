import React, { useEffect, useState } from "react";
import axios from 'axios';

export default function PlayerComponent() {

    // Keeps track of the players that are in the game
    const [players, setPlayers] = useState([]);
    // Const for adding new players to the game
    const [newPlayer, setNewPlayer] = useState("");
    // Const for removing players from the game
    const [removePlayer, setRemovePlayer] = useState("");

    // Function for adding the player to the game
    const addNewPlayer = () => {
        setNewPlayer([...players, newPlayer]);
        setNewPlayer("");
    }

    // Function for removing player from the game
    const removeAddedPlayer = (index) => {
        setPlayers(players.filter((_,i) => i !== index));
    }


    useEffect(() => {
        axios.post(`http://localhost:8080/api/v1/player`)
            .then(response => {
                const fetchedPlayers = response.data.player;
                setPlayers(fetchedPlayers); // Set the fetched code to state
            })
            .catch(error => {
                console.error("Error adding player to game:", error);
            });
    }, []); // The empty array means this useEffect runs once when the component mounts

    return (
        <div className="Players">
            {players}
        </div>
    )
}