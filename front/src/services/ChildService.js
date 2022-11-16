import axios from "axios";

const CHILD_API_BASE_URL = "http://localhost:8080/api/v1/child/";

export default class ChildService {

    static async getAllChildren() {
        let res = await axios.get(CHILD_API_BASE_URL + "list");
        return res.data.data.child
    }

    static createChild(child) {
        return axios.post(CHILD_API_BASE_URL + "create", child);
    } 

    static getChildById(id) {
        return axios.get(CHILD_API_BASE_URL + "get/" + id);
    }

    static async updateChild(id, child) {
        let res = await axios.put(CHILD_API_BASE_URL + "update/"+ id, child);
        return res.data.data.updated;
    }

    static async deleteChild(id) {
        let res =  await axios.delete(CHILD_API_BASE_URL +"delete/"+ id);
        return res.data.data.deleted;
    }

}
