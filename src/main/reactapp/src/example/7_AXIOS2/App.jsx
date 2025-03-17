//App.jsx : 라우터 (가상URL)이용한 라우팅

import { BrowserRouter, Route, Routes } from 'react-router-dom'; //npm i reacct-router-dom
/* 라우터로 연결할 컴포넌트 import 가져온다. */
import Home from './Home.jsx'
import Create from './Create.jsx'
import Read from './Read.jsx'
import Update from './Update.jsx'
import Delete from './Delete.jsx'
import SideBar from './SideBar.jsx'
/**css import */
import './app.css';
export default function App(props) {//컴포넌트
    return (<>
        <BrowserRouter>
            <div id="wrap">
                <SideBar />
                <Routes>{/* 가상으로 정의한 URL을 감싼다.*/}
                    <Route path="/" element={<Home />} />{/* 가상의 URL정의. 컴포넌트 연결*/}
                    <Route path="/create" element={<Create />} />{/* 가상의 URL정의. 컴포넌트 연결*/}
                    <Route path="/read" element={<Read />} />{/* 가상의 URL정의. 컴포넌트 연결*/}
                    <Route path="/update" element={<Update />} />{/* 가상의 URL정의. 컴포넌트 연결*/}
                    <Route path="/delete" element={<Delete />} />{/* 가상의 URL정의. 컴포넌트 연결*/}
                </Routes>
            </div>

        </BrowserRouter>
    </>)
}