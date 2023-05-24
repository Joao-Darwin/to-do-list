import axios from 'axios'

const openApi = axios.create({
    baseURL: "http://localhost:8080"
})

export default openApi;