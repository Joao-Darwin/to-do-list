import { Routes as ReactRoutes, Route } from "react-router-dom";
import CadastrarTarefas from "./pages/CadastrarTarefas/CadastrarTarefas";
import Tarefas from "./pages/Tarefas/Tarefas";
import Categorias from "./pages/Categorias/Categorias";

export const Routes = () => {
    return (
        <ReactRoutes>
            <Route path="/"  Component={CadastrarTarefas}/>
            <Route path="/tarefas" Component={Tarefas}/>
            <Route path="/categorias" Component={Categorias}/>
            {/* Página de Tags */}
        </ReactRoutes>
    );
}