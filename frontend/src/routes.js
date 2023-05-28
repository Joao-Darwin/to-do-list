import { Routes as ReactRoutes, Route } from "react-router-dom";
import CadastrarTarefas from "./pages/CadastrarTarefas/CadastrarTarefas";
import Tarefas from "./pages/Tarefas/Tarefas";

export const Routes = () => {
    return (
        <ReactRoutes>
            <Route path="/"  Component={CadastrarTarefas}/>
            <Route path="/tarefas" Component={Tarefas}/>
        </ReactRoutes>
    );
}