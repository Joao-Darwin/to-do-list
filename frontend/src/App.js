import './App.css';
import FormTarefa from './components/FormTarefa';

function App() {
  return (
    <div className="App">
      <h1>Gerenciador de Tarefas</h1>
      <h2>Criar tarefa</h2>
      <FormTarefa/>
      <h2>Tarefas</h2>
    </div>
  );
}

export default App;
