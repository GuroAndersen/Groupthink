import Header from '../Components/Header';
import { Link } from 'react-router-dom';
import './Home.css';

export default function Home() {
    return(<div className='Home-container'>
       
        <Header />
      
        <img src="/17676.png" className="App-logo" alt="logo" />
        <p>
          Sier alle kuer mø?
        </p>
        
        <div className='button-container'>
          
          <div className="play-button-container">
            <Link className='btn' to='/gameRoom'> Generate new game room </Link>
            <Link className='btn' to='/join-game'> Join a game </Link>
          </div>
          <div className="help-button-container">
            <Link className='btn' to='/help'> How to play </Link>
          </div>
        </div>
      
    </div>
    );
}
