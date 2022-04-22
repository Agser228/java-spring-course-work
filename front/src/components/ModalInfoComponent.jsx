import { Box, Modal, Typography } from '@mui/material';
import React from 'react';
import { dictionary, ignore } from '../utils/dictionary';


const ModalInfoComponent = ({entity, open, onClose, entityName}) => {
    return (
        <Modal
        sx={{
            display: "flex",
            justifyContent: "center",
            alignItems: "center"
        }}
        open={open}
        onClose={onClose}
        >
        <Box sx={{
            borderRadius: 2,
            padding: 5,
            width: 500,
            backgroundColor: "white" 
        }}>
        <Typography variant="h6" sx={{
            md: 2
        }}>
        Подробная информация
        </Typography>
            {Object.keys(entity)
            .filter((key) => !ignore.includes(key))
            .map(key => 
            (   <Box 
                key={key}
                sx={{
                display: "flex",
                justifyContent: "space-between"
                }}>
                <Typography>{dictionary[key]}</Typography>  
                <Typography>{entity[key]}</Typography>  
                </Box>
            
            ))}
            

        </Box>

        </Modal> 
    );
};

export default ModalInfoComponent;