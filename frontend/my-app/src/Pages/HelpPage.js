import Header from '../Components/Header';
import {React} from 'react';
import DataComponent from '../Components/DataComponent';

export default function HelpPage() {

// Uncomment the line below if you want the help page to be toggled
//If you want to be able to toggle all three separately you will need to add a different const for each of them
//const [isVisible, setIsVisible] = useState(false);

return(<div>
        <Header />
        <h1> Help Page </h1>
        <div>
            <h3 className='set-up-game' >Set up a game</h3>
        </div>
        <div>
            <h3 className='join-a-game' >Join a game</h3>
        </div>
        <div>
            <h3 className='game-instructions'>Game instructions</h3>
        </div>
        <div className='Data-from-api'>
        <DataComponent />

        </div>
        
        
        
    </div>
    );
}
    

