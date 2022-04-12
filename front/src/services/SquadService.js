import axios from "axios"; 

const SQUAD_API_BASE_URL = "http://localhost:8080/api/v1/squad/";

export default class SquadService {
    static async getAllSquads() {
        let res = await axios.get(SQUAD_API_BASE_URL + "list");
        return res.data.data.squad;
    }
}