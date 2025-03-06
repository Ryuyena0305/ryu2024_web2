import { useState } from "react"
let textLength = 0;
export default function Task1() {
    
    // (1) 여기에 state 변수 만들기

    const[text,setText] = useState('');
    const handleChange = (event) => {
        // (2) 여기에서 state 변수값 수정하기.
        console.log(event)
        console.log(event.target)
        console.log(event.target.value)
        console.log(event.target.value.length)
        setText(event.target.value)
        textLength= event.target.value.length; 
       
    }                  

    return (
        <>
            <h1> input에 입력하면 실시간으로 글자 수 세기</h1>
            <input value={text} onChange={handleChange} />
            <p>글자 수:{textLength} </p>
        </>
    )
}