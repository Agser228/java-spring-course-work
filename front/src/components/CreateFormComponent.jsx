import React from 'react';
import { useEffect, useState } from 'react';
import SchemaService from '../services/SchemaService';
import { dictionary, ignore } from '../utils/dictionary';
import { enumeration } from '../utils/enum';
import "../App.css"
import { Box, FormControl, InputLabel, TextField, Select, MenuItem } from '@mui/material';

const CreateFormComponent = ({entityName, formName, setter, cleaner}) => {

    const[schema, setSchema] = useState([])
    const[form, setForm] = useState({})
    useEffect(() => {
        SchemaService.getSchema(entityName).then((schema) => {
            let filterSchema = schema.filter((field) => !ignore.includes(field))
            setSchema(filterSchema);
        });
        cleaner(() => clearForm);

    }, []);


    useEffect(() => {
        setter(form);
    }, [form])

    const clearForm = () => {
        document.querySelectorAll("input").forEach(
                input => (input.value = "")
              );
        setForm({});
    }

    const onChange = (e) => {
        setForm(form => ({...form, [e.target.name] : e.target.value}));
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
                            />
                            : 
                            <FormControl>
                                <InputLabel id="select-label">{dictionary[field]}</InputLabel>
                                <Select
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

export default CreateFormComponent;