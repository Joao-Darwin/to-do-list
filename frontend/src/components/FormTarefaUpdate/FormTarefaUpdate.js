import React, { useEffect, useState } from 'react'
import openApi from '../../services/api';
import './FormTarefaUpdate.css'

const importanciasGraus = ['URGENTE', 'ALTA', 'MEDIA', 'BAIXA'];
const statusGraus = ['PRA_FAZER', 'EM_PROGRESSO', 'CONCLUIDA', 'CANCELADA'];

const hoje = new Date().toISOString().split('T')[0]

function formatDate (data) {
    return data.split('T')[0];
}  

const FormTarefaUpdate = ({ id, nomeTarefa, descricaoTarefa, dataConclusaoTarefa, importanciaTarefa, statusTarefa, categoriaTarefa, cancelUpdate }) => {
 
    console.log(importanciaTarefa)
    const [nome, setNome] = useState(nomeTarefa);
    const [descricao, setDescricao] = useState(descricaoTarefa);
    const [dataConclusao, setDataConclusao] = useState(formatDate(dataConclusaoTarefa));
    const [importancia, setImportancia] = useState(importanciaTarefa);
    const [status, setStatus] = useState(statusTarefa);
    const [categoria, setCategoria] = useState(categoriaTarefa.id);
    const [allCategories, setAllCategories] = useState([]);

    // Requisição para o backend para atualizar a tarefa
    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await openApi.put(`/tarefa/${id}`, {
                "nome": nome,
                "descricao": descricao,
                "dataConclusao": `${dataConclusao}T00:00:00Z`,
                "categoria": {
                    "id": categoria
                },
                "importancia": importancia,
                "status": status
            })
            if (response.status === 200) {
                alert("Tarefa atualizada!");
            }
        } catch (err) {
            console.log(err);
        }
        window.location.reload();
    }

    // Buscar todas as categorias
    useEffect(() => {
        async function findAllCategories() {
            setAllCategories((await openApi.get("/categoria")).data);
        }
        findAllCategories();
    }, [])

    return (
        <div className='divFormTarefaUpdate'>
            <h1>Atualizar Tarefa</h1>
            <form onSubmit={handleSubmit}>
                <label className='labels'>
                    <input className='inputText' required type='text' placeholder='Nome Atividade' autoFocus onChange={(e) => setNome(e.target.value)} value={nome}></input>
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
                        <select name='importancia' className='inputSelect' onChange={(e) => setImportancia(e.target.value)} value={importanciasGraus.indexOf(importancia)}>
                            {importanciasGraus.map((value, index) => {
                                return <option className='importanciaSelect' key={value} value={(index)}>{value}</option>
                            })}
                        </select>
                    </label>
                    <label className='labels'>
                        <span>Categoria</span>
                        <select name='categoria' className='inputSelect' onChange={(e) => setCategoria(e.target.value)} value={categoria}>
                            {
                                allCategories.map((value, index) => {
                                    return <option style={{ textTransform: "uppercase" }} className='importanciaSelect' key={value.nome} value={(value.id)}>{value.nome}</option>
                                })
                            }
                        </select>
                    </label>
                    <label>
                        <span>Status</span>
                        <select name="status" className='inputSelect' onChange={(e) => setStatus(e.target.value)} value={statusGraus.indexOf(status)}>
                            {
                                statusGraus.map((status, index) => {
                                    return <option key={status} value={index}>{status}</option>
                                })
                            }
                        </select>
                    </label>
                </div>
                <input onClick={cancelUpdate} className='buttonFormUpdate buttonFormCancel' type='button' value="Cancelar"></input>
                <input className='buttonFormUpdate buttonForm' type='submit' value="Atualizar" />
            </form>
        </div>
    )
}

export default FormTarefaUpdate;