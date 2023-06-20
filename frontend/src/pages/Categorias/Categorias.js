import React, { useEffect, useState } from 'react'
import openApi from '../../services/api';
import Categoria from '../../components/Categoria/Categoria';
import "./Categorias.css"
import FormCategoria from '../../components/FormCategoria/FormCategoria';

const Categorias = () => {

    const [categorias, setCategorias] = useState([]);
    const [showCriarCategoria, setShowCriarCategoria] = useState(false);

    const cancelCriarCategoria = () => {
        setShowCriarCategoria(false);
    }

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
            {showCriarCategoria ? (
                <FormCategoria cancelCriarCategoria={cancelCriarCategoria}/>
            ) : (
                <>
                    <button className='buttonForm buttonFormCategoria' type='button' value={"Criar"} onClick={() => setShowCriarCategoria(true)}>Criar Categoria</button>
                    <div className='divAllCategories'>
                        {categorias.length > 0 ? (
                            categorias.map((categoria, index) => {
                                return <Categoria id={categoria.id} nome={categoria.nome} key={categoria.nome} />
                            })
                        ) : (
                            <p>Você não possui nehuma Categoria!</p>
                        )}
                    </div>
                </>
            )}
        </div>
    )
}

export default Categorias;