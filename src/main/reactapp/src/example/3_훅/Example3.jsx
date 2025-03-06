import { useState } from "react";

export default function Example3(props){
    //(1) 일반적인 JS방법
    const 입력함수 = () =>{
        const msg = document.querySelector('#msg').value;
        console.log(msg);
    }
    //(2) 리액트 방법
    const[msg,setMsg] = useState('')//상태(state) 변수 : 변수값에 따른 컴포넌트를 렌더링 제공
    const 입력함수2 = (eventObj) =>{
      console.log(eventObj)
      console.log(eventObj.target)
      console.log(eventObj.target.value)
        setMsg(eventObj.target.value)
    }

    // const[image,setImage] = useState('짱구(1).jpg')
    // const 변경함수3 = () => {
    //     setImage(image == '짱구(1).jpg'?'짱구(2).jpg':'짱구(1).jpg')
    // }

    const[image,setImage] = useState('main(2).jpg')
    const 변경함수3 = () => {
        setImage(image == 'main(2).jpg'?'main(4).jpg':'main(2).jpg')
    }
    return (<>
    <h2>일반적인 JS방법</h2>
    <input id="msg"/><br/>
    <button onClick={입력함수}>입력 버튼</button>

    <h2>리액트 JS 방법</h2>
    <input value={msg} onChange={입력함수2}/><br/>
    <button >입력 버튼</button>

    <h2>리액트 이미지 변경</h2>
    <img onClick={변경함수3} src={image}/>
    <img onClick={ () => { setImage( image == 'main(2).jpg'?'main(4).jpg':'main(2).jpg') } } src={ image } />
    </>)
}
/*
    HTML 이벤트 함수  , onXXXX , 미리 만들어진 함수를 제공한다. 
        [1] 종류 
            onclick     : HTML 마크업에 클릭했을때 이벤트함수 실행 
            onchange    : HTML 마크업에 값이 변경되었을때 이벤트함수 실행 
            등등
        [2] 반환를 제공한다. 
            - 이벤트함수가 실행된 결과를 객체로 다음 로직으로 반환된다.
            - onClick ={ ( e ) => { } }
                onClick 함수가 실행되고 나서 실행결과를 e(매개변수)로 다음 함수에게 전달
    
    HTML 이벤트 함수 VS JSX(리액트) 이벤트 함수 차이점 
    함수명 : onclick/onchange  vs onClick/onChange          * 차이점 : 리액트에는 카멜표기법 사용한다.
    속성값 : onclick = "함수명()" vs onClick = { 함수명 }    * 차이점 : 리액트에서는 {} 안에 함수호출이 아닌 함수명 표시한다.
    결과리턴 : onclick = "함수명(e)"    
                                       vs onClick = { 함수명 }       : 함수명이 존재하는 경우  [ 다회성 ]
                                       vs onClick = { (e) => { } }    : 함수명이 존재하지 않는경우 [ 일회성 ]
                                       
*/