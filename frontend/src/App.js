import './App.css';
import { BrowserRouter } from 'react-router-dom';
import { Routes } from './routes';
import TopBar from './components/TopBar/TopBar';
import SideBar from './components/SideBar/SideBar';
import { useState } from 'react';

function App() {

  const [sideBarView, setSideBarView] = useState(false);

    const handleSideBarView = () => {
        if(sideBarView) {
            setSideBarView(false);
        } else {
            setSideBarView(true);
        }
    }

  return (
    <BrowserRouter>
      {sideBarView && <SideBar handleSideBar={handleSideBarView}/>}
      <TopBar handleSideBar={handleSideBarView}/>
      <Routes/>
    </BrowserRouter>
  );
}

export default App;
