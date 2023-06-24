import axios from 'axios'

const openApi = axios.create({
    baseURL: "https://project-oo-production.up.railway.app"
})

export default openApi;