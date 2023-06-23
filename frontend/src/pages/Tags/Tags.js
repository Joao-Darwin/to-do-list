import React, { useEffect, useState } from "react";
import openApi from "../../services/api";
import Tag from "../../components/Tag/Tag";
import "./Tags.css"
import FormTag from "../../components/FormTag/FormTag";

const Tags = () => {
    const [tags, setTags] = useState([]);
    const [showCriarTag, setShowCriarTag] = useState(false);

    const handleShowCriarTag = () => {
        if(!showCriarTag) {
            setShowCriarTag(true);
        } else {
            setShowCriarTag(false);
        }
    }

    useEffect(() => {
        const loadTags = async () => {
            const { data } = await openApi.get("/tag");
            setTags(data);
        }
        loadTags();
    }, [])

    return (
        <div>
            <h1>Tags</h1>
            {showCriarTag ? (
                <FormTag cancelCriarTag={handleShowCriarTag}/>
            ) : (
                <>
                    <button className='buttonForm buttonFormCategoria' type='button' value={"Criar"} onClick={handleShowCriarTag}>Criar Tag</button>
                    <div className="divAllTags">
                        {tags.length > 0 ? (
                            tags.map((value) => {
                                return <Tag key={value.id} id={value.id} name={value.nome} />
                            })
                        ) : (
                            <p>Você não possui nenhuma Tag!</p>
                        )}
                    </div>
                </>
            )}
        </div>
    )
}

export default Tags;