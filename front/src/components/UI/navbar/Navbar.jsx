
import { AppBar, Box, Button, CssBaseline, IconButton, Toolbar, Typography, MenuItem } from '@mui/material';
import React, { useContext } from 'react';
import { AuthContext } from './../../../context/index';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { routes } from './../../../router/index';
import AccountCircle from '@mui/icons-material/AccountCircle';
import AuthService from './../../../services/AuthService';

const Navbar = () => {
    const location = useLocation();
    const navigate = useNavigate();
  const {isAuth, access, setIsAuth, setAccess} = useContext(AuthContext);
  


    const isLoginPage = location.pathname === "/login";
    const logout = () => {
      setAccess("all");
      setIsAuth(false);
    }

    const login = () => {
      navigate("/login");
    }

    return (
        !isLoginPage
        ? <Box sx={{ flexGrow: 1 }}>
            <CssBaseline />
        <AppBar position="static">
          <Toolbar sx={{display: "flex", justifyContent: "space-between"}}>
            { isAuth 
             ? <IconButton
              size="large"
              edge="start"
              color="inherit"
              aria-label="account"
              sx={{ mr: 2 }}
            >
              <AccountCircle />
            </IconButton>
            : null
          }
            <nav>
                {
                    routes[access].map((route, index) => 
                        <Button key={index} color="inherit" onClick={() => navigate(route.path)}>
                            {route.name}
                        </Button>
                        
                    )
                }
            </nav>
            {isAuth 
            ? <Button color="inherit" onClick={logout}>Выйти</Button>
            : <Button color="inherit" onClick={login}>Войти</Button>
            }
          </Toolbar>
        </AppBar>
      </Box>
      : null
    
    );
};

export default Navbar;