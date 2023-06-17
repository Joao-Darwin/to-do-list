import React from 'react'
import "./TopBar.css"

const TopBar = ({handleSideBar}) => {
    return (
        <div className='divTopBar'>
            <img className='iconeTopBar' onClick={handleSideBar} alt='Ícone de menu' src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAlElEQVR4nO3YMQrDMAxG4Tf17KW9lU2OkgukB1BpMGTpYmew2rwPNBqk2MMfgSRJf2oBIknVkQEiWXXbD87G5QeotU77+qWUUzfwSvDuo9U2MsAzQePR6jEywA24A+vExtfWw6cXSZ3MQpiFwiwUZiHMQmEWki5qSfAnFq3cC03DcQvd9oM/P0B1L4R7IdwLSZL47g3Yhae2WbvEdQAAAABJRU5ErkJggg=="/>
            <h1>Gerenciador de Tarefas</h1>
            <a href='https://github.com/ifpb-cz-ads/poo-2023-1-ai-Joao-Darwin' target='_blank' rel='noreferrer'><img className='iconeTopBar' alt='Ícone GitHub' src="data:image/png;base64,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"/></a>
        </div>
    )
}

export default TopBar;