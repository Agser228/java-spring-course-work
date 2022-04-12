import React from 'react';
import { Link } from "react-router-dom";

const Navbar = () => {
    return (
        <div>
            <Link to="/squads">Отряды</Link>
            <Link to="/children">Дети</Link>
            <Link to="/voucher">Путевки</Link>
        </div>
    );
};

export default Navbar;