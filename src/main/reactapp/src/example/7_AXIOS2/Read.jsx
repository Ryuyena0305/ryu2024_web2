import { useEffect,useState } from "react"
import axios from "axios"
export default function Read(props){
    //[1] 컴포넌트 최초 실행될 때  실행하는 생명주기 함수
    useEffect(()=>{
        console.log('여기는 컴포넌트 실행될 때 1번만 호출됩니다.')
        onRead();
    },[])

    const onRead = async () =>{
        const response = await axios.get('http://localhost:8080/day08/products')
        console.log(response.data);
    }
    return (<>
    <div>Read 페이지</div>
    </>)
}