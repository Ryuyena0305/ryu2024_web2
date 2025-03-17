import { Link } from 'react-router-dom'

export default function Sidebar(props) {
    return (<>
        <div>
            <ul id="sideMenu">
                <li>사이드바 메뉴</li>
                <li><Link to="/">메뉴1 : HOME</Link></li>
                <li><Link to="/create">메뉴2 : CREATE</Link></li>
            </ul>
        </div>
    </>)
}