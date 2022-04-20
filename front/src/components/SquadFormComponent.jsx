import React, { useState, useEffect } from 'react';
import { Paper, FormControl, InputLabel, Select, MenuItem, Container, Box, Card, CardContent, CardActions, Button, DialogContent, DialogActions, Dialog, DialogTitle, Typography, Grid } from '@mui/material';
import UpdateFormComponent from './UpdateFormComponent';
import CreateFormComponent from './CreateFormComponent';
import EntityTableComponent from './EntityTableComponent';
import { dictionary } from '../utils/dictionary';
import WorkerService from './../services/WorkerService';
import SquadService from './../services/SquadService';

const SquadFormComponent = ({open, onClose, squad}) => {

    const [counselors, setCounselors] = useState([])
    const [counselor, setCounselor] = useState({id: "", name: "", surname: ""})

    useEffect(() => {

        WorkerService.getAllCounselors().then((counselors) => {
            console.log(counselors);
            setCounselors(counselors);
            if (squad.worker) {
                setCounselor(squad.worker)
            }
        })
        console.log(squad);
    }, [])

    const handleChange = (e) => {
        let newCounselor = counselors.find((counselor) => counselor.id === e.target.value);
        setCounselor(newCounselor);
        console.log(newCounselor);
    };

    const attachCounselor = (e) => {
        e.preventDefault();
        SquadService.attachCounselorToSquad(squad.id, counselor.id).then((squad) => {
            console.log("attached", squad);
        })
        
    }
    const disattachCounselor = (e) => {
        e.preventDefault();
        
        SquadService.disattachCounselorToSquad(squad.id).then((squad) => {
            console.log("disattached", squad);
            setCounselor({id: "", name: "", surname: ""});
        })

    }



    return (
        <Dialog
        fullWidth={true}
        scroll="body"
        maxWidth="lg"
        open={open}
        onClose={onClose}
        >
        <DialogContent>

        <Typography variant="h4" align="center">
            {`Отряд №${squad.id}`}
        </Typography>
        <Box component="form"
                sx={{
                    mt: 2,
                    display: "flex",
                    justifyContent: "center"
                }}
            >
        <FormControl>
        <InputLabel id="select-label">Вожатый</InputLabel>
        <Select
        fullWidth
        name="counselor"
        labelId='select-label'
        label="Вожатый"
        onChange={handleChange}
        value={counselor.id}
        // value={`${counselor.name} ${counselor.surname}`}
        // value={`${squad.counselor.name} ${squad.counselor.surname}`}
        >
            {
                counselors.map((counselor) => (
                    <MenuItem 
                    key={counselor.id} 
                    value={counselor.id}>
                        {`${counselor.name} ${counselor.surname}`}
                    </MenuItem>
                ))
            }
            
        </Select>
        <Button
                sx={{mt: 3}}
                variant="contained"
                onClick={attachCounselor}
                type="submit"
                >
                Прикрепить вожатого
            </Button>    
        <Button
                sx={{mt: 1}}
                variant="contained"
                onClick={disattachCounselor}
                type="submit"
                >
                Открепить вожатого
        </Button>    
        </FormControl>


        </Box>
        <EntityTableComponent 
                entityName={"child"}
                header={["surname", "name", "patronymic", "dateBirth"]}
                entities={squad.children}
                editable={false}
                update={() => {}}
                del={() => {}}
                />

        </DialogContent>
        </Dialog>
    );
};

export default SquadFormComponent;