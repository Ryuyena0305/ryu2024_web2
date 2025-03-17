import { useEffect,useState } from "react"
import axios from "axios"
import {  useNavigate } from 'react-router-dom';

export default function Delete(props){
    
    const [id,setId] =useState('');
    const  navigate  = useNavigate();
    const onDelete = async () => {
        const response = await axios.delete(`http://192.168.40.32:8080/day08/products?id=${id}`);


        if( response.data == true ){ alert('제품삭제 성공'); navigate('/read'); } 
        else{ alert('제품삭제실패'); }
    } // f end 
    return (<>
    <div>
        <h3>Delete 페이지</h3>
        삭제할제품번호 : <input type="number" value={id} onChange={(e)=>setId(e.target.value)}/><br/>
        <button type="button" onClick={onDelete}>삭제</button>
        </div>
    </>)
}