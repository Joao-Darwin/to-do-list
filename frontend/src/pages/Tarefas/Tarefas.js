import React, { useEffect, useState } from 'react';
import Tarefa from '../../components/Tarefa/Tarefa';
import "./Tarefa.css"
import openApi from '../../services/api';

const Tarefas = () => {

    const [tarefas, setTarefas] = useState([]);

    useEffect(() => {
        const FindAllTarefas = async () => {
            const tarefas = (await openApi.get("/tarefa")).data;
            setTarefas(tarefas);
        }
        FindAllTarefas();
    }, [])

    return (
        <div>
            <h1>Tarefas</h1>
            <div className='divTarefas'>
                {
                    tarefas.map((tarefa) => (
                        <Tarefa
                            key={tarefa.id}
                            id={tarefa.id}
                            nome={tarefa.nome}
                            descricao={tarefa.descricao}
                            dataCricao={tarefa.dataCricao}
                            dataConclusao={tarefa.dataConclusao}
                            status={tarefa.status}
                            importancia={tarefa.importancia}
                        />
                    ))
                }
            </div>
        </div>

    )
}

export default Tarefas;