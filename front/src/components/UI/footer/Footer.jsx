import React from 'react';
import classes from "./Footer.module.css"


const Footer = () => {
    return (
        <footer className={classes.footer}>
            <span className='text-muted'>
            Алексей Клочек 2022 @Agser
            </span>
        </footer>
    );
};

export default Footer;