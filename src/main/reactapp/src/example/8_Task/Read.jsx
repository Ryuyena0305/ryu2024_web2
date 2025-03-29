import { useEffect, useState } from "react";
import axios from "axios";
import { useParams } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';

export default function Read(props) {
    const { id } = useParams();
    console.log(id);

    const [books, setBooks] = useState();
    const [reviews, setReviews] = useState([]);  // State for storing reviews
    const [bookForm, setBookForm] = useState({
        writer: '',
        name: '',
        comment: '',
        pwd: ''
    });

    useEffect(() => {
        onGet();
    }, [id]);

    const onGet = async () => {
        try {
            const response = await axios.get(`http://localhost:8080/day09/books/byid?id=${id}`);
            console.log(response.data);

            setBookForm({
                id: response.data.id,
                writer: response.data.writer,
                name: response.data.name,
                comment: response.data.comment,
                pwd: ''
            });

            setBooks(response.data);

          
            fetchreview(response.data.id);  
        } catch (error) {
            console.error(error);
        }
    };

    const fetchreview = async (bookId) => {
        try {
            const response = await axios.get(`http://localhost:8080/day09/review?id=${bookId}`);
            setReviews(response.data); 
        } catch (error) {
            console.log(error);
        }
    };

    const onValueChange = (e) => {
        setBookForm({ ...bookForm, [e.target.name]: e.target.value });
    };

    const navigate = useNavigate();

    const onUpdate = async () => {
        if (String(bookForm.pwd) !== String(books.pwd)) {
            alert('비밀번호가 일치하지 않습니다.');
            console.log("입력 비밀번호:", bookForm.pwd);
            console.log("저장 비밀번호:", books.pwd);
            return;
        }

        const response = await axios.put('http://localhost:8080/day09/books', bookForm);
        if (response.data == true) {
            alert('책 수정 성공');
            navigate('/');
        } else {
            alert('책 수정 실패');
        }
    };

    const onDelete = async () => {
        if (String(bookForm.pwd) !== String(books.pwd)) {
            alert('비밀번호가 일치하지 않습니다.');
            console.log("입력 비밀번호:", bookForm.pwd);
            console.log("저장 비밀번호:", books.pwd);
            return;
        }

        const response = await axios.delete(`http://localhost:8080/day09/books?id=${id}`);
        if (response.data == true) {
            alert('책 삭제 성공');
            navigate('/');
        } else {
            alert('책 삭제 실패');
        }
    };

    return (
        <div>
            <h3>상세 페이지</h3>
            <form>
                작가명 : <input
                    className="writerinput"
                    name="writer"
                    value={bookForm.writer}
                    onChange={onValueChange}
                /> <br />
                책이름 : <input
                    className="nameinput"
                    name="name"
                    value={bookForm.name}
                    onChange={onValueChange}
                /> <br />
                책설명 : <textarea
                    className="commentinput"
                    name="comment"
                    value={bookForm.comment}
                    onChange={onValueChange}
                ></textarea> <br />
                비밀번호 : <input
                    name="pwd"
                    value={bookForm.pwd}
                    onChange={onValueChange}
                /> <br />
                <button type="button" onClick={onUpdate}>제품수정</button>
                <button type="button" onClick={onDelete}>제품삭제</button>
            </form>

            <h4>댓글</h4>
            <div>
                {reviews.length > 0 ? (
                    reviews.map((review, index) => (
                        <div key={index}>
                            <p>{review.rcontent}</p>
                        </div>
                    ))
                ) : (
                    <p>댓글이 없습니다.</p>
                )}
            </div>
        </div>
    );
}
