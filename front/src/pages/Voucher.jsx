import { Container, Paper, Box, Button, Typography, Alert, AlertTitle } from '@mui/material';
import React, {useState, useEffect, useContext} from 'react';
import ShiftService from '../services/ShiftService';
import FormComponent from '../components/FormComponent';
import { AuthContext } from '../context';
import VoucherService from './../services/VoucherService';

const Voucher = () => {


    const [parent, setParent] = useState({});
    const [child, setChild] = useState({});
    const [cleanParentForm, setCleanParentForm] = useState(() => () => console.log("cleanParent"));
    const [cleanChildForm, setCleanChildForm] = useState(() => () => console.log("cleanChild"));
    const [isShiftOpen, setIsShiftOpen] = useState(false);
    const {userId} = useContext(AuthContext);
    const [isVoucherSent, setIsVoucherSent] = useState(false);
    const [voucherMessage, setVoucherMessage] = useState("");
    const [childErrorHandler, setChildErrorHandler] = useState((msg) => () => {});
    const [parentErrorHandler, setParentErrorHandler] = useState((msg) => () => {});

    useEffect(() => {
        ShiftService.getAllOpenedShifts().then(shifts => {
            console.log(shifts);
            setIsShiftOpen(shifts.length > 0);
        })

        VoucherService.getVoucherByUserId(userId).then(voucher => {
            console.log(voucher);
            if (voucher.status) {
                setIsVoucherSent(true);
                setVoucherMessage(voucher.message);
            }
        })

        console.log("isVoucherSent", isVoucherSent)
        console.log("voucherMessage", voucherMessage)
    }, [])

    const formatObject = (name, obj) => {
        Object.keys(obj).forEach((key) => {
            let newKey = name + key.charAt(0).toUpperCase() + key.substring(1)
            console.log(newKey)
            obj[newKey] = obj[key];
            delete obj[key]
        });
    }

    const splitError = (error) => {
        let errorParent = {}
        let errorChild = {}

        Object.keys(error).forEach((key) => {
            if (key.includes("child")) {
                let childKey = key.charAt(5).toLowerCase() + key.substring(6)
                errorChild[childKey] = error[key];
            } else if (key.includes("parent")) {
                let parentKey = key.charAt(6).toLowerCase() + key.substring(7)
                errorParent[parentKey] = error[key];
            }
        });

        console.log(errorParent, errorChild);
        
        return {errorParent, errorChild}
    }

    const submit = (e) => {
        e.preventDefault()
        console.log("submit");
        
        formatObject("parent", parent);
        formatObject("child", child);

        let voucher = {...parent, ...child, userId};
        console.log("voucher", voucher);

        cleanChildForm();
        cleanParentForm();

        setParent({});
        setChild({});
        VoucherService.createVoucher(voucher).then((response) => {
            let result = response.data;
            console.log(result);
            if (result.statusCode == 400) {
                console.log(parentErrorHandler);
                let {errorParent, errorChild} = splitError(result.data);
                parentErrorHandler(errorParent);
                childErrorHandler(errorChild);
            } else {    
                 setIsVoucherSent(true);
                 setVoucherMessage("Заявка отправлена")
             }
        });

    }

    return (
        <Container
        maxWidth="lg"
        component={Paper}
        sx={{
            mt: 2,
            p: 6,
            mb: 2
        }}
        >
        { isShiftOpen 
        ? <div>
            { !isVoucherSent
            ? <Box component="form"
            sx={{
                        display: "flex",
                        flexDirection: "column"
                    }}
                >
                <Box sx={{display: "flex", justifyContent: "space-around"}}>
                    <FormComponent 
                    entity={{}} 
                    entityName={"parent"} 
                    formName={"Данные родителя"} 
                    setter={setParent}
                    errorHandler={setParentErrorHandler}
                    cleaner={setCleanParentForm}/>
                <FormComponent 
                entity={{}} 
                entityName={"child"} 
                formName={"Данные ребенка"} 
                setter={setChild} 
                cleaner={setCleanChildForm}
                errorHandler={setChildErrorHandler}
                />
                </Box>

                <Button
                sx={{mt: 3}}
                variant="contained"
                type="submit" onClick={submit}>Отправить</Button>
                </Box>
            :   <Alert severity="info">
                <AlertTitle>Статус заявки</AlertTitle>
                {voucherMessage}
                </Alert>
            }
        </div>
        : 
            <Alert severity="info">
            <AlertTitle>Смена еще не началась</AlertTitle>
            На данный момент нет открытых смен — <strong>проверьте попозже</strong>
            </Alert>
        }
        </Container>
    );
};

export default Voucher;