//[1] 등록 함수
const onSave = ()=>{

const name = document.querySelector('.name').value;
const kor = document.querySelector('.kor').value;
const math = document.querySelector('.math').value;
const obj = {name:name,kor:kor,math:math};

//fetch vs axios(기본값 json) vs $.ajax(JQuery)
//1. axios 설치 : HTML 에 axios cdn 코드를 넣어준다. <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
//2. axios 문법 :
    //1. axios.[HTTP 메소드명].() : axios.get(), axios.post(), axios.put(), axios.delete()
    //2. .('통신할HTTP URL', {옵션})
    axios.post('day04/student')
    .then(response => {console.log(response);})
    .catch(error => console.log(error));


//(2)
/*
option = {
method: 'POST',
headers : {'Content-Type': 'application/json'},
body : JSON.stringify(obj)
}
//(3)
fetch('day04/student',option)
.then(response => response.json())
.then(data => {console.log(data);})
.catch(error => console.log(error))
}
*/