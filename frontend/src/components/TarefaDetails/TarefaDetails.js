import React from 'react';
import './TarefaDetails.css'

const TarefaDetails = ({ idTarefa, nomeTarefa, descricaoTarefa, dataCricaoTarefa, dataConclusaoTarefa, importanciaTarefa, statusTarefa, categoriaTarefa, closeDetailsTarefa }) => {
    return (
        <div className='divTarefaDetails'>
            <h2>Detalhes da Tarefa <strong>#{idTarefa}</strong></h2>
            <div className="detailsItem">
                <strong>Nome da Tarefa:</strong>
                <p>{nomeTarefa}</p>
            </div>
            <div className="detailsItem">
                <strong>Descrição:</strong>
                <p>{descricaoTarefa}</p>
            </div>
            <div style={{display: 'flex', justifyContent: 'space-between', width: '50%', margin: 'auto'}}>
                <div className="detailsItem">
                    <strong>Data de Criação:</strong>
                    <p>{dataCricaoTarefa}</p>
                </div>
                <div className="detailsItem">
                    <strong>Data de Conclusão:</strong>
                    <p>{dataConclusaoTarefa}</p>
                </div>
            </div>
            <div className="detailsItem">
                <strong>Importância:</strong>
                <p>{importanciaTarefa}</p>
            </div>
            <div className="detailsItem">
                <strong>Status:</strong>
                <p>{statusTarefa.replace('_', " ")}</p>
            </div>
            <div className="detailsItem">
                <strong>Categoria:</strong>
                <p>{categoriaTarefa.nome}</p>
            </div>
            <button className='buttonFormUpdate buttonFormCancel' onClick={closeDetailsTarefa}>Fechar</button>
        </div>
    )
}

export default TarefaDetails;