import axios from "axios";

const SHIFT_API_BASE_URL = "http://localhost:8080/api/v1/shift/";

export default class ShiftService {

    static async getAllShifts() {
        let res = await axios.get(SHIFT_API_BASE_URL + "list");
        return res.data.data.shift
    }

    static async createShift(shift) {
        let res = await axios.post(SHIFT_API_BASE_URL + "save", shift);
        return res.data.data.shift;
    }

    static async getAllOpenedShifts() {
        let res = await axios.get(SHIFT_API_BASE_URL, {params: {
            status: 'OPEN'
        }})
        return res.data.data.shift;
    }

    static async update(id, shift) {
        let res = await axios.put(SHIFT_API_BASE_URL + "update/" + id, shift)
        return res.data.data.updated;
    }

    static async delete(id) {
        let res = await axios.delete(SHIFT_API_BASE_URL + "delete/" + id)
        return res.data.data.deleted;
    }
 
}
