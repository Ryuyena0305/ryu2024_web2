import { useEffect,useState } from "react"
import axios from "axios"
import {  useNavigate } from 'react-router-dom';
export default function Update(props){
    const[productForm, setProductForm] = useState({id:'',name:'',price:'',comment:''})
    const onValueChange = ( e ) => { // e : event 약어 : onChange 실행 결과 정보를 매개변수로 받는다.
        // 스레레드연산자 , { ...기존객체 , 새로운속성명 : 새로운값 }
        setProductForm( { ...productForm , [e.target.name] : e.target.value }); 
    }
    const  navigate  = useNavigate();
    const onUpdate = async () => {
        const response = await axios.put('http://192.168.40.32:8080/day08/products' , productForm )
        if( response.data == true ){ alert('제품수정 성공'); navigate('/read'); } 
        else{ alert('제품수정실패'); }
    }
    return (<>
    <div>
        <h3>Update 페이지</h3>
        <form>
            수정할제품번호 : <input name ="id" value={productForm.id} onChange={onValueChange}/><br/>
            새로운제품명 : <input name ="name" value={productForm.name} onChange={onValueChange}/><br/>
            새로운가격 : <input name ="price" value={productForm.price} onChange={onValueChange}/><br/>
            새로운설명 : <input name ="comment" value={productForm.comment} onChange={onValueChange}/><br/>
            <button type="button" onClick={onUpdate}>수정</button>

        
        </form>
        </div>
    </>)
}