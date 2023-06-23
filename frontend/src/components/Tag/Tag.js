import React from "react";
import "./Tag.css"
import openApi from "../../services/api";

const Tag = ({id, name}) => {

    const deleteTag = async () => {
        try {
            const res = await openApi.delete(`/tag/${id}`);
            if(res.status === 200) {
                window.location.reload();
                alert("Tag excluida");
            }
        }catch (err) {
            console.log(err);
        }
    }

    return (
        <div className="divTag">
            <p><strong>{name.toUpperCase()}</strong></p>
            <div>
                <img style={{cursor: "pointer"}} onClick={deleteTag} className='icone' alt='Ícone excluir tag' src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAWklEQVR4nGNgGAWDGBxnYGD4j4aPUcvww1gMJxcfHiiLD1ErNIYv+E8lPGoxQTAa1P9HExfDaHZiGC1AGEaLTKLAyCsyH1PB0kfkWOxJoeUgSz3IsXgUDA8AAHlcbV33qhrwAAAAAElFTkSuQmCC" />
            </div>
        </div>
    )
}

export default Tag;