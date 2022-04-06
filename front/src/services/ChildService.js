import axios from "axios";

const CHILD_API_BASE_URL = "http://localhost:8080/api/v1/child/";

class ChildService {

    getAllChildren() {
        return axios.get(CHILD_API_BASE_URL + "list");
    }

    createChild(child) {
        return axios.post(CHILD_API_BASE_URL + "create", child);
    } 

    getChildById(id) {
        return axios.get(CHILD_API_BASE_URL + "get/" + id);
    }

    updateChild(id, child) {
        return axios.put(CHILD_API_BASE_URL +id, child);
    }

    deleteChild(id) {
        return axios.delete(CHILD_API_BASE_URL + id);
    }

}

export default new ChildService();