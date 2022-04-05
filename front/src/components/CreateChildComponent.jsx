import React, { Component } from 'react';
import ChildService from '../services/ChildService';

class CreateChildComponent extends Component {
    constructor(props) {
        super(props)
        
        this.state = {
            id: this.props.match.params.id,
            name: "",
            surname: "",
            emailId: "",

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
        
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeSurnameHandler = this.changeSurnameHandler.bind(this);
        this.saveChild = this.saveChild.bind(this);
        
    }
    
    componentDidMount() {
        console.log("id: " + this.state.id);
        if (this.state.id === "_add") {
            return;
        } else {
            ChildService.getChildById(this.state.id).then((res) => {
                let employee = res.data;
                this.setState({
                    name: employee.name,
                    surname: employee.surname,
                    emailId: employee.emailId,
                });

                console.log("employee => " + JSON.stringify(employee));
            });
        }
    }

    changeNameHandler = (event) => {
        this.setState({name: event.target.value});
    }
    changeSurnameHandler = (event) => {
        this.setState({surname: event.target.value});
    }
    changeEmailHandler = (event) => {
        this.setState({emailId: event.target.value});
    }

    saveChild = (e) => {
        e.preventDefault();
        let employee = {name: this.state.name, surname: this.state.surname, emailId: this.state.emailId};
        console.log("employee => " + JSON.stringify(employee));
        if (this.state.id === "_add") {
            ChildService.createChild(employee).then(res => {
                this.props.history.push('/employees');
            });
        } else {
            ChildService.updateChild(this.state.id, employee).then(res => {
                this.props.history.push('/employees');
            });
        }
    }

    cancel() {
        this.props.history.push('/employees')
    }

    render() {
        return (
            <div>
                <div className='container'>
                    <div className='row'>
                        <div className='card col-md-6 offset-md-3 offset-md-3'>
                            <h3 className='text-center'>{this.state.id === "_add" ? "Добавить ребенка" : "Обновить ребенка"}</h3>
                            <div className='card-body'>
                                <form>
                                {
                            
                            Object.entries(this.state.schema).map(([key, value]) =>  (
                                

                                    <div className='form-group'>
                                    <label>{value}</label>
                                    <input placeholder={value} name={key} className='form-control'
                                        value={key} onChange={(event) => {
                                            this.setState({key: event.target.value});
                                        }}/>    
                                    </div>))
                                    }
                                    
                            

                                </form> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default CreateChildComponent;