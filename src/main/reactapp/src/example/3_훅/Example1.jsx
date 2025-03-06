let a = 0;
export default function Example1(props){
    let b =0;
    ++a;
    ++b;

    //증가 버튼을 클릭했을 때 실행되는 함수
    const 증가함수 = () =>{
        ++a;
        ++b;
    }

    return (<>
    <h3>{++a}</h3> {/* 2*/}
    <h3>{++b}</h3> {/* 2*/}
    <button type="button"  onClick={증가함수}> 증가 함수 </button>
    </>)
}