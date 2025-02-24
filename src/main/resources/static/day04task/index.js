const onFindAll = async () =>{
try{
    const response = await axios.get('/day04/task/board')
    console.log(response.data);
    const tbody = document.querySelector('tbody')
    let html = ''
    response.data.forEach(board =>{
        html += `
        <tr>
            <td>${board.bno}</td>
            <td>${board.title}</td>
            <td>${board.content}</td>
            <td>
                <button onclick="onUpdate(${board.bno}) ">수정</button>
                <button onclick="onDelete(${board.bno})">삭제</button>
                <button onclick="onfind(${board.bno})">조회</button>
            </td>
        </tr>`
    })
    tbody.innerHTML = html
    }catch(e){console.log(e)}
}
onFindAll();



const onfind = async (bno) =>{
    try{
        const response = await axios.get(`/day04/task/board/view?bno=${bno}`)
        document.querySelector('.title').value = response.data.title
        document.querySelector('.content').value = response.data.content
    }catch(e){console.log(e)}
}



const onSave = () =>{
    const title = document.querySelector('.title').value;
    const content = document.querySelector('.content').value;

  const obj = {title, content}
  axios.post('/day04/task/board', obj)
  .then(response => {console.log(response.data); onFindAll();})
    .catch(error => {console.log(error);});
}

const onUpdate = async (bno) =>{
    const title = prompt('새로운 제목')
    const content = prompt('새로운 내용')

    const obj = {bno, title, content}
    const response = await axios.put('/day04/task/board', obj)
    if(response.data ==1){onFindAll()}
}

const onDelete = async (bno) =>{
    const response = await axios.delete(`/day04/task/board?bno=${bno}`)
    if(response.data ==1){onFindAll()}
}

