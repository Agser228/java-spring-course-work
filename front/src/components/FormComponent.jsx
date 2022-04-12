import React from 'react';
import { useEffect, useState } from 'react';
import SchemaService from '../services/SchemaService';
import { dictionary, ignore } from '../utils/dictionary';
import "../App.css"

const FormComponent = ({entity, formName, setter}) => {

    const[schema, setSchema] = useState([])
    const[form, setForm] = useState({})
    useEffect(() => {
        SchemaService.getSchema(entity).then((schema) => {
            let filterSchema = schema.filter((field) => !ignore.includes(field))
            setSchema(filterSchema);
        });
        console.log("after filter:", schema.filter((field) => !ignore.includes(field)));

    }, []);



    const onChange = (e) => {
        setForm(form => ({...form, [e.target.name] : e.target.value}));
        console.log("form:", form);
        setter(form);
    }

    return (
            <form style={{display: "flex", flexDirection: "column"}}>
                <h3>{formName}</h3>
                {
                    schema.map((field) =>
                    <input 
                    type="text" 
                    id={field + Date.now()} 
                    placeholder={dictionary[field]}
                    name={field}
                    className="field"
                    value={form.field}
                    onChange={e => {
                        setForm(form => ({...form, [field] : e.target.value}));
                        console.log(form);
                        setter(form);
                    }}
                    />
                    )
                }
            </form>
    );
};

export default FormComponent;