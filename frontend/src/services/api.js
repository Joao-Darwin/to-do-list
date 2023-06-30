import axios from 'axios'

const openApi = axios.create({
    baseURL: "https://project-oobackend-production.up.railway.app"
})

export default openApi;