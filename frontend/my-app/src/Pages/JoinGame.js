import React, {useState} from "react";
import Header from "../Components/Header";
import { Link } from 'react-router-dom';
import './JoinGame.css';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';


export default function JoinGame() {
    
    const [nickname, setNickname] = useState('');
    const [gameCode, setGameCode] = useState('');
    const navigate = useNavigate();
    
    const handleSubmit = (e) => {
        e.preventDefault();
        // Making API call to join the game
        axios.post('http://localhost:8080/api/v1/gameroom/join', {
            code: gameCode,
            playerDetails: {playerName: nickname}
        })
        .then(response => {
            console.log("state: ", response.state);
            console.log("response: ", response);
            // On successful join, navigate to the game room
            navigate(`/gameRoom/${gameCode}`);
        })
        .catch(error => {
            console.error("Error joining game room:", error);
        });
        console.log("Form submitted with nickname:", nickname, "and game code:", gameCode);
    };

    return(
        <div className="joingame-container">
            <Header />
            <h1>Join Game Page</h1>
            <form onSubmit={handleSubmit}>
                <div className="nickname-container">
                    <label htmlFor="nickname">Enter nickname: </label>
                    <input type="text" id="nickname" value={nickname} onChange={(e) => setNickname(e.target.value)} placeholder="Enter your nickname" />
                </div>
                <div className="code-container">
                    <label htmlFor="gamecode">Enter game code: </label>
                    <input type="text" id="gamecode" value={gameCode} onChange={(e) => setGameCode(e.target.value)} placeholder="Enter the game code" />
                </div>
                <div className="enter-button-container">
                    <button className='enter-btn' type="submit"> Enter game </ button>
                </div>
            </form>
        </div>
    );
    
    
}
