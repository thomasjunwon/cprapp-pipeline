import React from 'react'
import {BrowserRouter as Router,Route,Link,Routes} from 'react-router-dom';

function App() {
  return (
    <Router>
      <div>
        <header>
          <h1>심포니</h1>
          <nav>
            <ul style={{display:'flex',listStyleType:'none',padding:0}}>
              <li style={{marginRight:'20px'}}><Link to="/">홈</Link></li>
              <li style={{marginRight:'20px'}}><Link to="/about">소개</Link></li>
              <li style={{marginRight:'20px'}}><Link to="/services">서비스</Link></li>
              <li><Link to="/contact">연락처</Link></li>
            </ul>
          </nav>
        </header>
        <main>
          <Routes>
            <Route path="/" element={<Home/>}/>
            <Route path="/about" element={<About/>}/>
            <Route path="/services" element={<Services/>}/>
            <Route path="/contact" element={<Contact/>}/>
          </Routes>
        </main>
      </div>
    </Router>
  );
}

export default App;
