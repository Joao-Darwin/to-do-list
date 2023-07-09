import { Routes as ReactRoutes, Route } from "react-router-dom";
import CadastrarTarefas from "./pages/CadastrarTarefas/CadastrarTarefas";
import Tarefas from "./pages/Tarefas/Tarefas";
import Categorias from "./pages/Categorias/Categorias";
import Tags from "./pages/Tags/Tags";
import Lembretes from "./pages/Lembretes/Lembretes";

export const Routes = () => {
    return (
        <ReactRoutes>
            <Route path="/"  Component={CadastrarTarefas}/>
            <Route path="/tarefas" Component={Tarefas}/>
            <Route path="/categorias" Component={Categorias}/>
            <Route path="/tags" Component={Tags}/>
            <Route path="/lembretes" Component={Lembretes} />
        </ReactRoutes>
    );
}