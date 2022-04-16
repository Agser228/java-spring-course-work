import { BrowserRouter as Routes, Route, useLocation, useParams } from 'react-router-dom';
// import './App.css';
import CreateChildComponent from './components/CreateChildComponent';
import HeaderComponent from './components/HeaderComponent';
import ListChildrenComponent from './components/ListChildrenComponent';
import Footer from './components/UI/footer/Footer';
import ViewChildComponent from './components/ViewChildComponent';
import Squads from './pages/Squads';
import Voucher from './pages/Voucher';
import Children from './pages/Children';
import { BrowserRouter } from "react-router-dom"
import AppRouter from './components/AppRouter';
import Navbar from "./components/UI/navbar/Navbar";
import { AuthContext } from "./context";
import {useState, useEffect} from 'react'
import React from 'react';

function App() {
  
  const [isAuth, setIsAuth] = useState(false);
  const [isLoading, setIsLoading] = useState(true);
  useEffect( () => {
    if (localStorage.getItem("auth")) {
      setIsAuth(true);
    }
    setIsLoading(false);
  }, [])


  return (
    <div>
      <AuthContext.Provider value = {{
        isAuth,
        setIsAuth,
        isLoading
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
