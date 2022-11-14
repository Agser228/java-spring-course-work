import React from 'react';
import { useEffect } from 'react';
import { useState } from 'react';
import NestedListComponent from '../components/UI/NestedListComponent';
import SquadService from '../services/SquadService';
import { MenuItem, Modal, Box, Typography, Container, Button, Paper, Select, InputLabel, Dialog, DialogActions, DialogContent, TextField } from '@mui/material';
import ShiftService from '../services/ShiftService';


const Squads = () => {

    const [open, setOpen] = useState(false)
    const [squads, setSquads] = useState([])
    const [shifts, setShifts] = useState([])
    const [shiftId, setShiftId] = useState("")
    const [amountSquads, setAmountSquads] = useState(0);

    const handleOpen = () => setOpen(true);
    const handleClose = () => setOpen(false);
    const handleChange = (e) => {
        setShiftId(e.target.value);
      };


    useEffect(() => {
            SquadService.getAllSquads().then((squads) => {
                let sortedSquads = squads.sort((a, b) => a.number - b.number);
                console.log(sortedSquads);
                setSquads(sortedSquads);
            });

            ShiftService.getAllShifts().then((shifts) => {
                setShifts(shifts);
                if (shifts.length != 0){
                setShiftId(shifts[0].id)
                }
            })
    }, []);

    const createSquads = () => {
        handleClose();
        console.log({amountSquads, shiftId});
        SquadService.createAllSquads({amountSquads, shiftId}).then((squads) => {
            setSquads(squads);
        });
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
            {squads.length 
            ? <NestedListComponent squads={squads}/>
            : 
            
            <Box
                sx={{
                    display: "flex",
                    alignItems: "center",
                    flexDirection: "column"
                }}
            >
                <Dialog
                    open={open}
                    onClose={handleClose}
                    
                    >
                <DialogContent>
                <TextField
                onChange={(e) => setAmountSquads(parseInt(e.target.value))}
                margin="normal"
                label="Количество отрядов" 
                variant="outlined"
                inputProps={{ inputMode: 'numeric', pattern: '[0-9]*' }} />

                    <InputLabel id="select-label">
                        Номер смены
                    </InputLabel>

                    <Select
                        value={shiftId}
                        label="Номер смены"
                        onChange={handleChange}
                    >
                        {
                           shifts.map((shift) => (
                               <MenuItem
                                value={shift.id}
                               >
                               {shift.number}
                               </MenuItem>
                           )) 
                        }
                    </Select>

                </DialogContent>
                <DialogActions>
                    <Button
                        sx={{mt: 3}}
                        variant="contained"
                        onClick={createSquads}
                        >
                        Сформировать
                    </Button>
                </DialogActions>


                </Dialog>
                <Typography
                    variant="h5"
                >
                    Отряда пока не сформированы
                </Typography>
                <Button
                    sx={{mt: 3}}
                    variant="outlined"
                    type="submit"
                    onClick={handleOpen}
                >
                    Сформировать отряды
                </Button>
            </Box>
}
        </Container>
    );
};

export default Squads;



