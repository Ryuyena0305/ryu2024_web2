// script.js

// 10개의 행 (A~J)과 10개의 열 (1~10)로 좌석 생성
const rows = ['A', 'B']; // 10개의 행
const columns = 9; // 각 행에 10개의 좌석
const rows2 =['C', 'D', 'E', 'F', 'G', 'H', 'I', 'J']
const columns2 = 10;
const seatsData = [];

// 좌석 데이터 자동 생성
rows.forEach(row => {
    for (let col = 1; col <= columns; col++) {
        seatsData.push({
            row: row,
            column: col,
            status: 'available',  // 기본적으로 'available'로 설정
        });
    }
});
rows2.forEach(row => {
    for (let col = 1; col <= columns2; col++) {
        seatsData.push({
            row: row,
            column: col,
            status: 'available',  // 기본적으로 'available'로 설정
        });
    }
});

// 좌석을 그리기 위한 함수
function renderSeats() {
    const container = document.getElementById('seats-container');
    container.innerHTML = ''; // 기존 좌석들을 지웁니다.

    // 좌석 배열을 순회하면서 HTML로 좌석을 생성합니다.
    seatsData.forEach((seat, index) => {
        const seatElement = document.createElement('div');
        seatElement.classList.add('seat');
        seatElement.classList.add(seat.status); // 상태에 맞는 클래스 추가
        seatElement.dataset.index = index; // 각 좌석에 인덱스를 추가하여 클릭 이벤트를 처리합니다.
        seatElement.textContent = `${seat.row}${seat.column}`; // 좌석의 번호 (예: A1, A2)

        // 클릭 시 예약/취소 기능
        seatElement.addEventListener('click', function() {
            if (seat.status === 'reserved') {
                alert('이미 예약된 좌석입니다.');
                return;
            }

            // 예약된 좌석으로 상태 변경
            if (seat.status === 'available') {
                seat.status = 'reserved';
                seatElement.classList.remove('available');
                seatElement.classList.add('reserved');
            } else {
                seat.status = 'available'; // 예약 취소
                seatElement.classList.remove('reserved');
                seatElement.classList.add('available');
            }
        });

        container.appendChild(seatElement);
    });
}

// 페이지 로드 시 좌석 그리기
document.addEventListener('DOMContentLoaded', renderSeats);
