import { useEffect,useState } from "react";
import axios from "axios";
import './Task.css';  

export default function Task(props) {
    const [formData, setFormData] = useState({name:'',phone:''})
    const formDataChange = (e)=>{
        console.log( e.target ); // 'onChange'이벤트를 발생한 html dom(마크업/태그)
        console.log( e.target.name ); // 'onChange'이벤트를 발생한 html dom의 name 속성 값 반환 
        console.log( e.target.value ); // 'onChange'이벤트를 발생한 html dom의 value 속성 값 반환
        setFormData({...formData,[e.target.name]:e.target.value});
    }

    const onPost = async ( e ) => {
        try{
            const response = await axios.post('http://192.168.40.32:8080/day07/task' , formData ); // state변수를 axios로 보내기
            if( response.data == true ){ 
                alert('등록성공');   
                setFormData({ name :'',phone:'' });
                onFindAll(); 
            }else{ 
                alert('등록실패');
            }
        }catch( error ){ console.log( error ); }
    }
    useEffect(()=>{onFindAll()},[]);
    const [contacts,setContects] = useState([]);
    const onFindAll = async () =>{
        try{
            const response = await axios.get('http://192.168.40.32:8080/day07/task');
            setContects(response.data);
        }catch(error){console.log(error);}
    }

    return (<>
     <div>
            <h3>📞전화번호 등록📞</h3><br/>
            <form>
                이름 : <input type="text" value={ formData.name } name='name' onChange={ formDataChange }  /> 
                연락처 : <input type="text" value={ formData.phone } name='phone' onChange={ formDataChange }  /> <br/>
                <button type="button" onClick={ onPost }> 등록 </button>
            </form>
            <table>
                <thead><tr><th>번호 </th><th> 이름 </th><th> 연락처 </th><th> 비고 </th></tr></thead>
                <tbody>
                    {
                        contacts.map( ( contact , index ) => {
                            return ( 
                                <tr> 
                                    <td>{ index+1 }</td> 
                                    <td>{ contact.name}</td> 
                                    <td>{ contact.phone}</td> 
                                    <td>수정 / 삭제</td>
                                </tr> 
                                )
                        })
                    }
                </tbody>
            </table>
            </div>
    </>)
}
