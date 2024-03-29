import { AuthContext } from '../context';
import React, { useContext, useState } from 'react';
import { Link, Avatar, Box, Button, Container, Paper, TextField, Typography } from '@mui/material';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import AuthService from '../services/AuthService';

const Login = () => {

    const {setIsAuth, setAccess} = useContext(AuthContext);
    
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");
    const [isError, setIsError] = useState(false);
    const [errorMessage, setErrorMessage] = useState({password: "", email: ""});

    const login = (e) => {

        e.preventDefault()
        AuthService.login(email, password).then((res) =>
            {
                console.log(res);
                if (res.success) {
                    localStorage.setItem("auth", res.success);
                    setIsAuth(true);
                    setAccess(res.user.role);
                    console.log(res.user.role);
                    localStorage.setItem("access", res.user.role);
                    localStorage.setItem("userId", res.user.id);
                } else {
                    setErrorMessage({password: res.password, email: res.email})
                    setIsError(true)
                }
            }
        );                                
    }

    const disableError = () => {
        setIsError(false);
        setErrorMessage({password: "", email: ""});
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
                onFocus={disableError}
                error={isError}
                helperText={errorMessage.email}
                margin="normal"
                label="Почта" 
                variant="outlined"
                onChange={(e) => setEmail(e.target.value)}
                fullWidth
                />
                <TextField 
                fullWidth
                onFocus={disableError}
                error={isError}
                helperText={errorMessage.password}
                margin="normal"
                label="Пароль" 
                variant="outlined"
                type="password"
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
                <Box
                sx={{mt:2}}
                display="flex"
                justifyContent="center"
                >

                <Link
                href="/signup"
                variant="body2"
                >Нет аккаунта? Зарегистрируйся</Link>
                </Box>

                </Box>
            
            </Box>
        </Container>

    );
};

export default Login;