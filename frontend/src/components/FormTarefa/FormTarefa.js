import React, { useEffect, useState } from 'react'

import "./FormTarefa.css"
import openApi from '../../services/api';

const importanciasGraus = ['URGENTE', 'ALTA', 'MEDIA', 'BAIXA'];

const hoje = new Date().toISOString().split('T')[0]

const FormTarefa = () => {
    const [nomeAtividade, setNomeAtividade] = useState('');
    const [descricao, setDescricao] = useState('');
    const [dataConclusao, setDataConclusao] = useState('');
    const [importancia, setImportancia] = useState('');
    const [categoria, setCategoria] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();
        await sendRequest();
        cleanInputs();
    }

    const sendRequest = async () => {
        try {
            let response = await openApi.post("/tarefa", {
                "nome": nomeAtividade,
                "descricao": descricao,
                "dataConclusao": `${dataConclusao}T00:00:00Z`,
                "importancia": importancia,
                "categoria": {
                    "id": categoria
                }
            });

            if (response.status === 201) {
                alert("Tarefa criada com Sucesso!");
            }
        } catch (err) {
            console.log(err);
        }
    }

    const cleanInputs = () => {
        setNomeAtividade('');
        setDescricao('');
        setDataConclusao('');
        setImportancia('');
    }

    let [allCategories, setAllCategories] = useState([]);
    useEffect(() => {
        async function findAllCategories() {
            setAllCategories((await openApi.get("/categoria")).data);
        }
        findAllCategories();
    }, [])

    return (
        <>
            <form className='form' onSubmit={handleSubmit}>
                <label className='labels'>
                    <input className='inputText' type='text' placeholder='Nome Atividade' autoFocus onChange={(e) => setNomeAtividade(e.target.value)} value={nomeAtividade}></input>
                </label>
                <label className='labels'>
                    <textarea cols="70" rows="3" placeholder="Descrição da Tarefa" onChange={(e) => setDescricao(e.target.value)} value={descricao}></textarea>
                </label>
                <div className='divInputsSelect'>
                    <label className='labels'>
                        <span>Data de Conclusão: </span>
                        <input className='inputData' type='date' placeholder='Data Conclusão' min={hoje} onChange={(e) => setDataConclusao(e.target.value)} value={dataConclusao}></input>
                    </label>
                    <label className='labels'>
                        <span>Importância: </span>
                        <select name='importancia' className='inputSelect' onChange={(e) => setImportancia(e.target.value)} value={importancia}>
                            {importanciasGraus.map((value) => {
                                return <option className='importanciaSelect' key={value} value={value}>{value}</option>
                            })}
                        </select>
                    </label>
                    <label className='labels'>
                        <span>Categoria</span>
                        <select name='categoria' className='inputSelect' onChange={(e) => setCategoria(e.target.value)} value={categoria}>
                            {
                                allCategories.map((value, index) => {
                                    return <option style={{textTransform: "uppercase"}} className='importanciaSelect' key={value.nome} value={index}>{value.nome}</option>
                                })
                            }
                        </select>
                    </label>
                </div>
                <input className='buttonForm' type='submit' value="Adicionar tarefa" />
            </form>
        </>
    )
}

export default FormTarefa;