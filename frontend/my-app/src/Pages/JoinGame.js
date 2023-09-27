import {React, useState} from "react";
import Header from "../Components/Header";
import { Link } from 'react-router-dom';
import './JoinGame.css';

export default function JoinGame() {
    
    const [nickname, setNickname] = useState('');
    const [gameCode, setGameCode] = useState('');
    
    const handleSubmit = (e) => {
        e.preventDefault();
        console.log('Nickname:', nickname);
        console.log('Game Code:', gameCode);
    };

    return(<div className="joingame-container">
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
    <Link className='enter-btn' to='/gameRoom'> Enter game </ Link>
    </div>
    
    </form>
    </div>
    );
    
    
}
