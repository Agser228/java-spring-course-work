import axios from "axios";

const AUTH_API_BASE_URL = "http://localhost:8080/api/v1/auth/";


const roles = [
  "all",
  "parent",
  "worker",
  "admin"
]


export default class AuthService {


    static async login(email, password) {
        // return axios
        //   .post(AUTH_API_BASE_URL + "signin", {
        //     email,
        //     password
        //   })
        //   .then(response => {
        //     if (response.data.accessToken) {
        //       localStorage.setItem("user", JSON.stringify(response.data));
        //     }
    
        //     return response.data;
        //   });

        let role = email;

        // localStorage.setItem("access", JSON.stringify(data));



      }
    
      logout() {
        localStorage.removeItem("user");
      }
    
      static async register(username, email, password) {
        return axios.post(AUTH_API_BASE_URL + "signup", {
          username,
          email,
          password
        });
      }
    
      static getCurrentUser() {
        return JSON.parse(localStorage.getItem('user'));;
      }

}
