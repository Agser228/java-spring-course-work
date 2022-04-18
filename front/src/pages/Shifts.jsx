import { Button, Container, Paper } from '@mui/material';
import EntityTableComponent from './../components/EntityTableComponent';
import React from 'react';
import { useState, useEffect } from 'react';
import ShiftService from './../services/ShiftService';
import CreateFormComponent from './../components/CreateFormComponent';
import DialogFormComponent from './../components/DialogFormComponent';

const Shifts = () => {

    const [shifts, setShifts] = useState([]);
    const [open, setOpen] = useState(false);

    const handleOpen = () => {
        setOpen(true);
      };
    
      const handleClose = () => {
        setOpen(false);
      };
    
    useEffect( () => {
        ShiftService.getAllShifts().then((shifts) => {
            setShifts(shifts);
        })
    }, [])

    const updateShift = (id, updatedShift) => {
        ShiftService.update(id, updatedShift).then((res) => {
            console.log(res);
        })
        setShifts([...shifts.filter(shift => shift.id != id), updatedShift]);
    }
    const deleteShift = (id) => {
        ShiftService.delete(id).then((res) => {
            console.log(res);
        })
        setShifts([...shifts.filter(shift => shift.id != id)]);
    }

    const createShift = (shift) => {
        ShiftService.createShift(shift).then((res) => {
            console.log(res);
            let createdShift = res;
            setShifts([...shifts, createdShift]);
        })
    }


    return (
        <Container
        maxWidth="md"
        component={Paper}
        sx={{
            mt: 2,
            p: 6,
            mb: 2
        }}
        >
            <Button onClick={handleOpen}>
                Создать новую смену
            </Button>

            <DialogFormComponent
            open={open}
            onClose={handleClose}
            entity={{}}
            entityName="shift"
            callback={createShift}
            purpose="create"
            />

        <EntityTableComponent 
        entityName={"shift"}
        header={["number", "currentYear", "amountPlaces", "status"]}
        entities={shifts}
        editable={true}
        update={updateShift}
        del={deleteShift}
        />

        </Container>    
    );
};

export default Shifts;