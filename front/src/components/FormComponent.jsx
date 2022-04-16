import React from 'react';
import { useEffect, useState } from 'react';
import SchemaService from '../services/SchemaService';
import { dictionary, ignore } from '../utils/dictionary';
import "../App.css"
import { Box, TextField } from '@mui/material';

const FormComponent = ({entity, formName, setter, cleaner}) => {

    const[schema, setSchema] = useState([])
    const[form, setForm] = useState({})
    useEffect(() => {
        SchemaService.getSchema(entity).then((schema) => {
            let filterSchema = schema.filter((field) => !ignore.includes(field))
            setSchema(filterSchema);
        });
        cleaner(() => clearForm);
        console.log("after filter:", schema.filter((field) => !ignore.includes(field)));

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
                    minWidth: 350, display: "flex", flexDirection: "column"
                }}
            >

            
                <h3>{formName}</h3>
                {
                    schema.map((field) =>

                    <TextField
                        margin='normal'
                        required
                        id={field+Date.now()}
                        label={dictionary[field]}
                        name={field}
                        onChange={onChange}
                        fullWidth
                        />
                        // <input 
                    // type="text" 
                    // id={field + Date.now()} 
                    // placeholder={dictionary[field]}
                    // name={field}
                    // className="field"
                    // value={form.field}
                    // onChange={onChange}
                    // />
                    )
                }
            </Box>
    );
};

export default FormComponent;