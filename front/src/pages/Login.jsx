import { AuthContext } from '../context';
import React, { useContext } from 'react';
import { Avatar, Box, Button, Container, Paper, TextField, Typography } from '@mui/material';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';

const Login = () => {

    const {setIsAuth} = useContext(AuthContext);


    const login = (e) => {
        localStorage.setItem("auth", "true");
        e.preventDefault();
        setIsAuth(true);
    }

    return (
        <Container maxWidth="xs">
            <Box 
            sx={{
                mt: 8,
                display: "flex", 
                alignItems: "center",
                flexDirection: "column",
            }}
            
            
            >
                <Avatar
                    sx={{
                        m: 1
                    }}
                >
                    <LockOutlinedIcon></LockOutlinedIcon>
                </Avatar>

                <Typography
                    variant="h5"
                    
                >
                    Войти
                </Typography>

                <Box
                component="form" onSubmit={login}
                >

                <TextField 
                margin="normal"
                label="Логин" 
                variant="outlined"
                fullWidth
                />
                <TextField 
                fullWidth
                margin="normal"
                label="Пароль" 
                variant="outlined"
                />
                <Button 
                type="submit"
                variant="contained"
                sx={{mt: 3}}
                fullWidth

                >
                    Войти
                </Button>
                
                </Box>
            
            </Box>
        </Container>

    );
};

export default Login;