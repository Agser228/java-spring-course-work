import React, { useState, useEffect } from 'react';
import ChildService from '../services/ChildService';
import { useNavigate } from 'react-router-dom';
import { Container, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from '@mui/material';

const Children = () => {
    
    const [children, setChildren] = useState([]);

    const router = useNavigate();

    useEffect(() => {
            ChildService.getAllChildren().then((res) => {
                console.log(res)
                
                setChildren(res);
            })
            
    }, [])

    const editChild = (id) => {
        router(`/add/${id}`);
    }

    const viewChild = (id) => {
        router(`/view/${id}`);
    }

    const addChild = () => {
        router('/add/_add');
    }

    const deleteChild = (id) => {
        ChildService.deleteChild(id).then((res) => {
            setChildren([children.filter(child => child.id !== id)])
        }); 
    }
    
    console.log("children", children);
    return (
        <TableContainer
        component={Paper}
        sx={{
            mt: 5,
            display: "flex",
            alignItems: "center",
            justifyContent: "center"
        }}
        >
            <Table
                        sx={{
                            maxWidth: 500
                        }}
>
                <TableHead>
                    <TableRow>
                        <TableCell>Имя</TableCell>
                        <TableCell>Фамилия</TableCell>
                        <TableCell>Отчество</TableCell>
                        <TableCell>Дата рождения</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {
                        children.map((child) => (
                            <TableRow
                                key={child.id}
                            >
                                <TableCell align="right">{child.name}</TableCell>
                                <TableCell align="right">{child.surname}</TableCell>
                                <TableCell align="right">{child.patronymic}</TableCell>
                                <TableCell align="right">{child.dateBirth}</TableCell>

                            </TableRow>

                        ))
                    }
                </TableBody>
            </Table>
            
        </TableContainer>
    );
};

export default Children;