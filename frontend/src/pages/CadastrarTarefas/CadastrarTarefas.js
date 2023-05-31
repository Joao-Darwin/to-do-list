import React from "react";
import FormTarefa from "../../components/FormTarefa/FormTarefa";
import {Link} from "react-router-dom";

const CadastrarTarefas = () => {
    return (
        <div>
            <h2>Criar tarefa</h2>
            <FormTarefa />
            <Link to={"/tarefas"}>
                <button className='buttonForm' style={{width: "21%", marginTop: "1%"}} type='button' value="Tarefas">Tarefas</button>
            </Link>
        </div>
    );
}

export default CadastrarTarefas;