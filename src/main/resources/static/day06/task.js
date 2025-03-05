// 1. let과 const를 사용해서 name(이름)과 age(나이)를 저장하고 값을 출력해 보세요.
let name10 ='류예나';
const age10 ='25';
console.log(`이름 : ${name10} , ${age10}`)
// 2. 숫자 두 개를 받아서 곱한 값을 반환하는 화살표 함수를 작성하세요.
let a = prompt('숫자1을  입력티비');
let b = prompt('숫자2를 입력티비')
const sum = (a, b) => a * b;
console.log(sum(a, b));
// 3. name과 age를 활용해서 "저는 [이름]이고, [나이]살입니다." 를 출력하세요.
const name1 = "Alice";
const age = 25;
console.log(`저는 ${name1}이고, ${age}살 입니다.`);
// 4. user 객체에서 name과 email 값을 추출해 변수를 만들고 출력하세요.
const user = { name: "Alice", email: "alice@example.com", age: 25 };
let username = user.name;
let useremail = user.email;
console.log(`4번문제 : ${username}, ${useremail}`);
// 5. arr1과 arr2를 합쳐 result 배열을 만드세요.
const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];

const arr3 = [...arr1,...arr2];
console.log(arr3);
// 6. greet 함수가 name 값을 받지 않으면 "Guest" 라고 출력하도록 만드세요.
const greet = (name = "Guest") => `Hello, ${name}!`;
console.log(greet());

// 7. 객체를 만들 때 name, age 변수를 그대로 사용하세요.
const name2 = "Alice";
const age2 = 25;
const obj4 = {name2,age2}
console.log(obj4)

// 8. 첫 번째 값을 first, 나머지를 rest에 저장하세요.
const numbers = [10, 20, 30, 40];
let first = numbers[0]
let rest = numbers[3]

console.log(`8번문제 : ${first}, ${rest}`)
// 9. isLoggedIn이 true면 "Welcome!", false면 "Please log in."을 출력하세요.
const isLoggedIn = true;
console.log( isLoggedIn == true ? 'Welcome!' : 'Please log in.' )
// 10. 동기 fetch를 사용해서 JSONPlaceholder API에서 https://jsonplaceholder.typicode.com/posts/1 데이터를 가져오세요.
// const fun9 =  async ( ) => {
//     await fetch('').then( response => response.json() ).then( data => {} ).catch( error => {} )
    
// }
const fun9 = async () => {
    try {
        const response = await fetch('https://jsonplaceholder.typicode.com/posts/1');
        const data = await response.json();
        console.log(data);
    } catch (e) {console.log(e);}
}

fun9();

// 11. 배열 ages에서 각 나이를 기준으로 "성인" 또는 "미성년자"를 판단하여 새로운 배열을 만들어 출력하세요.
const ages = [25, 12, 20, 8];
let adult = [];
let child = [];
for( let index = 0 ; index <= ages.length-1 ; index++ ){
    if(ages[index]<20){
        child.push(ages[index])
    }else{
        adult.push(ages[index])
    }
}
console.log(`미성년자 : ${child}, 성인 : ${adult}`)
