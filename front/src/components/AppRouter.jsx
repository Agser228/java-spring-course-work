import React, { useContext } from 'react';
import { Navigate, Route, Routes } from "react-router-dom";
import { AuthContext } from '../context';
import Login from '../pages/Login';
import { routes } from '../router';
import Home from './../pages/Home';
import SignUp from './../pages/SignUp';
const AppRouter = () => {

     const {isAuth, isLoading, access} = useContext(AuthContext);


     console.log(isAuth);
     console.log(routes);

     if (isLoading) {
         return (
             <div>
                 Загрузка
             </div>
         )
     }
    
     return (
    isAuth  
    ? <Routes> 
         {
            routes[access].map(route => 
                <Route 
                path={route.path} 
                key={route.path}
                element={route.component}/>
                )
            }
            <Route path="/" element={<Home/>}/>
            <Route path="*" element={<Navigate replace to="/"/>} />
    </Routes> 
    : <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/signup" element={<SignUp/>}/>
        <Route path="/login" element={<Login/>}/>
        <Route path="*" element={<Navigate replace to="/login"/>}/>
    </Routes>
    
    );
};

export default AppRouter;