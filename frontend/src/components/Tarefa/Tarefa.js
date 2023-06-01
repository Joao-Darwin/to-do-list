import React, { useState } from 'react';
// import IconeExcluir from "../../assets/iconeExcluir.jpeg"

import "./Tarefa.css"
import openApi from '../../services/api';

const Tarefa = ({ id, nome, descricao, dataCricao, dataConclusao, importancia, status }) => {

    const [colorBackground] = useState(() => {
        if (status === 'PRA_FAZER') {
            return '#ffffff';
        } else if (status === 'EM_PROGRESSO') {
            return '#FFD700';
        } else if (status === 'CONCLUIDA') {
            return '#2EFF82';
        } else {
            return '#DC143C';
        }
    });

    const deleteTarefa = async () => {
        try {
            const res = await openApi.delete(`tarefa/${id}`);
            window.location.reload();
            if(res.status === 200) {
                alert("Tarefa deletada!");
            }
        } catch(err) {
            console.log(err);
        }
    }

    // Formatar o Status da Tarefa
    const statusFormat = (status) => {
        if(status === 'PRA_FAZER') {
            return "A FAZER";
        } else if (status === 'EM_PROGRESSO') {
            return "EM PROGRESSO";
        } else if(status === 'CONCLUIDA') {
            return "CONCLUÍDA";
        } else {
            return "CANCELADA";
        }
    }

    // Formatar a Data DD/MM/YYYY
    const dataConclusaoFormat = (data) => {
        let date = new Date(data);
        let novaData = `${(date.getDate() + 1) < 10 ? (`0${date.getDate() + 1}`) : (date.getDate() + 1)}/${(date.getMonth() + 2) < 10 ? (`0${date.getMonth() + 2}`) : (date.getMonth() + 2)}/${date.getFullYear()}`
        return novaData;
    }

    return (
        <div className='tarefa' style={{backgroundColor: colorBackground}}>
            <div>
                <p>Nome: <strong>{nome}</strong></p>
                <p>Status: <strong>{statusFormat(status)}</strong></p>
                <p>Data conclusão: <strong>{dataConclusaoFormat(dataConclusao)}</strong></p>
            </div>
            <div >
                <img onClick={deleteTarefa} className='icone' alt='Ícone excluir tarefa' src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAWklEQVR4nGNgGAWDGBxnYGD4j4aPUcvww1gMJxcfHiiLD1ErNIYv+E8lPGoxQTAa1P9HExfDaHZiGC1AGEaLTKLAyCsyH1PB0kfkWOxJoeUgSz3IsXgUDA8AAHlcbV33qhrwAAAAAElFTkSuQmCC" />
                <img className='icone' alt='Ícone atualizar farefa' src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAyElEQVR4nO3WP2oCQRSA8Z/rJfQWggew8RoWYuElZNOn1ANoKqvYClbeIRewtAgklZDGlYURtkuQnQnIfPBgmCk+3ps3f3hSOpjhgB1GKaQF1vjEAkv8xJbfpRXmjfkV3lNI67hgHNZK7FNIm/J5KPs0lbQZm9BwrUo3v0i36GbpI+TyVrmR2qDI51S+kVqgyI0kYiPVvPzhEa+3oXU+8J1a2sMVAxxj/xyaTHAK4yG+Ymd65w3nIK9C2cvYUngN8jrzfmzZv3ID+uLBiRXSV1IAAAAASUVORK5CYII="></img>
            </div>
        </div>
    )
}

export default Tarefa;