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

    static updateChild(id, child) {
        return axios.put(CHILD_API_BASE_URL + id, child);
    }

    static deleteChild(id) {
        return axios.delete(CHILD_API_BASE_URL + id);
    }

}
