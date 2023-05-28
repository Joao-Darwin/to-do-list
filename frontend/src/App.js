import './App.css';
import { BrowserRouter } from 'react-router-dom';
import { Routes } from './routes';

function App() {
  return (
    <BrowserRouter>
      <h1>Gerenciador de Tarefas</h1>
      <Routes/>
    </BrowserRouter>
  );
}

export default App;
