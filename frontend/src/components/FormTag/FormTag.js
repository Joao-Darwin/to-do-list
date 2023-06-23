import React, { useState } from 'react';
import './FormTag.css'
import openApi from '../../services/api';

const FormTag = ({cancelCriarTag}) => {

    const [tagName, setTagName] = useState('');

    const handleSubmit = async () => {
        try {
            const response = await openApi.post('/tags', {
                nome: tagName
            })
            if(response.status === 200) {
                alert("Tag criada!");
            }
        } catch (err) {
            console.log(err);
        }
    }

    return (
        <div className='divCriarCategoria'>
            <h2>Criar Tag</h2>
            <form onSubmit={handleSubmit}>
                <label>
                    <input autoFocus type='text' className='inputText inputTextCriarCategoria' placeholder='Digite o nome da Tag' onChange={(e) => setTagName(e.target.value)} value={tagName}></input>
                </label>
                <div className='divButtons'>
                    <input onClick={cancelCriarTag} className='buttonFormUpdate buttonFormCancel' type='button' value="Cancelar"></input>
                    <input className='buttonFormUpdate buttonForm' type='submit' value="Criar" />
                </div>
            </form>
        </div>
    )
}

export default FormTag;