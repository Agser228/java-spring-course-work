import React, {useState} from 'react';
import FormComponent from '../components/FormComponent';
import VoucherService from '../services/VoucherService';
const Voucher = () => {


    const [parent, setParent] = useState({});
    const [child, setChild] = useState({});

    const submit = (e) => {
        e.preventDefault()
        console.log("submit");
        
        let voucher = {parent, child};
        console.log(voucher);
        VoucherService.createVoucher(voucher).then((res) => {
            console.log(res);
        });
    }


    return (
        <div className="container">
        <form style={{display: "flex", justifyContent: "space-around", flexDirection: "column"}}>
        <div style={{display: "flex", justifyContent: "space-around"}}>
        <FormComponent entity={"parent"} formName={"Данные родителя"} setter={setParent}/>
        <FormComponent entity={"child"} formName={"Данные ребенка"} setter={setChild}/>
        </div>
        <input value="Отправить" type="submit" onClick={submit}/>
        </form>
        </div>
    );
};

export default Voucher;