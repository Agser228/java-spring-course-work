import { Container, Typography, Paper, Grid } from '@mui/material';
import VoucherItemComponent from './../components/VoucherItemComponent';

import React, { useEffect, useState } from 'react';
import VoucherService from './../services/VoucherService';


const Applications = () => {

    const [applications, setApplications] = useState([]);

    useEffect(() => {
        VoucherService.getAllVouchers().then((vouchers) => {
            setApplications(vouchers);
            console.log(vouchers);
        })
    }, []);


    return (
        <Container 
        maxWidth="md"
        component={Paper}
        sx={{
            mt: 2,
            p: 6,
            mb: 2
        }}
        >

        <Typography
            variant="h3"
            align="center"
            >
            Полученные заявки
        </Typography>
        {
            !applications.length
            ? <Typography>Пока что заявок нет</Typography>
            :    
           
            
            <Grid container spacing={2}>
                {
                applications.map((application, index) => (

                    <VoucherItemComponent application={application}/>
                ))
            }
        </Grid>
        }


        </Container>
    );
};

export default Applications;