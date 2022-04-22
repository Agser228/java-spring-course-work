import { Box, Button, Dialog, DialogActions, DialogContent } from '@mui/material';
import React, { useState } from 'react';
import CreateFormComponent from './CreateFormComponent';
import UpdateFormComponent from './UpdateFormComponent';

const DialogFormComponent = ({open, onClose, entity, entityName, callback, purpose}) => {

    const [updatedEntity, setUpdatedEntity] = useState(entity);
    const [cleanForm, setCleanForm] = useState(() => () => console.log("cleanForm"));


    const updateEntity = (e) => {
        e.preventDefault();
        console.log(updatedEntity);
        callback(entity.id, {...entity, ...updatedEntity});
        onClose();
    }

    const createEntity = (e) => {
        e.preventDefault();
        callback(updatedEntity);
        cleanForm();
        onClose();
    }



    return (
            <Dialog
            maxWidth="lg"
            open={open}
            onClose={onClose}

            >
            { purpose === "update"
            ? 
            <Box 
            maxWidth="lg"
            component="form">
            <DialogContent
            >

            <UpdateFormComponent 
            entity={entity} 
            entityName={entityName} 
            formName={`Данные ${entityName}`} 
            setter={setUpdatedEntity}
            />
            </DialogContent>
            <DialogActions sx={{
            display: "flex",
            justifyContent: "center"
            }}>
            <Button
                sx={{mt: 3}}
                variant="contained"
                onClick={updateEntity}
                type="submit"
                >
                Обновить {entityName}
            </Button>
            </DialogActions>
            </Box>

            :             <Box 
            maxWidth="lg"
            component="form">
            <DialogContent
            >

            <CreateFormComponent 
            entityName={entityName} 
            formName={`Данные ${entityName}`} 
            setter={setUpdatedEntity}
            cleaner={setCleanForm}
            />
            </DialogContent>
            <DialogActions sx={{
            display: "flex",
            justifyContent: "center"
            }}>
            <Button
                sx={{mt: 3}}
                variant="contained"
                onClick={createEntity}
                type="submit"
                >
                Создать {entityName}
            </Button>
            </DialogActions>
            </Box>
            }
            </Dialog>






    );
};

export default DialogFormComponent;