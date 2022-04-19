
import { AppBar, Box, Button, CssBaseline, IconButton, Toolbar, Typography, MenuItem } from '@mui/material';
import React, { useContext } from 'react';
import { AuthContext } from './../../../context/index';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { routes } from './../../../router/index';
import AccountCircle from '@mui/icons-material/AccountCircle';

const Navbar = () => {
    const location = useLocation();
    const {isAuth, setIsAuth, access, setAccess} = useContext(AuthContext);
    const navigate = useNavigate();

    const isLoginPage = location.pathname === "/login";
    const logout = () => {
        localStorage.removeItem("auth");
        localStorage.removeItem("access");
        setIsAuth(false);
        setAccess("all");
    }

    const login = () => {
      navigate("/login");
    }

    console.log(access);

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