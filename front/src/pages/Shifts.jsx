import { Button, CircularProgress, Container, Paper } from '@mui/material';
import React, { useEffect, useState } from 'react';
import DialogFormComponent from './../components/DialogFormComponent';
import EntityTableComponent from './../components/EntityTableComponent';
import ShiftService from './../services/ShiftService';
import { useFetching } from './../hooks/useFetching';

const Shifts = () => {

    const [shifts, setShifts] = useState([]);
    const [open, setOpen] = useState(false);
    const [fetchShifts, isShiftsLoading, shiftsError] = useFetching( async () => {
        const loadedShifts = await ShiftService.getAllShifts();
        setShifts(loadedShifts);
    });

    const handleOpen = () => {
        setOpen(true);
      };
    
      const handleClose = () => {
        setOpen(false);
      };
    
    useEffect(() => {
        fetchShifts();
    }, []);

    const updateShift = (id, updatedShift) => {
        ShiftService.update(id, updatedShift).then((res) => {
            console.log(res);
        })
        setShifts([...shifts.filter(shift => shift.id !== id), updatedShift]);
    }
    const deleteShift = (id) => {
        ShiftService.delete(id).then((res) => {
            console.log(res);
        })
        setShifts([...shifts.filter(shift => shift.id !== id)]);
    }

    const createShift = (shift) => {
        ShiftService.createShift(shift).then((res) => {
            console.log(res);
            let createdShift = res;
            setShifts([...shifts, createdShift]);
        })
    }


    return (
        isShiftsLoading 
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