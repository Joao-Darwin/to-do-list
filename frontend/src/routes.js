import { Routes as ReactRoutes, Route } from "react-router-dom";
import CadastrarTarefas from "./pages/CadastrarTarefas/CadastrarTarefas";

export const Routes = () => {
    return (
        <ReactRoutes>
            <Route path="/"  Component={CadastrarTarefas}/>
        </ReactRoutes>
    )
}