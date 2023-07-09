import React from 'react';
import openApi from '../../services/api';
import './Lembrete.css'
import moment from 'moment';

const Lembrete = ({ id, data, mensagem, idTarefa }) => {

    const formatData = (data) => {
        return moment(data).format("DD/MM/yyyy");
    }

    const deleteLembrete = async () => {
        try {
            const respose = await openApi.delete(`/lembretes/${id}`);
            if(respose.status === 200) {
                window.location.reload();
                alert(`Lembrete ${id} deletado!`);
            }
        } catch (err) {
            console.log(err);
        }
    }

    return (
        <div className="divTag divLembrete">
            <p><strong>Id:</strong> {id}</p>
            <p><strong>Data:</strong> {formatData(data)}</p>
            <p><strong>Mensagem:</strong> {mensagem}</p>
            <p><strong>Tarefa:</strong> {idTarefa}</p>
            <div>
                <img style={{ cursor: "pointer" }} onClick={deleteLembrete} className='icone' alt='Ícone excluir tag' src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAWklEQVR4nGNgGAWDGBxnYGD4j4aPUcvww1gMJxcfHiiLD1ErNIYv+E8lPGoxQTAa1P9HExfDaHZiGC1AGEaLTKLAyCsyH1PB0kfkWOxJoeUgSz3IsXgUDA8AAHlcbV33qhrwAAAAAElFTkSuQmCC" />
            </div>
        </div>
    )
}

export default Lembrete;