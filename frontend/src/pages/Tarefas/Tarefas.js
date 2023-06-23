import React, { useEffect, useState } from 'react';
import Tarefa from '../../components/Tarefa/Tarefa';
import "./Tarefa.css"
import openApi from '../../services/api';

const Tarefas = () => {

    const [tarefas, setTarefas] = useState([]);

    // Carrega as Tarefas
    useEffect(() => {
        const FindAllTarefas = async () => {
            const tarefas = (await openApi.get("/tarefas")).data;
            setTarefas(tarefas);
        }
        FindAllTarefas();
    }, [])

    return (
        <div>
            <h1>Tarefas</h1>
            <div className='divTarefas'>
                {(tarefas.length === 0) ? (
                    <span>Você não possui nenhuma Tarefa!</span>
                ) : (
                    tarefas.map((tarefa) => (
                        <Tarefa
                            key={tarefa.id}
                            id={tarefa.id}
                            nome={tarefa.nome}
                            descricao={tarefa.descricao}
                            dataCricao={tarefa.dataCriacao}
                            dataConclusao={tarefa.dataConclusao}
                            status={tarefa.status}
                            importancia={tarefa.importancia}
                            categoria={tarefa.categoria === null ? 0 : tarefa.categoria}
                        />
                    ))
                )}
            </div>
        </div>

    )
}

export default Tarefas;