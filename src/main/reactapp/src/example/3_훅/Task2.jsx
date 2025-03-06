import { useState } from "react";
import './Task.css';  

const ProductCard = ({ viewindex,name, phone }) => {
    return (
        <>
            <ul>
                <li>🎀{viewindex+1}  이름 : {name} 연락처 : {phone}</li>
            </ul>
        </>
    );
};

export default function Task(props) {
    const [inputName, setInputName] = useState('');
    const [inputPhone, setInputPhone] = useState('');

    const handleChangeName = (event) => {
        setInputName(event.target.value);
        console.log(event.target.value);
    };

    const handleChangePhone = (event2) => {
        setInputPhone(event2.target.value);
        console.log(event2.target.value);
    };

    const [phoneList, setPhoneList] = useState([]);

    const pushFun = () => {
        setPhoneList([...phoneList, { inputName, inputPhone }]);
        console.log(phoneList);
    };

    return (
        <>
            <h3>📞전화번호 등록📞</h3><br />
            <input
                value={inputName}
                onChange={handleChangeName}
                placeholder="이름"
            />
            <br />
            <input
                value={inputPhone}
                onChange={handleChangePhone}
                placeholder="연락처"
            />
            <br />
            <button onClick={pushFun}>전화번호 등록</button>
            <div className="phonebox">
                {phoneList.map((phone, index) => {
                    return <ProductCard key={index} viewindex={index} name={phone.inputName} phone={phone.inputPhone} />;
                })}
            </div>
        </>
    );
}
