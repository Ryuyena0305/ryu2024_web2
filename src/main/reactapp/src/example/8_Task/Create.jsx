import axios from "axios";
import { useState } from "react"
import {  useNavigate } from 'react-router-dom';

export default function Create( props ){


    const [ bookForm , setBookForm ] = useState({ writer : '', name : ''  , comment : ''} )
   
    const onValueChange = ( e ) => { 
      
        setBookForm( { ...bookForm , [e.target.name] : e.target.value }); 
    }
    
    const  navigate  = useNavigate();
    const onCreate = async () => {
        const response = await axios.post('http://192.168.40.32:8080/example.day09/books' , bookForm )
        if( response.data == true ){ alert('책추천등록 성공'); navigate('/'); } 
        else{ alert('책추천등록 실패'); }
    } // f end 

    return(<> 
        <div> 
            <h3> Create 페이지 </h3> 
            <form>
                작가명 : <input name='writer' value={ bookForm.writer } onChange={ onValueChange } /> <br/>
                책이름 : <input name="name" value={ bookForm.name } onChange={ onValueChange } /> <br/>
                책설명 : <textarea name="comment" value={ bookForm.comment} onChange={ onValueChange }></textarea> <br/>
                비밀번호 : <input type="password" name='pwd' value={ bookForm.pwd } onChange={ onValueChange } /> <br/>
                <button type="button" onClick={ onCreate }> 제품등록 </button>
            </form>
        </div> 
    </>)
}