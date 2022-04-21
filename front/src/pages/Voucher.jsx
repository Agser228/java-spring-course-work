import { Container, Paper, Box, Button, Typography } from '@mui/material';
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
        VoucherService.createVoucher(voucher).then((res) => {
            console.log(res);
        });
        setIsVoucherSent(true);
    }

    return (
        <Container component={Paper} maxWidth="lg"
            sx={{
                mt: 5
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
                    <FormComponent entity={{}} entityName={"parent"} formName={"Данные родителя"} setter={setParent} cleaner={setCleanParentForm}/>
                <FormComponent entity={{}} entityName={"child"} formName={"Данные ребенка"} setter={setChild} cleaner={setCleanChildForm}/>
                </Box>

                <Button
                sx={{mt: 3}}
                variant="contained"
                type="submit" onClick={submit}>Отправить</Button>
                </Box>
            : <Typography>{voucherMessage}</Typography>
            }
        </div>
        : <Typography>На данный момент нет открытых смен</Typography>
        }
        </Container>
    );
};

export default Voucher;