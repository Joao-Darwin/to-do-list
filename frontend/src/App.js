import { BrowserRouter } from 'react-router-dom';
import './App.css';
import Layout from './layout/Layout';
import { Routes } from './routes';

function App() {
  return (
    <BrowserRouter>
      <Layout />
      <Routes />
    </BrowserRouter>
  );
}

export default App;
