import React, { Component } from 'react';
import ChildService from '../services/ChildService';

class ViewChildComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            employee: {},
            schema: {
                id: "Идентификатор",
                parentId: "Идентификатор родителя",
                squadId: "Идентификатор отряда",
                name: "Имя",
                surname: "Фамилия",
                patronymic: "Отчество",
                dateBirth: "День рождения",
                birthCertificateNumber: "Номер свидетельства рождения",
                address: "Адрес",
                age: "Возраст",

            }
        }
    }

    componentDidMount() {
        ChildService.getChildById(this.state.id).then((res) => {
            let employee = res.data.data.child;
            this.setState({
                employee: employee,
            });

            console.log("employee => " + JSON.stringify(employee));
        });
    }


    render() {
        return (
            <div>
                <h2 className='text-center'>Ребенок {this.state.employee.id}</h2>
                
                <div className='row'>
                    <table className='table table-striped table-bordered'>
                        <thead>
                            <tr>
                                <th>Свойство</th>
                                <th>Значение</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                            
                            Object.entries(this.state.employee).map(([key, value]) =>  (
                                <tr>
                                <td>{this.state.schema[key]}</td>
                                <td>{value}</td>
                            </tr>)
                            )   
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default ViewChildComponent;