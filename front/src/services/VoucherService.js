import axios from "axios";

const VOUCHER_API_BASE_URL = "http://localhost:8080/api/v1/voucher/";

export default class VoucherService {

    static async createVoucher(voucher) {
        let res = await axios.post(VOUCHER_API_BASE_URL, voucher);
        return res;
    } 

}
