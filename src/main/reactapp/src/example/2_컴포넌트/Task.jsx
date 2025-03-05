/*
리액트 과제 : 아래 코드들을 사용하여 결과 예시 구현하여 제출
조건1 : 두개의 컴포넌트 모두 활용하시오.
*/ 
import './Task.css'
const ProductCard = ( props ) => {
    return (<>
    <Task/>
    </>);
  };
  
  export default function Task( props ) {
    const products = [
      { title: "무선 키보드", price: 45000, inStock: true },
      { title: "게이밍 마우스", price: 32000, inStock: false },
      { title: "27인치 모니터", price: 280000, inStock: true }
    ];
    return (<>
                <div className='box'>
            {   
                products.map((product, index) => (
                    <div className= 'boxbox'key={index}>
                   
                    <div className='boxdetail title'>{product.title} </div><br/>
                    <div className='boxdetail'>가격 : {product.price}</div> <br/>
                    <div className='boxdetail'>{product.inStock==true ? <div className='instockTrue'>재고있음 </div>: <div className='instockFalse'>재고없음</div>} </div><br/>
                 
                    </div>
                ))
                
            }
        </div>
    </>);
  }