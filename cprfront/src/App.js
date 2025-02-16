import React,{useState}from 'react';
import { BrowserRouter as Router, Route, Link, Routes } from 'react-router-dom';
import About from './pages/About';
import CommunityBoard from './pages/CommunityBoard/CommunityBoard';
import Home from './pages/Home';
import MedicalBoard from './pages/MedicalBoard';
import Schedules from './pages/Schedules';
import Signin from './pages/Signin';
import './App.css';
import {Button} from '@mui/material';

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
          <div style={{display:'flex',justifyContent:'space-around', alignItems:'center'}}>
            <h1 class='header1' style={{paddingLeft:'35%'}}>심포니</h1>
            <div style={{gap:'10px',display:'flex'}}>
              <Button variant="outlined" color="secondary" component={Link} to="/signup" style={{textAlign: 'center'}} >
                  회원가입
              </Button>
              <Button variant="outlined" color="secondary" component={Link} to="/signin">
                  로그인
              </Button>
            </div>
          </div>
          
          <nav class='header2' >
            <ul style={{ display: 'flex', listStyleType: 'none',padding:0 }}>
              <li style={listItemStyle} ><Link to="/" class="head2" onClick={()=>toggle('home')}>홈</Link></li>
              <li style={listItemStyle} ><Link to="/about" class="head2" onClick={()=>toggle('about')}>소개</Link></li>
              <li style={listItemStyle} ><Link to="/medicalboard" class="head2" onClick={()=>toggle('medicalboard')}>의학게시판</Link></li>
              <li style={listItemStyle} ><Link to="/communityboard" class="head2" onClick={()=>toggle('communityboard')}>활동게시판</Link></li>
              <li style={{flex:1}}><Link to="/schedules" class="head2" onClick={()=>toggle('schedules')}>스케줄</Link></li>
            </ul>
            {(activeMenu==='about')&&(
            <ul class='main-fixed main-fixed-2'>
              <li><Link to="/about/why" class="head3">심포니 설립목적</Link></li>
              <li><Link to="/about/history" class="head3">심포니 연혁</Link></li>
              <li><Link to="/about/how" class="head3">봉사 참여 과정</Link></li>
              <li><Link to="/about/tojon" class="head3">봉사해보고 싶어요!</Link></li>
            </ul>)}

            {(activeMenu==='medicalboard')&&(
            <ul class='main-fixed main-fixed-3'>
              <li><Link to="/medicalboard/common" class="head3">공용 게시판</Link></li>
              <li><Link to="/medicalboard/my" class="head3">나의 게시판</Link></li>
            </ul>)}

            {(activeMenu==='communityboard')&&(
            <ul class='main-fixed main-fixed-4'>
              <li><Link to="/communityboard/common" class="head3">공용 게시판</Link></li>
              <li><Link to="/communityboard/my" class="head3">나의 게시판</Link></li>
            </ul>)}

          </nav>  
        </header>

        <div>
          <main>
           <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/about" element={<About />} />
              <Route path="/medicalboard" element={<MedicalBoard />} />
              <Route path="/communityboard" element={<CommunityBoard />} />
              <Route path="/communityboard/common" element={<CommunityBoardCommon />} />
              <Route path="/communityboard/my" element={<CommunityBoardMy />} />
              <Route path="/schedules" element={<Schedules />} />
              <Route path="/Signin" element={<Signin/>}/>
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