
import { AppBar, Box, Button, CssBaseline, IconButton, Toolbar, Typography, MenuItem } from '@mui/material';
import React, { useContext } from 'react';
import MenuIcon from '@mui/icons-material/Menu';
import { AuthContext } from './../../../context/index';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { routes } from './../../../router/index';


const Navbar = () => {
    const location = useLocation();
    const {isAuth, setIsAuth} = useContext(AuthContext);
    const navigate = useNavigate();

    const isLoginPage = location.pathname === "/login";
    const logout = () => {
        localStorage.removeItem("auth");
        setIsAuth(false);
    }

    return (
        !isLoginPage
        ? <Box sx={{ flexGrow: 1 }}>
            <CssBaseline />
        <AppBar position="static">
          <Toolbar sx={{display: "flex", justifyContent: "space-between"}}>
            <IconButton
              size="large"
              edge="start"
              color="inherit"
              aria-label="menu"
              sx={{ mr: 2 }}
            >
              <MenuIcon />
            </IconButton>
            <nav>
                {
                    routes.map(route => 
                        <Button color="inherit" onClick={() => navigate(route.path)}>
                            {route.name}
                        </Button>
                        
                    )
                }
            </nav>
            <Button color="inherit" onClick={logout}>Выйти</Button>
          </Toolbar>
        </AppBar>
      </Box>
      : null
    
    );
};

export default Navbar;