import React from 'react'
import './SideBar.css'
import { Link } from 'react-router-dom';

const SideBar = ({ handleSideBar }) => {
    return (
        <div className='divSideBar'>
            <img className='iconeFecharMenu' onClick={handleSideBar} alt='ícone de fechar' src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADAAAAAwCAYAAABXAvmHAAAACXBIWXMAAAsTAAALEwEAmpwYAAADXklEQVR4nO2Z2U7bUBCGeZa2dGULhITEWciCs0GgZSlIVcVFH6A3tOx7xXNVRaLqK6BSEi/ZbJaEq5JkqnGUioJrH09Q6wuPNFfxxffZv8+ZE3d1OeWUU07Zsq6y85ladkG8yi5AbWIeauPYr6GWwZ6Dahp7Fqop7BmoJmfgMjHdav5Vq8dean0Rn2p1bBIuothZOI9gT8D5KPY4nIexM3AWysBZMN3qQArOuJSgcqmUZYHaxLxgA3hQuSQovkSe8AT+M3ygBa/6E6D6EkB5AraBV308QcBG8MrIGEXAPvCKlyJgI3jFG6cI2Ade8RAEWOHV+BSIkXEoRbPM8IVAEvJ+HspckgleGY5RBMzhK/FJOH3zDmpH30Ba2wU5nDGFl7gECMvbUDv8CicziyD7eVP4ijtKEGC48wh/raiA1azXQdr8BFI4/Vd4keNBXNvTrsW6rijwffotlEZ4Q3iigHHmMTZ452+WJrGxD1IoZQrfruqXI8h5YobwlaEIQcDkhcXMY2xuA/2WCCZN4Zv1OghLGyB5Y4bwlcFR6wIsqw1mXlq/CwaNBkjbByBwiRb8qo5oowHi+j7kPVFT+DJZgGGpRAlR70mgxNbBvcCXXWGCgIV1Xg6ldUGh0dRgO4UvD4SIAhY2KTmYAnF1567EPcCX+ykChB1WCiRBXNnR3oE78M0mGb7cH6QJWB0PcJPSoqQjgHFCgZw7ahm+1EcQIMObRWhtD3JDEUvwpd4AUaBDeIzN7Ti1JHbh1BVmhi/1cgSBTuHbL+yHTd3fhNVdyKEEA3yphyLAAM+ySeWHo5Bf2tCXWNmGH/1BU/jiCz9FwHwkxqlSdzxY2fljtcm7IyB83NK99vT9MggoYQBffO6zLmB2GMF5HkdiM/j2apMbDOvG6fLzIZz0cIbwRAHjkxQeRk5mF7WR2Ay+vdpg5m/G6We5AseZOZD7AobwxWcjBAGGP50K/oQ2z1cPj7SpkmWTyg2EtNjgnT/OzIHAAF986qUImP9jhicpPIzgPM8yErdXG8w8xkZmhC+QBDo4gFvdpEom8IUnHoqAfeALjwkCdoIvdA8TBGwEL3e7iQI2gZcfUQRsBC8/HCIIaF9G7AEvP3BZ/8CBn3VUPy/YAV5+6EpaFnDKKaec6voX9QukVjNwcptqWQAAAABJRU5ErkJggg=="></img>
            <div className='divLinks'>
                <Link to={""} className='buttonFormMenu'>
                    <p>Home</p>
                </Link>
                <Link to={"/tarefas"} className='buttonFormMenu'>
                    <p>Tarefas</p>
                </Link>
                <Link to={"/categoria"} className='buttonFormMenu'>
                    <p>Categorias</p>
                </Link>
                <Link to={"/tag"} className='buttonFormMenu'>
                    <p>Tags</p>
                </Link>
            </div>
        </div>
    )
}

export default SideBar;