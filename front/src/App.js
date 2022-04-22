import React, { useEffect, useState } from 'react';
import { BrowserRouter } from "react-router-dom";
import AppRouter from './components/AppRouter';
import Navbar from "./components/UI/navbar/Navbar";
import { AuthContext } from "./context";

function App() {
  
  const [isAuth, setIsAuth] = useState(false);
  const [isLoading, setIsLoading] = useState(true);
  const [access, setAccess] = useState("all");
  const [userId, setUserId] = useState(null);
  useEffect( () => {
    if (localStorage.getItem("auth")) {
      setIsAuth(true);
    } else {
      setIsAuth(false)
    }
    
    if (localStorage.getItem("access")) {
      setAccess(localStorage.getItem("access"));
    } else {
      localStorage.setItem("access", "all");
      setAccess("all");
    }

    if (localStorage.getItem("userId")) {
      setUserId(localStorage.getItem("userId"));
    }
    setIsLoading(false);
  }, [])


  return (
    <div>
      <AuthContext.Provider value = {{
        access,
        setAccess,
        isAuth,
        setIsAuth,
        isLoading,
        userId,
        setUserId
      }}>
            <BrowserRouter>
              <Navbar/>
              <AppRouter/>
            </BrowserRouter>
            {/* <Footer/> */}
        </AuthContext.Provider>
    </div>
  );
}

export default App;
