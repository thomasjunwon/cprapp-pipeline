import React from 'react';
import { BrowserRouter as Router, Route, Link, Routes } from 'react-router-dom';
import About from './pages/About';
import CommunityBoard from './pages/CommunityBoard';
import Home from './pages/Home';
import MedicalBoard from './pages/MedicalBoard';
import Schedules from './pages/Schedules';
import './App.css';

function App() {
  return (
    <Router>
      <div>
        <header>
          <h1 class='center-container'>심포니</h1>
          <nav class='center-container'>
            <ul style={{ display: 'flex', listStyleType: 'none', padding: 0 }}>
              <li style={{ marginRight: '40px',textDecoration:'none'}} class="head2"><Link to="/">홈</Link></li>
              <li style={{ marginRight: '40px',textDecoration:'none' }} class="head2"><Link to="/about">소개</Link></li>
              <li style={{ marginRight: '40px',textDecoration:'none' }} class="head2"><Link to="/medicalboard">의학게시판</Link></li>
              <li style={{ marginRight: '40px',textDecoration:'none' }} class="head2"><Link to="/communityboard">활동게시판</Link></li>
              <li class="head2"><Link to="/schedules">스케줄</Link></li>
            </ul>
          </nav>
        </header>
        <body>
          <main>
           <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/about" element={<About />} />
              <Route path="/medicalboard" element={<MedicalBoard />} />
              <Route path="/communityboard" element={<CommunityBoard />} />
              <Route path="/schedules" element={<Schedules />} />
            </Routes>
          </main>
        </body>
        <footer>
          <p>&copy;made by jun1</p>
        </footer>
      </div>
    </Router>
  );
}

export default App;