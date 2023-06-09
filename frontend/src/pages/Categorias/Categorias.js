import React, { useEffect, useState } from 'react'
import openApi from '../../services/api';
import Categoria from '../../components/Categoria/Categoria';
import "./Categorias.css"

const Categorias = () => {

    const [categorias, setCategorias] = useState([]);

    useEffect(() => {
        async function loadCategorias() {
            const allCategories = (await openApi.get("/categoria")).data;
            setCategorias(allCategories);
        }
        loadCategorias();
    }, []);

    return (
        <div>
            <h1>Categorias</h1>
            <div className='divAllCategories'>
                {categorias.length > 0 ? (
                    categorias.map((categoria, index) => {
                        return <Categoria id={categoria.id} nome={categoria.nome} key={categoria.nome}/>
                    })
                ) : (
                    <p>Você não possui nehuma Categoria!</p>
                )}
            </div>
        </div>
    )
}

export default Categorias;