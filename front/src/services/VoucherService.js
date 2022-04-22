import axios from "axios";

const VOUCHER_API_BASE_URL = "http://localhost:8080/api/v1/voucher/";

export default class VoucherService {

    static async createVoucher(voucher) {
        let res = await axios.post(VOUCHER_API_BASE_URL, voucher);
        console.log(voucher);
        console.log(res);
        return res;
    }

    static async getAllVouchers() {
        let res = await axios.get(VOUCHER_API_BASE_URL + "list");
        return res.data.data.voucher;
    }

    static async getVoucherByUserId(userId) {
        let res = await axios.get(VOUCHER_API_BASE_URL + "exist", {params:{
            userId
        }});
        return res.data.data.voucher;
    }

    static async acceptVoucher(id) {
        let res = await axios.post(`${VOUCHER_API_BASE_URL}accept/${id}`)
        return res.data.data.voucher;
    }

    static async rejectVoucher(id) {
        let res = await axios.post(`${VOUCHER_API_BASE_URL}reject/${id}`)
        return res.data.data.voucher;
    }

    static async getAllVouchersByStatus(status) {
        let res = await axios.get(`${VOUCHER_API_BASE_URL}`, {params: {
            status
        }})
        return res.data.data.voucher;
    }

}
