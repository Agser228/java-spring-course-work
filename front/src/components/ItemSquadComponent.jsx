import React, { useState } from 'react';
import { Grid, Card, CardContent, Typography, CardActions, Button} from "@mui/material";
import DialogFormComponent from './DialogFormComponent';
import SquadFormComponent from './SquadFormComponent';


const ItemSquadComponent = ({squad}) => {


    const showSquad = () => {
        handleOpenEdit();
    }

    
    const [openEdit, setOpenEdit] = useState(false);


    const handleOpenEdit = () => {   setOpenEdit(true);  };
    const handleCloseEdit = () => {  setOpenEdit(false);  };


    return (
        <Card
        sx={{ height: '100%', display: 'flex', flexDirection: 'column' }}
      >
{/* 
        <DialogFormComponent
        entity={squad}
        onClose={handleCloseEdit}
        entityName={"squad"}
        open={openEdit}
        callback={() => {}}
        purpose="update"
        /> */}

        <SquadFormComponent
        open={openEdit}
        onClose={handleCloseEdit}
        squad={squad}
        />

          
        <CardContent>
        <Typography gutterBottom variant="h5" component="h2">
            {`Отряд №${squad.number}`}
            </Typography>
            <Typography paragraph>
            {`Средний возраст: ${squad.averageAgeChildren}`}
            </Typography>
            <Typography paragraph>
            {`Размер отряда: ${squad.children.length}`}
            </Typography>
        </CardContent>
        <CardActions>
            <Button 
            size="small"
            onClick={showSquad}
            >Посмотреть отряд</Button>
          </CardActions>
      </Card>
    );
};

export default ItemSquadComponent;