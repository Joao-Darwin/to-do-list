import React from 'react'

const Categoria = ({ id, nome }) => {
    return (
        <div className='divCategoria'>
            <div>
                <p>Nome: {nome}</p>
            </div>
            <div>
                <img className='icone' alt='Ícone excluir tarefa' src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAWklEQVR4nGNgGAWDGBxnYGD4j4aPUcvww1gMJxcfHiiLD1ErNIYv+E8lPGoxQTAa1P9HExfDaHZiGC1AGEaLTKLAyCsyH1PB0kfkWOxJoeUgSz3IsXgUDA8AAHlcbV33qhrwAAAAAElFTkSuQmCC" />
            </div>
        </div>
    )
}

export default Categoria;