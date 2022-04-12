import React from 'react';
import { useEffect } from 'react';
import { useState } from 'react';
import NestedListComponent from '../components/UI/NestedListComponent';
import SquadService from '../services/SquadService';

const Squads = () => {

    const [squads, setSquads] = useState([])

    useEffect(() => {
            SquadService.getAllSquads().then((squads) => {
                setSquads(squads);
            });
    }, []);
        

    return (
        <div>
            {squads.length 
            ? <NestedListComponent squads={squads}/>
            : <h3>Отряда пока не сформированы</h3>
}
        </div>
    );
};

export default Squads;



