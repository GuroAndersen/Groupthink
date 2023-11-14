import Header from '../Components/Header';
import { Link } from 'react-router-dom';
import './Home.css';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

export default function Home() {

    let navigate = useNavigate();

    const handleNewGameRoom = () => {
      axios.post(`http://localhost:8080/api/v1/gameroom/gameRoom`)
                .then(response => {
                    console.log("Game room created: ", response.data);
                    const newGameCode = response.data.code;
                    navigate(`gameRoom/${newGameCode}`);
                })
                .catch(error => {
                    console.error("Error fetching game room details:", error);
                });
    }
    return(<div className='Home-container'>
       
        <Header />
      
        <img src="/17676.png" className="App-logo" alt="logo" />
        <p>
          Sier alle kuer mø?
        </p>
        
        <div className='button-container'>
          
          <div className="play-button-container">
            <button className='btn' onClick={handleNewGameRoom}> Generate new game room </button>
            <Link className='btn' to='/join-game'> Join a game </Link>
          </div>
          <div className="help-button-container">
            <Link className='btn' to='/help'> How to play </Link>
          </div>
        </div>
      
    </div>
    );
}
