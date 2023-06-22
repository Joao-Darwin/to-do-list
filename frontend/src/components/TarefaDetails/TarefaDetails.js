import React from 'react';
import './TarefaDetails.css'

const TarefaDetails = ({idTarefa, nomeTarefa, descricaoTarefa, dataCricaoTarefa, dataConclusaoTarefa, importanciaTarefa, statusTarefa, categoriaTarefa, closeDetailsTarefa}) => {
    return (
        <div className='divTarefaDetails'>
            <p>Details</p>
            <p>{idTarefa}</p>
            <p>{nomeTarefa}</p>
            <p>{descricaoTarefa}</p>
            <p>{dataCricaoTarefa}</p>
            <p>{dataConclusaoTarefa}</p>
            <p>{importanciaTarefa}</p>
            <p>{statusTarefa}</p>
            <p>{categoriaTarefa.nome}</p>
            <button onClick={closeDetailsTarefa}>fechar</button>
        </div>
    )
}

export default TarefaDetails;