import React, { useState, useEffect } from 'react';
import ChildService from '../services/ChildService';
import { useNavigate } from 'react-router-dom';
import { Container, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from '@mui/material';
import EntityTableComponent from '../components/EntityTableComponent';

const Children = ({editable}) => {
    
    const [children, setChildren] = useState([]);

    const router = useNavigate();
    const refresh = () => {
        ChildService.getAllChildren().then((res) => {
            console.log(res)
            setChildren(res);
            });
        }
    
    useEffect(() => {refresh(); }, []);

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

    const updateChild = () => {
        //TODO
    }
    
    console.log("children", children);
    return (
        <div>
        <EntityTableComponent 
        entityName={"child"}
        header={["surname", "name", "patronymic", "dateBirth"]}
        entities={children}
        editable={editable}
        update={updateChild}
        del={deleteChild}
        />
        </div>

    );
};

export default Children;