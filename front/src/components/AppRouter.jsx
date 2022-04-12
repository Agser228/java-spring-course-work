import React from 'react';
import { Navigate, Route, Routes } from "react-router-dom";
import { routes } from '../router';

const AppRouter = () => {
    return (
<Routes> {
            routes.map(route => 
                <Route exact={route.exact} 
                path={route.path} 
                key={route.path}
                element={route.component}/>
                )
            }
                <Route path="*" element={<Navigate replace to="/posts"/>} />
    </Routes>
    );
};

export default AppRouter;