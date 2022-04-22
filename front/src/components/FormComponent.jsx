import React from 'react';
import { useEffect, useState } from 'react';
import SchemaService from '../services/SchemaService';
import { dictionary, ignore } from '../utils/dictionary';
import "../App.css"
import { Box, TextField } from '@mui/material';

const FormComponent = ({
    entity, 
    entityName, 
    formName, 
    setter,
    errorHandler,
    cleaner}) => {

    const[schema, setSchema] = useState([])
    const[form, setForm] = useState({})
    const [isError, setIsError] = useState(false)
    const [errorMessage, setErrorMessage] = useState({});
    useEffect(() => {
        SchemaService.getSchema(entityName).then((schema) => {
            let filterSchema = schema.filter((field) => !ignore.includes(field))
            setSchema(filterSchema);
        });
        errorHandler((msg) => handleError)
        cleaner(() => clearForm);

    }, []);

    const disableError = () => {
        setIsError(false);
        setErrorMessage({});
    }

    const handleError = (msg) => {
        console.log(msg);
        setIsError(true);
        setErrorMessage(msg);
    }

    const getHelperText = (field) => {
        if (errorMessage[field]) {
            return errorMessage[field];
        } else {
            return "";
        }
    }

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

                    <TextField
                        margin='normal'
                        required
                        onFocus={disableError}
                        error={isError}
                        helperText={errorMessage[field]}
                        id={field+Date.now()}
                        label={dictionary[field]}
                        name={field}
                        onChange={onChange}
                        fullWidth
                        defaultValue={entity[field]}
                        />
                    )
                }
            </Box>
    );
};

export default FormComponent;