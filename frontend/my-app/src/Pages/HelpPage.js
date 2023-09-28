import Header from '../Components/Header';
import {React} from 'react';

export default function HelpPage() {

// Uncomment the line below if you want the help page to be toggled
//If you want to be able to toggle all three separately you will need to add a different const for each of them
//const [isVisible, setIsVisible] = useState(false);

return(<div>
        <Header />
        <h1> Help Page </h1>
        <div>
            <h3 className='set-up-game' >Set up a game</h3>
            <p>To set up a new game one player must open the "Generate new game room" page. This will present a unique game code that players can use to enter the game. Entering another new game room, or reloading the page will generate a new game code.</p>
        </div>
        <div>
            <h3 className='join-a-game' >Join a game</h3>
            <p>To join a game press the "join game" button on the front page and enter your nickname and the gamecode presented to you. Two players cannot have the same nickname so be original.</p>
        </div>
        <div>
            <h3 className='game-instructions'>Game instructions</h3>
            <p>The premise of the game is to think like your fellow players. Every round of the game a prompt is presented and everyone must give an answer via their device. The goal is to answer the same as the others and not be the odd one out. Everytime you have the same answer as another player you get a point. If you are the odd one out you get a penalty and cannot gain points until someone else becomes the odd one out. First one to 20 points wins.</p>
        </div> 
    </div>
    );
}
    

