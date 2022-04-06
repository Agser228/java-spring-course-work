import React from 'react';

const CreateVoucherComponent = () => {
    return (
        <div>
            <div className='container'>
                    <div className='row'>
                        <div className='card col-md-6 offset-md-3 offset-md-3'>
                            <h3 className='text-center'>Заполнение путевки</h3>
                            <div className='card-body'>
                                {/* <form>
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
                                    
                            

                                </form>  */}
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    );
};

export default CreateVoucherComponent;