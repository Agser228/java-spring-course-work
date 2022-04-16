import { AuthContext } from '../context';
import React, { useContext } from 'react';
import { Navigate, Route, Routes } from "react-router-dom";
import { routes } from '../router';
import Login from '../pages/Login';
import Squads from './../pages/Squads';
import Children from './../pages/Children';
const AppRouter = () => {

     const {isAuth, isLoading} = useContext(AuthContext);
    
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
            routes.map(route => 
                <Route 
                path={route.path} 
                key={route.path}
                element={route.component}/>
                )
            }
            <Route path="*" element={<Navigate replace to="/children"/>} />
    </Routes> 
    : <Routes>
        <Route path="/login" element={<Login/>}/>
        <Route path="*" element={<Navigate replace to="/login"/>}/>
    </Routes>
    
    );
};

export default AppRouter;