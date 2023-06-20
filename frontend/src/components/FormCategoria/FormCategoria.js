import React, { useState } from 'react';
import openApi from '../../services/api';
import "./FormCategoria.css"

const FormCategoria = ({ cancelCriarCategoria }) => {

    const [nomeCategoria, setNomeCategoria] = useState();

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await openApi.post("/categoria", {
                nome: nomeCategoria
            })
            if(response.status === 201) {
                alert("Categoria criada!");
            }
            window.location.reload();
        } catch (err) {
            console.log(err.message)
        }
    }

    return (
        <div className='divCriarCategoria'>
            <h2>Criar Categoria</h2>
            <form onSubmit={handleSubmit}>
                <label>
                    <input autoFocus     type='text' className='inputText inputTextCriarCategoria' placeholder='Digite o nome da Categoria' onChange={(e) => setNomeCategoria(e.target.value)}></input>
                </label>
                <div className='divButtons'>
                    <input onClick={cancelCriarCategoria} className='buttonFormUpdate buttonFormCancel' type='button' value="Cancelar"></input>
                    <input className='buttonFormUpdate buttonForm' type='submit' value="Criar" />
                </div>
            </form>
        </div>
    )
}

export default FormCategoria;