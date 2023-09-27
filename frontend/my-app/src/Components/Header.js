import {  Link } from 'react-router-dom';

export default function Header() {
    return (
        <Link className='Home-space' to='/' style={{display: 'flex', alignItems: 'center', textDecoration: 'none', top: 0, left: 0, position: 'absolute', marginTop: -8, marginLeft: 10}}>
            <img src="/17676.png" className='Home-button' alt='cow' style={{width: 50, height: 50, marginBottom: 22}}/>
            <p style={{color: 'white', padding: 5}}>Home</p>
        </Link>
    )
}