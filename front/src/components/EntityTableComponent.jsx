import React from 'react';
import { Container, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from '@mui/material';
import { dictionary, ignore } from '../utils/dictionary';
import EntityRowComponent from './EntityRowComponent';


const EntityTableComponent = ({
    header, 
    entities, 
    editable, 
    entityName, 
    update, 
    del
}) => {



    return (
        <TableContainer
        component={Paper}
        sx={{
            mt: 5,
            display: "flex",
            alignItems: "center",
            justifyContent: "center"
        }}
        >
        <Table
        sx={{
            maxWidth: 600
        }}>
                <TableHead>
                    <TableRow>
                        {header.map((key) => (
                            <TableCell key={key}>{dictionary[key]}</TableCell>
                        ))
                        }
                        <TableCell>Действие</TableCell>
                    </TableRow>
                </TableHead>


                <TableBody>
                    {entities.map((entity) => (
                        <EntityRowComponent
                        key={entity.id}
                        entityName={entityName}
                        entity={entity}
                        header={header}
                        editable={editable}
                        update={update}
                        del={del}
                        />
                    ))}
                </TableBody>


        </Table>
        </TableContainer>
    );
};

export default EntityTableComponent;