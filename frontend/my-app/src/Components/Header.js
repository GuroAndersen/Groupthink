import {  Link } from 'react-router-dom';

export default function Header() {
    return (
        <div className='Header-component' style={{width: '100vw',  backgroundColor: '#282c29', textDecoration: 'none', display: 'flex', justifyContent: 'space-between'}}>
            <Link className='Home-space' to='/' style={{display: 'flex'}}>
                <img src="/17676.png" className='Home-button' alt='cow' style={{width: 50, height: 50, top: '0', left: '0', marginTop: '5px'}}/>
                <p style={{color: 'white', padding: 5, marginTop: '28px', marginBottom: '0'}}>Home</p>
            </Link>
        </div>
        
    )
}