import React,{useState}from 'react';
import { BrowserRouter as Router, Route, Link, Routes } from 'react-router-dom';
import About from './pages/About';
import CommunityBoard from './pages/CommunityBoard';
import Home from './pages/Home';
import MedicalBoard from './pages/MedicalBoard';
import Schedules from './pages/Schedules';
import './App.css';

function App() {
  const [activeMenu, setActiveMenu]=useState(null);
  const toggle=(menu)=>{
    setActiveMenu(activeMenu===menu ? null : menu);
  }
  const listItemStyle={
    flex:1, marginRight: '40px', borderRight:'1px solid #ccc'
  };
  return (
    <Router>
      <div class="container">
        <header>
          <h1 class='header1'>심포니</h1>
          <nav class='header2' >
            <ul style={{ display: 'flex', listStyleType: 'none',padding:0 }}>
              <li style={listItemStyle} ><Link to="/" class="head2" onClick={()=>toggle('home')}>홈</Link></li>
              <li style={listItemStyle} ><Link to="/about" class="head2" onClick={()=>toggle('about')}>소개</Link>
              </li>
              <li style={listItemStyle} ><Link to="/medicalboard" class="head2" onClick={()=>toggle('medicalboard')}>의학게시판</Link></li>
              <li style={listItemStyle} ><Link to="/communityboard" class="head2" onClick={()=>toggle('communityboard')}>활동게시판</Link></li>
              <li style={{flex:1}}><Link to="/schedules" class="head2" onClick={()=>toggle('schedules')}>스케줄</Link></li>
            </ul>
            {(activeMenu==='about')&&(
            <ul class='main-fixed'>
              <li><Link to="/home/why" class="head3">심포니 설립목적</Link></li>
              <li><Link to="/home/history" class="head3">심포니 연혁</Link></li>
              <li><Link to="/home/how" class="head3">봉사 참여 과정</Link></li>
              <li><Link to="/home/tojon" class="head3">봉사해보고 싶어요!</Link></li>
            </ul>
          )}
          </nav>  
        </header>

        <div>
          <main>
           <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/about" element={<About />} />
              <Route path="/medicalboard" element={<MedicalBoard />} />
              <Route path="/communityboard" element={<CommunityBoard />} />
              <Route path="/schedules" element={<Schedules />} />
            </Routes>
          </main>
        </div>

        <footer>
          <p>&copy;made by thomasjunwon</p>
        </footer>
      </div>
    </Router>
  );
}

export default App;