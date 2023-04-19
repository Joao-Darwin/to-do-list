import React, { useState } from 'react'

import "./FormTarefa.css"

const importanciasGraus = ['URGENTE', 'ALTA', 'MEDIA', 'BAIXA'];

const FormTarefa = () => {
    const [nomeAtividade, setNomeAtividade] = useState('');
    const [descricao, setDescricao] = useState('');
    const [dataConclusao, setDataConclusao] = useState('');
    const [importancia, setImportancia] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();
        console.log("Nome: ", nomeAtividade);
        console.log("Descrição: ", descricao);
        console.log("Data Conclusão: ", dataConclusao);
        console.log("Importância: ", importancia);

        cleanInputs();
    }

    const cleanInputs = () => {
        setNomeAtividade('');
        setDescricao('');
        setDataConclusao('');
        setImportancia('');
    }

    return (
        <>
            <form className='form' onSubmit={handleSubmit}>
                <label className='labels'>
                    <input className='inputText' type='text' placeholder='Nome Atividade' onChange={(e) => setNomeAtividade(e.target.value)} value={nomeAtividade}></input>
                </label>
                <label className='labels'>
                    <textarea cols="70" rows="3" placeholder="Descrição da Tarefa" onChange={(e) => setDescricao(e.target.value)} value={descricao}></textarea>
                </label>
                <div style={{display: 'flex', marginLeft: '15px'}}>
                    <label className='labels'>
                        <span>Data de Conclusão: </span>
                        <input className='inputData' type='date' placeholder='Data Conclusão' onChange={(e) => setDataConclusao(e.target.value)} value={dataConclusao}></input>
                    </label>
                    <label className='labels'>
                        <span>Importância: </span>
                        <select name='importancia' className='inputSelect' onChange={(e) => setImportancia(e.target.value)} value={importancia}>
                            {importanciasGraus.map((value) => {
                                return <option className='importanciaSelect' value={value}>{value}</option>
                            })}
                        </select>
                    </label>
                </div>
                <input className='buttonForm' type='submit' value="Adicionar tarefa"/>
            </form>
        </>
    )
}

export default FormTarefa;