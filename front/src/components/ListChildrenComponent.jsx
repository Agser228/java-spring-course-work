import React, { Component } from 'react';
import ChildService from '../services/ChildService';

class ListChildrenComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            children: [],
        }

        this.addChild = this.addChild.bind(this);
        this.editChild = this.editChild.bind(this);
        this.deleteChild = this.deleteChild.bind(this);
        this.viewChild = this.viewChild.bind(this);
    }

    componentDidMount() {
        ChildService.getAllChildren().then((res) => {
            this.setState({children: res});
        })
    }

    editChild(id) {
        this.props.history.push(`/add/${id}`);
    }

    viewChild(id) {
        this.props.history.push(`/view/${id}`);
    }

    addChild() {
        this.props.history.push('/add/_add')
    }

    deleteChild(id) {
        ChildService.deleteChild(id).then((res) => {
            this.setState({Children: this.state.children.filter(Child => Child.id !== id)})
        }); 
    }

    render() {
        return (
            <div>
                <h2 className='text-center'>Список детей</h2>
                
                <button className='btn btn-primary' onClick={this.addChild}> Добавить ребенка </button>
                
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
                                this.state.children.map(
                                    child => 
                                    <tr key = {child.id}>
                                        <td>{child.name}</td>
                                        <td>{child.surname}</td>
                                        <td>{child.patronymic}</td>
                                        <td>{child.dateBirth}</td>
                                        <td>
                                            <button onClick={() => this.editChild(child.id)} className="btn btn-primary">Обновить</button>
                                            <button style={{marginLeft: "10px"}} onClick={() => this.deleteChild(child.id)} className="btn btn-danger">Удалить</button>
                                            <button style={{marginLeft: "10px"}} onClick={() => this.viewChild(child.id)} className="btn btn-secondary">Детали</button>
                                        </td>

                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default ListChildrenComponent;
