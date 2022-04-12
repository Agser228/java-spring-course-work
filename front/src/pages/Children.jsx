import React, { useState, useEffect } from 'react';
import ChildService from '../services/ChildService';
import { useNavigate } from 'react-router-dom';

const Children = () => {
    
    const [children, setChildren] = useState([]);

    const router = useNavigate();

    useEffect(() => {
            ChildService.getAllChildren().then((res) => {
                console.log(res)
                
                setChildren(res);
            })
            
    }, [])

    const editChild = (id) => {
        router(`/add/${id}`);
    }

    const viewChild = (id) => {
        router(`/view/${id}`);
    }

    const addChild = () => {
        router('/add/_add');
    }

    const deleteChild = (id) => {
        ChildService.deleteChild(id).then((res) => {
            setChildren({children: children.filter(child => child.id !== id)})
        }); 
    }
    
    console.log("children", children);
    return (
<div>
                <h2 className='text-center'>Список детей</h2>
                
                <button className='btn btn-primary' onClick={addChild}> Добавить ребенка </button>
                
                <div className='row'>
                    <table className='table table-striped table-bordered'>
                        <thead>
                            <tr>
                                <th>Фамилия</th>
                                <th>Имя</th>
                                <th>Отчество</th>
                                <th>День рождения</th>
                                <th>Действия</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                children.map(
                                    child => 
                                    <tr key = {child.id}>
                                        <td>{child.name}</td>
                                        <td>{child.surname}</td>
                                        <td>{child.patronymic}</td>
                                        <td>{child.dateBirth}</td>
                                        <td>
                                            <button onClick={() => editChild(child.id)} className="btn btn-primary">Обновить</button>
                                            <button style={{marginLeft: "10px"}} onClick={() => deleteChild(child.id)} className="btn btn-danger">Удалить</button>
                                            <button style={{marginLeft: "10px"}} onClick={() => viewChild(child.id)} className="btn btn-secondary">Детали</button>
                                        </td>

                                    </tr>
                                    
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
    );
};

export default Children;