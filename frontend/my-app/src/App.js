import './App.css';
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import JoinGame from './Pages/JoinGame';
import HelpPage from './Pages/HelpPage';
import GameRoom from './Pages/GameRoom';
import Home from './Pages/Home';



import 'primereact/resources/themes/mdc-light-indigo/theme.css';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';

export default function App() {
  

  return (
    <div className='App-header'>
      <Router>
      <Routes>
          <Route path="/generate-code" element={<GameRoom />} />
          <Route path="/join-game" element={<JoinGame />} />
          <Route path="/help" element={<HelpPage />} />
          <Route path='/' element={<Home />} />     
          
      </Routes>
      
    </Router>
    </div>
    
    
  );
}

