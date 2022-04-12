import axios from "axios";

const SCHEMA_API_BASE_URL = "http://localhost:8080/api/v1/schema/";

export default class SchemaService {

    static async getSchema(entity) {
        let res = await axios.get(SCHEMA_API_BASE_URL + entity);
        return res.data.data[entity];
    }
}