import { useEffect, useState} from "react"
import { Link } from 'react-router-dom'
import axios from "axios"
export default function Home(props) {
    useEffect(() => {
        onGet();
    }, [])
    const onGet = async () => {
        const response = await axios.get('http://localhost:8080/day09/books')
        console.log(response.data);
        setBooks(response.data);
    }

    const [books, setBooks] = useState([])

    return (<>
        <div>
            <h3>메인 페이지</h3>
            <table>
                <thead>
                    <tr><th>번호</th><th>작가명</th><th>책이름</th><th>설명</th></tr>
                </thead>
                <tbody>
                    {
                        books.map((book, index) => {
                            return (
                                <tr>
                                    <td> <Link to={`/read/${book.id}`}>{book.id}</Link></td>
                                    <td>{book.writer}</td>
                                    <td>{book.name}</td>
                                    <td>{book.comment}</td>

                                </tr>

                            )
                        })
                    }


                </tbody>
            </table>
         
          
        </div>
    </>)
}