import React from 'react';
import { useEffect, useState } from 'react';
import SchemaService from '../services/SchemaService';
import { dictionary, ignore } from '../utils/dictionary';
import "../App.css"
import { Box, FormControl, InputLabel, MenuItem, Select, TextField } from '@mui/material';
import { enumeration } from './../utils/enum';

const UpdateFormComponent = ({entity, entityName, formName, setter}) => {

    const[schema, setSchema] = useState([])
    const[form, setForm] = useState({})
    useEffect(() => {
        SchemaService.getSchema(entityName).then((schema) => {
            let filterSchema = schema.filter((field) => !ignore.includes(field))
            setSchema(filterSchema);
        });

    }, []);


    useEffect(() => {
        setter(form);
    }, [form])


    const onChange = (e) => {
        setForm({...entity, [e.target.name] : e.target.value});
    }

    return (
            <Box component="form"
                sx={{
                    minWidth: 400, display: "flex", flexDirection: "column"
                }}
            >
                <h3>{formName}</h3>
                {
                    schema.map((field) =>
                    (!enumeration[field] ?
                    <TextField
                        
                        margin='normal'
                        required
                        id={field+Date.now()}
                        label={dictionary[field]}
                        name={field}
                        onChange={onChange}
                        fullWidth
                        defaultValue={entity[field]}
                        />
                        : 
                        <FormControl>
                            <InputLabel id="select-label">{dictionary[field]}</InputLabel>
                            <Select
                            defaultValue={entity[field]}
                            name={field}
                            labelId='select-label'
                            label={dictionary[field]}
                            onChange={onChange}
                            >
                                {
                                    Object.entries(enumeration[field]).map(([key, value]) => (
                                        <MenuItem value={key}>{value}</MenuItem>
                                    ))
                                }
                            </Select>

                        </FormControl>
                        
                    )
                    )
                }
            </Box>
    );
};

export default UpdateFormComponent;