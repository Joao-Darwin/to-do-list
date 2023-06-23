import React, { useEffect, useState } from 'react'

import "./FormTarefa.css"
import openApi from '../../services/api';

const importanciasGraus = ['URGENTE', 'ALTA', 'MEDIA', 'BAIXA'];

const hoje = new Date().toISOString().split('T')[0]

const FormTarefa = () => {
    const [nomeAtividade, setNomeAtividade] = useState('');
    const [descricao, setDescricao] = useState('');
    const [dataConclusao, setDataConclusao] = useState('');
    const [importancia, setImportancia] = useState(0);
    const [categoria, setCategoria] = useState(1);

    const handleSubmit = async (event) => {
        event.preventDefault();
        await sendRequest();
        cleanInputs();
    }

    const sendRequest = async () => {
        console.log("Nome: ", nomeAtividade);
        console.log("Descrição: ", descricao);
        console.log("Data conclusão: ", dataConclusao);
        console.log("Importancia: ", importancia);
        console.log("Categoria: ", categoria);
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
            <form className='form formTarefa' onSubmit={handleSubmit}>
                <label className='labels'>
                    <input className='inputText' required type='text' placeholder='Nome Atividade' autoFocus onChange={(e) => setNomeAtividade(e.target.value)} value={nomeAtividade}></input>
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
                </div>
                <img title='Limpar' onClick={cleanInputs} className='iconFormTarefa' alt='limpar inputs' src='data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAwElEQVR4nO3RPwrCMBTH8VxBcXdwFzyAOCj2j7eoeAZv0d0reAodvEBdXHsKu32l8MBQl0dJQqT9wW8JL3zIizE9AqyBWroxoQLc+eYREn5a8GuEvYVx1aHCuOohrPoInKUn89cBFtZrXHWugQ+4z3Zw8E4Dz9pBx52aaAOsgKvjLjVw7uGP91HDmQc4iRpOO5duwAWoFEAls+0dO1kfuJDzUgGXMlt0zlNXcANMpI0Czp3B1vxbAatWnXiAf178AYc2eHO0+zA/AAAAAElFTkSuQmCC'/>
                <input className='buttonForm buttonFormTarefa' type='submit' value="Adicionar tarefa" />
            </form>
        </>
    )
}

export default FormTarefa;