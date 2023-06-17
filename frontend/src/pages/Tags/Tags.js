import React, { useEffect, useState } from "react";
import openApi from "../../services/api";
import Tag from "../../components/Tag/Tag";
import "./Tags.css"

const Tags = () => {
    const [tags, setTags] = useState([]);

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
            <div className="divAllTags">
                {tags.length > 0 ? (
                    tags.map((value) => {
                        return <Tag key={value.id} id={value.id} name={value.nome} />
                    })
                ) : (
                    <p>Você não possui nenhuma Tag!</p>
                )}
            </div>
        </div>
    )
}

export default Tags;