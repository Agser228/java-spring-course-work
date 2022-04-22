import { CircularProgress, Container, Paper } from '@mui/material';
import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import EntityTableComponent from '../components/EntityTableComponent';
import ChildService from '../services/ChildService';

const Children = ({editable}) => {
    
    const [children, setChildren] = useState([]);
    const [isLoading, setIsLoading] = useState(false);
    const router = useNavigate();
    const refresh = () => {
        ChildService.getAllChildren().then((res) => {
            console.log(res)
            setChildren(res);
            });
        }
    
    useEffect(() => {
        setIsLoading(true);
        refresh();
        setIsLoading(false);
    }, []);

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
        isLoading
        ? <CircularProgress/>
        :
        <Container
        maxWidth="md"
        component={Paper}
        sx={{
            mt: 2,
            p: 6,
            mb: 2
        }}
        >
        <EntityTableComponent 
        entityName={"child"}
        header={["surname", "name", "patronymic", "dateBirth"]}
        entities={children}
        editable={editable}
        update={updateChild}
        del={deleteChild}
        />
        </Container>

    );
};

export default Children;