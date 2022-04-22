import DeleteRoundedIcon from '@mui/icons-material/DeleteRounded';
import EditRoundedIcon from '@mui/icons-material/EditRounded';
import InfoRoundedIcon from '@mui/icons-material/InfoRounded';
import { IconButton, Stack, TableCell, TableRow } from '@mui/material';
import React, { useState } from 'react';
import { enumeration } from './../utils/enum';
import DialogFormComponent from './DialogFormComponent';
import ModalInfoComponent from './ModalInfoComponent';


const EntityRowComponent = ({
    header, 
    entity, 
    editable, 
    entityName, 
    update,
    del
}) => {

    const [openInfo, setOpenInfo] = useState(false);
    const [openEdit, setOpenEdit] = useState(false);

    
    const handleOpenInfo = () => {   setOpenInfo(true);  };
    const handleCloseInfo = () => {  setOpenInfo(false);  };

    const handleOpenEdit = () => {   setOpenEdit(true);  };
    const handleCloseEdit = () => {  setOpenEdit(false);  };


    
    const info = (id) => {
        handleOpenInfo();
        console.log("info", id);
    }

    const edit = (id) => {
        handleOpenEdit();
        console.log("edit", id);
    }

    return (

        <TableRow>
        <ModalInfoComponent
        entity={entity}
        open={openInfo}
        entityName={entityName}
        onClose={handleCloseInfo}
        />

        <DialogFormComponent
        entity={entity}
        onClose={handleCloseEdit}
        entityName={entityName}
        open={openEdit}
        callback={update}
        purpose="update"
        />

        {header.map((key) => (
            ! enumeration[key]
            ? <TableCell key={key}>{entity[key]}</TableCell>
            : <TableCell key={key}>{enumeration[key][entity[key]]}</TableCell>
            ))
        }

        <TableCell>
            { !editable
            ? <IconButton onClick={() => info(entity.id)} color="primary">
                <InfoRoundedIcon/>
              </IconButton>
            : 
            <Stack direction="row" spacing={1}>
                <IconButton onClick={() => del(entity.id)} color="error">
                    <DeleteRoundedIcon/>
                </IconButton>
                <IconButton onClick={() => edit(entity.id)} color="success"> 
                    <EditRoundedIcon/>
                </IconButton>
            </Stack>
            }
        </TableCell>
    </TableRow>
    );
};

export default EntityRowComponent;