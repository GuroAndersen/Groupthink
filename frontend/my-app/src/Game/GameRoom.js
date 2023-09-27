import React from "react";
import Header from "../Components/Header";
import RecieveCodeComponent from "../Components/RecieveCodeComponent";

export default function GameRoom() {
return(
    <>
    <Header />
    <div className="gameroom-container">
        
        <div className="code-container">
            <RecieveCodeComponent />
        </div>
    </div>
    </>
    
);
    
    
}
