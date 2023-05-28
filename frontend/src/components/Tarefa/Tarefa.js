import React from 'react';
// import IconeExcluir from "../../assets/iconeExcluir.jpeg"

import "./Tarefa.css"

const Tarefa = ({ id, nome, descricao, dataCricao, dataConclusao, importancia, status }) => {
    return (
        <div className='tarefa'>
            <div>
                <p>Nome: <strong>{nome}</strong></p>
                <p>Status: <strong>{status}</strong></p>
                <p>Data conclusão: <strong>{dataConclusao}</strong></p>
            </div>
            <div >
                <img className='icone' alt='Ícone excluir tarefa' src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAWklEQVR4nGNgGAWDGBxnYGD4j4aPUcvww1gMJxcfHiiLD1ErNIYv+E8lPGoxQTAa1P9HExfDaHZiGC1AGEaLTKLAyCsyH1PB0kfkWOxJoeUgSz3IsXgUDA8AAHlcbV33qhrwAAAAAElFTkSuQmCC" />
                <img className='icone' alt='Ícone atualizar farefa' src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAyElEQVR4nO3WP2oCQRSA8Z/rJfQWggew8RoWYuElZNOn1ANoKqvYClbeIRewtAgklZDGlYURtkuQnQnIfPBgmCk+3ps3f3hSOpjhgB1GKaQF1vjEAkv8xJbfpRXmjfkV3lNI67hgHNZK7FNIm/J5KPs0lbQZm9BwrUo3v0i36GbpI+TyVrmR2qDI51S+kVqgyI0kYiPVvPzhEa+3oXU+8J1a2sMVAxxj/xyaTHAK4yG+Ymd65w3nIK9C2cvYUngN8jrzfmzZv3ID+uLBiRXSV1IAAAAASUVORK5CYII="></img>
            </div>
        </div>
    )
}

export default Tarefa;