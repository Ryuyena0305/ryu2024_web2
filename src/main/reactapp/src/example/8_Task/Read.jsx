import { useEffect, useState  } from "react"
//import { Link } from 'react-router-dom'
import axios from "axios"
import {  useNavigate,useParams } from 'react-router-dom';
export default function Read(props) {

    const { id } = useParams(); 
    const[books,setBooks] = useState();
    useEffect(() => {
        onGet();
    }, [id])
    
    const onGet = async () => {
     
        const response = await axios.get(`http://192.168.40.32:8080/example.day09/books/byid?id=${id}`)
        console.log(response.data);
        document.querySelector(".writerinput").value = response.data.writer;
        document.querySelector(".nameinput").value = response.data.name;
        document.querySelector(".commentinput").value = response.data.comment;
        setBooks(response.data);
        
        
    }
   

   
    const [ bookForm , setBookForm ] = useState({  
        writer: '',
        name: '',
        comment: ''} )
   
    const onValueChange = ( e ) => { 
    
        setBookForm( { ...bookForm , [e.target.name] : e.target.value }); 

    }
    const  navigate  = useNavigate();
    const onUpdate = async () => {
        const response = await axios.put('http://192.168.40.32:8080/example.day09/books' , bookForm )
        if( response.data == true ){ alert('책수정성공'); navigate('/'); } 
        else{ alert('책수정실패'); }
    } // f end 
    const onDelete = async () => {
        const response = await axios.delete(`http://192.168.40.32:8080/example.day09/books?id=${id}`);

        if( response.data == true ){ alert('책 삭제 성공'); navigate('/'); } 
        else{ alert('책삭제실패'); }
    } // f end 

    return (<>
    
    <div>
            <h3>상세 페이지</h3>

            
            <form>
                작가명 : <input class="writerinput" name='writer'  value={ bookForm.writer } onChange={ onValueChange } /> <br/>
                책이름 : <input class="nameinput" name="name" value={ bookForm.name } onChange={ onValueChange } /> <br/>
                책설명 : <textarea class="commentinput" name="comment" value={ bookForm.comment} onChange={ onValueChange }></textarea> <br/>
                비밀번호 : <input  name='pwd' value={ bookForm.pwd } onChange={ onValueChange } /> <br/>
                <button type="button" /*onClick={ onUpdate }*/> 제품수정 </button>
                <button type="button" /*onClick={ onDelete }*/> 제품삭제 </button>
            </form>
         
          
        </div>

    </>)
}