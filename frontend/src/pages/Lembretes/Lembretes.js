import React, { useState } from 'react';
import openApi from '../../services/api';
import Lembrete from '../../components/Lembrete/Lembrete';

const Lembretes = () => {

    const [lembretes, setLembretes] = useState([]);

    useState(() => {
        async function renderLembretes () {
            try {
                const response = await openApi.get("/lembretes");
                console.log(response);
                setLembretes(response.data);
            } catch (err) {
                console.log(err);
            }
        }
        renderLembretes();
    }, []);

    return (
        <div>
            <h2>Lembretes</h2>
            <button className='buttonForm buttonFormCategoria' type='button' value={"Criar"}>Definir Lembrete</button>
            {lembretes.length > 0 ? (
                lembretes.map((lembrete) => {
                    return <Lembrete id={lembrete.id} data={lembrete.dataLembrete} mensagem={lembrete.mensagem} idTarefa={lembrete.tarefa.id}/>
                })
            ) : (
                <p>Você não possui nenhum lembrete!</p>
            )}
        </div>
    )
}

export default Lembretes;