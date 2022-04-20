import axios from "axios";

const WORKER_API_BASE_URL = "http://localhost:8080/api/v1/worker/";

export default class WorkerService {

    static async getAllWorkers() {
        let res = await axios.get(WORKER_API_BASE_URL + "list");
        return res.data.data.worker;
    }

    static async createWorker(worker) {
        let res = await axios.post(WORKER_API_BASE_URL + "save", worker);
        return res.data.data.worker;
    }

    static async update(id, worker) {
        let res = await axios.put(WORKER_API_BASE_URL + "update/" + id, worker)
        return res.data.data.updated;
    }

    static async delete(id) {
        let res = await axios.delete(WORKER_API_BASE_URL + "delete/" + id)
        return res.data.data.deleted;
    }

    static async getAllCounselors() {
        let res = await axios.get(WORKER_API_BASE_URL, {params: {
            position: 'COUNSELOR'
        }});
        return res.data.data.workers;
    }


    static getWorkerById(id) {
        return axios.get(WORKER_API_BASE_URL + "get/" + id);
    }

}
