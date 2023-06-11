import './App.css';
import { BrowserRouter } from 'react-router-dom';
import { Routes } from './routes';
import TopBar from './components/TopBar/TopBar';

function App() {
  return (
    <BrowserRouter>
      <TopBar />
      <Routes/>
    </BrowserRouter>
  );
}

export default App;
