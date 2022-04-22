import axios from "axios";


const AUTH_API_BASE_URL = "http://localhost:8080/api/v1/auth/";


const roles = [
  "all",
  "PARENT",
  "WORKER",
  "ADMIN"
]


export default class AuthService {

    static async login(email, password) {
      let res = await axios.post(AUTH_API_BASE_URL + "signin", {
            email,
            password
          }); 
      return res.data.data;
    
      }
    
      static async registerWorker(email, password) {
        return axios.post(AUTH_API_BASE_URL + "signup-worker", {
          email,
          password
        });
      }

      static async signUp(email, password) {
        let res = await axios.post(AUTH_API_BASE_URL + "signup", {
          email,
          password
        });

        console.log(res);
        return res.data.data;

      }
    
      static getCurrentUser() {
        return JSON.parse(localStorage.getItem('user'));;
      }

}
