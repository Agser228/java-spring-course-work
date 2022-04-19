import React, { useState } from 'react';
import { dictionary, ignore } from '../utils/dictionary';
import { Box, Card, CardContent, CardActions, Button, DialogContent, DialogActions, Dialog, DialogTitle, Typography, Grid } from '@mui/material';

const VoucherItemComponent = ({application}) => {
    const [open, setOpen] = useState(false);
    const [index, setIndex] = useState(0);

    const handleOpen = () => {
        setOpen(true);
      };
    
      const handleClose = () => {
        setOpen(false);
      };


    const showDetails = (index) => {
        setIndex(index);
        handleOpen();
    }
    const rejectVoucher = (id) => {
        handleClose()
        console.log("reject voucher", id);
    }
    const acceptVoucher = (id) => {
        handleClose()
        console.log("accept voucher", id);
    }



    return (


        <Grid item id={application.id} xs={12} sm={12} md={12}>
        <Dialog
        open={open}
        onClose={handleClose}
        >
        <DialogTitle>

        <Typography variant="h6" sx={{
            md: 2
        }}>
            {`Информация по заявке №${application.id}`}
        </Typography>
        </DialogTitle>
        <DialogContent>
            {Object.keys(application)
            .filter((key) => !ignore.includes(key))
            .map(key => 
            (   <Box 
                key={key}
                sx={{
                display: "flex",
                justifyContent: "space-between"
                }}>
                <Typography>{dictionary[key]}</Typography>  
                <Typography>{application[key]}</Typography>  
                </Box>
            
            ))}

        </DialogContent>
        <DialogActions>
        <Button size="small" onClick={() => acceptVoucher(application.id)} color="success">Принять</Button>
        <Button size="small" onClick={() => rejectVoucher(application.id)} color="error">Отклонить</Button>
        </DialogActions>

        </Dialog> 
        <Card
        sx={{ height: '100%', display: 'flex', flexDirection: 'column' }}
        >
        <CardContent>
        <Typography gutterBottom variant="h5" component="h2">
        {`Заявка №${application.id}`}
        </Typography>
        <Typography paragraph>
        {`Время отправки: ${application.timeStamp}`}
        </Typography>
        </CardContent>
        <CardActions sx={{
        justifyContent: "space-between"
        }}>
        <Button size="small" onClick={() => showDetails(index)}>Посмотреть</Button>
        <div>
        <Button size="small" onClick={() => acceptVoucher(application.id)} color="success">Принять</Button>
        <Button size="small" onClick={() => rejectVoucher(application.id)} color="error">Отклонить</Button>
        </div>
        </CardActions>
        </Card>
        </Grid>
    );
};

export default VoucherItemComponent;