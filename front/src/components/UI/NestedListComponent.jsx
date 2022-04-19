import ExpandLess from "@mui/icons-material/ExpandLess";
import ExpandMore from "@mui/icons-material/ExpandMore";
import InboxIcon from "@mui/icons-material/MoveToInbox";
import StarBorder from "@mui/icons-material/StarBorder";
import { Grid, Card, CardContent, Typography, CardActions, Button} from "@mui/material";
import Collapse from "@mui/material/Collapse";
import List from "@mui/material/List";
import ListItemButton from "@mui/material/ListItemButton";
import ListItemIcon from "@mui/material/ListItemIcon";
import ListItemText from "@mui/material/ListItemText";
import React, {useState } from "react";
import ItemSquadComponent from './../ItemSquadComponent';

export default function NestedListComponent({squads}) {
  const [open, setOpen] = useState(true);

  const handleClick = () => {
    setOpen(!open);
  };



  return (

    <Grid container 
    spacing={4}
    sx = {{
      alignItems: "center"
    }}
    >
      {
        squads.map((squad) => (
          <Grid item key={squad.id} xs={12} sm={6} md={4}>
            <ItemSquadComponent squad={squad}/>
          </Grid>
        ))
      }



    </Grid>




//     <List
//       sx={{ width: "100%", bgcolor: "background.paper" }}
//       component="nav"
//     >
//     { squads.map((squad) => 
//     <div>
//       <ListItemButton onClick={handleClick}>
//         <ListItemIcon>
//           <InboxIcon />
//         </ListItemIcon>
//         <ListItemText primary={`Отряд №${squad.id}`} />
//         {open ? <ExpandLess /> : <ExpandMore />}

        
//       </ListItemButton>
//       <Collapse in={open} timeout="auto" unmountOnExit>
//       { squad.children.map((child) =>
//             <List component="div" disablePadding>
//             <ListItemButton sx={{ pl: 4 }}>
//                 <ListItemIcon>
//                 <StarBorder />
//                 </ListItemIcon>
//                 <ListItemText primary={`${child.name} ${child.surname}`} />
//             </ListItemButton>
//             </List>
//       )
//     }
//     </Collapse>
//       </div>
//     )
// }
//     </List>
  );
}
