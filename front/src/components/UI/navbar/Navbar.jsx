
import AccountCircle from '@mui/icons-material/AccountCircle';
import { AppBar, Box, Button, CssBaseline, IconButton, Toolbar } from '@mui/material';
import React, { useContext } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import { AuthContext } from './../../../context/index';
import { routes } from './../../../router/index';

const Navbar = () => {
    const location = useLocation();
    const navigate = useNavigate();
  const {isAuth, access, setIsAuth, setAccess} = useContext(AuthContext);
  


    const isLoginOrSignUpPage = location.pathname === "/login" || location.pathname === "/signup";
    const logout = () => {
      setAccess("all");
      setIsAuth(false);
      localStorage.removeItem("access");
      localStorage.removeItem("auth");
    }

    const login = () => {
      navigate("/login");
    }

    return (
        !isLoginOrSignUpPage
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