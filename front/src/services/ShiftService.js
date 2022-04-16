import axios from "axios";

const CHILD_API_BASE_URL = "http://localhost:8080/api/v1/shift/";

export default class ShiftService {

    static async getAllShifts() {
        let res = await axios.get(CHILD_API_BASE_URL + "list");
        return res.data.data.shift
    }

}
