import { Container, Paper, Box, Button, Typography } from '@mui/material';
import React, {useState, useEffect} from 'react';
import ShiftService from '../services/ShiftService';
import FormComponent from '../components/FormComponent';
import VoucherService from '../services/VoucherService';
const Voucher = () => {


    const [parent, setParent] = useState({});
    const [child, setChild] = useState({});
    const [cleanParentForm, setCleanParentForm] = useState(() => () => console.log("cleanParent"));
    const [cleanChildForm, setCleanChildForm] = useState(() => () => console.log("cleanChild"));
    const [isShiftOpen, setIsShiftOpen] = useState(false);


    useEffect(() => {
        ShiftService.getAllOpenedShifts().then(shifts => {
            console.log(shifts);
            setIsShiftOpen(shifts.length > 0);
        })
    }, [])

    const formatObject = (name, obj) => {
        Object.keys(obj).forEach((key) => {
            let newKey = name + key.charAt(0).toUpperCase() + key.substring(1)
            console.log(newKey)
            obj[newKey] = obj[key];
            delete obj[key]
        });
    }

    const submit = (e) => {
        e.preventDefault()
        console.log("submit");
        
        formatObject("parent", parent);
        formatObject("child", child);

        let voucher = {...parent, ...child};
        console.log("voucher", voucher);

        cleanChildForm();
        cleanParentForm();

        setParent({});
        setChild({});
        VoucherService.createVoucher(voucher).then((res) => {
            console.log(res);
        });
    }

    return (
        <Container component={Paper} maxWidth="lg"
            sx={{
                mt: 5
            }}
        >
        { isShiftOpen 
        ? <Box component="form"
            sx={{
                display: "flex",
                flexDirection: "column"
            }}
        >
        <Box sx={{display: "flex", justifyContent: "space-around"}}>
        <FormComponent entity={{}} entityName={"parent"} formName={"Данные родителя"} setter={setParent} cleaner={setCleanParentForm}/>
        <FormComponent entity={{}} entityName={"child"} formName={"Данные ребенка"} setter={setChild} cleaner={setCleanChildForm}/>
        </Box>

        <Button
        sx={{mt: 3}}
        variant="contained"
        type="submit" onClick={submit}>Отправить</Button>
        </Box>
        : <Typography>На данный момент нет открытых смен</Typography>
        }
        </Container>
    );
};

export default Voucher;