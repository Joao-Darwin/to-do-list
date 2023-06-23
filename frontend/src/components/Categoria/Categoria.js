import React from 'react'
import "./Categoria.css"
import openApi from '../../services/api'

const Categoria = ({ id, nome }) => {

    const deleteCategoria = async () => {
        try {
            let response = await openApi.delete(`/categorias/${id}`);
            if(response.status === 200) {
                window.location.reload();
                alert("Categoria excluída!");
            }
        } catch (err) {
            console.log(err);
        }
    }

    return (
        <div className='divCategoria'>
            <div>
                <p>Nome: <strong>{nome}</strong></p>
            </div>
            <div>
                <img style={{cursor: "pointer"}} onClick={deleteCategoria} className='icone' alt='Ícone excluir categoria' src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAWklEQVR4nGNgGAWDGBxnYGD4j4aPUcvww1gMJxcfHiiLD1ErNIYv+E8lPGoxQTAa1P9HExfDaHZiGC1AGEaLTKLAyCsyH1PB0kfkWOxJoeUgSz3IsXgUDA8AAHlcbV33qhrwAAAAAElFTkSuQmCC" />
            </div>
        </div>
    )
}

export default Categoria;