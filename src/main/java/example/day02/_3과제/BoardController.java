package example.day02._3과제;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//[ 스프링 과제2 ]
//day02 -> _3과제 폴더에서 진행
//주제 : 게시판 RestController 만들기
//    1. AppStart 클래스 생성    2. BoardController 클래스 생성 3. BoardDto 클래스 생성(롬복 사용)
//    3. BoardController 클래스에 List<BoardDto> 멤버변수로 선언한다.
//        +bno는 list add 할때 마다 자동으로 증가하도록 설계
//    3. 각 URL 매핑 만들기 , REST 명세서
//        1. 글쓰기           POST       "/day02/task1/board"
//요청자료 : { "title" : "" , "content" : "" }
//응답자료 : true 또는 false
//
//        2. 전체 글 조회      GET        "/day02/task1/board"
//요청자료 : x
//응답자료 : [ { "bno": "" , "title" : "" , "content" : "" } ,
//        { "bno": "" , "title" : "" , "content" : "" }  ]
//
//        3. 개별 글 조회      GET        "/day02/task1/board/view"
//요청자료 : ?bno=1
//응답자료 : { "bno": "" , "title" : "" , "content" : "" }
//
//        4. 개글 글 수정      PUT        "/day02/task1/board"
//요청자료 : { "bno": "" , "title" : "" , "content" : "" }
//응답자료 : true 또는 false
//
//        5. 개별 글 삭제      DELETE     "/day02/task1/board"
//요청자료 : ?bno=1
//응답자료 : true 또는 false
//
//제출 : 카카오톡방에 ip 제출
@RestController
@RequestMapping("/day02/task1")

public class BoardController {

    //DB 역할
    private final List<BoardDto> boardList = new ArrayList<>();
    private int auto_bno = 1; // bno 자동번호

    // POST 매핑으로 주소의 body값을 dto로 매핑하여 함수 매개변수로 받는다
    @PostMapping("/board")
    public boolean method1(@RequestBody BoardDto boardDto) { // body값을 함수 매개변수로 매핑한
        boardDto.setBno(auto_bno); // bno 자동 ���가
        boardList.add(boardDto);
        auto_bno++;
        return true;
    }

    @GetMapping("/board")
    public List<BoardDto> method2() {
        return boardList;
    }
    @GetMapping("/board/view")
    public BoardDto method3(@RequestParam("bno") int bno) {
        for (int index = 0; index < boardList.size(); index++) {
            BoardDto boardDto = boardList.get(index);
            if (boardDto.getBno() == bno) {return boardDto;}
        }// for e
        return null;
    }

    @PutMapping("/board")
    public boolean method4(@RequestBody BoardDto boardDto) {
        for(int index = 0; index < boardList.size(); index++) {
            BoardDto boardDto2 = boardList.get(index);
        if(boardDto2.getBno() == boardDto.getBno()) {
            boardList.set(index, boardDto);
            return true;
        }// if e
        }// for e
        return false;
    }

    @DeleteMapping("/board")
    public boolean method5(@RequestParam(name="bno") int bno) {
    for(int index = 0; index < boardList.size(); index++) {
        BoardDto boardDto2 = boardList.get(index);
        if(boardDto2.getBno() == bno) {
            boardList.remove(index);
            return true;
        }// if e
        }// for e
        return false;
    }//f e
}

