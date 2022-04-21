import { AuthContext } from '../context';
import React, { useContext, useState } from 'react';
import { Avatar, Box, Button, Container, Paper, TextField, Typography } from '@mui/material';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import AuthService from '../services/AuthService';

const Login = () => {

    const {setIsAuth, setAccess} = useContext(AuthContext);
    
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");

    const login = (e) => {

        e.preventDefault()
        AuthService.login(email, password).then((res) =>
            {
                console.log(res);
                localStorage.setItem("auth", res.success);
                if (res.success) {
                    setIsAuth(true);
                    setAccess(res.user.role);
                    console.log(res.user.role);
                    localStorage.setItem("access", res.user.role);
                    localStorage.setItem("userId", res.user.id);
                }
            }
        );                                
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
                label="Почта" 
                variant="outlined"
                onChange={(e) => setEmail(e.target.value)}
                fullWidth
                />
                <TextField 
                fullWidth
                margin="normal"
                label="Пароль" 
                variant="outlined"
                onChange={(e) => setPassword(e.target.value)}
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