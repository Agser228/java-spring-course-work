import { Button, Container, Paper } from '@mui/material';
import React, { useEffect, useState } from 'react';
import EntityTableComponent from '../components/EntityTableComponent';
import WorkerService from '../services/WorkerService';
import DialogFormComponent from './../components/DialogFormComponent';


const Workers = () => {


    const [workers, setWorkers] = useState([])
    // const [rows, setRows] = useState([
    //     // {id: 0, surname: "Иванов", name: "Иван", patronymic: "Иванович", position: "Вожатый"}
    // ])
    const [cleanWorkerForm, setCleanWorkerForm] = useState(() => () => console.log("cleanWorker"));

    const [open, setOpen] = useState(false)
    const [worker, setWorker] = useState({});

    const handleOpen = () => setOpen(true);
    const handleClose = () => setOpen(false);


    // useEffect(() => {
    //     let newRows = []
    //     workers.forEach((worker) => {
    //         newRows.push({
    //             id: worker.id,
    //             surname: worker.surname,
    //             name: worker.name,
    //             patronymic: worker.patronymic,
    //             position: worker.position

    //         });
    //     }
    //     );
    //     setRows(newRows);
    // }, [workers])


    
    
    useEffect(() => {
        WorkerService.getAllWorkers().then((workers) => {
            setWorkers(workers);
        });
    
    }, []);



    const updateWorker = (id, updatedWorker) => {
        WorkerService.update(id, updatedWorker).then((res) => {
            console.log(res);
        })
        setWorkers([...workers.filter(worker => worker.id != id), updatedWorker]);
    }
    const deleteWorker = (id) => {
        WorkerService.delete(id).then((res) => {
            console.log(res);
        })
        setWorkers([...workers.filter(worker => worker.id != id)]);
    }

    const createWorker = (worker) => {
        WorkerService.createWorker(worker).then((res) => {
            console.log(res);
            let createdWorker = res;
            setWorkers([...workers, createdWorker]);
        })

        // AuthService.registerWorker(worker.email, worker.phoneNumber).then((res) => {
        //     console.log(res);
        // });
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
                Добавить нового работника
            </Button>

            <DialogFormComponent
            open={open}
            onClose={handleClose}
            entity={{}}
            entityName="worker"
            callback={createWorker}
            purpose="create"
            />


        <EntityTableComponent
            entityName={"worker"}
            header={["surname", "name", "patronymic", "position"]}
            entities={workers}
            editable={true}
            update={updateWorker}
            del={deleteWorker}
        />
        
        
        </Container>
    );
};

export default Workers;