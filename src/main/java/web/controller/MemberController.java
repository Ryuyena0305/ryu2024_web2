package web.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.dto.MemberDto;
import web.service.MemberService;

@RestController //@ResponseBody 포함하며 restApi 지원하는 컨트로럴 빈 등록
@RequestMapping("/api/member")//클래스내 http 매핑 주소 공통 URL 정의할 때 사용
//1. 페이지 url : -/member/signup
//2. Rest url :
    //1. /member/signup.do : 뒤에 do를 붙이는 경우(과거)
    //2. /api/member : 앞에 api붙이는 경우(최근)
@RequiredArgsConstructor // final 멤버변수에 대해서 자동 생성자를 자동으로 지원한다.
public class MemberController {
    //1.
    //@Autowired MemberService memberService;

    //2. SPRING 공식 권장 방식
    private final MemberService memberService;

    //[1] 회원가입
    @PostMapping("/signup")
    public boolean signup(@RequestBody MemberDto memberDto){
        System.out.println("MemberController.singnup");
        System.out.println("memberDto = " + memberDto);
        return memberService.signup(memberDto);
    }
    // [2] 로그인
    @PostMapping("/login")
    //  [POST]  http://localhost:8080/api/member/login
    // Content-Type : application/json
    // body : { "mid" : "qwe" , "mpwd":"1234" }
    public boolean login(@RequestBody MemberDto memberDto, HttpServletRequest req){
        System.out.println("MemberController.login");
        System.out.println("memberDto = " + memberDto);
        MemberDto result = memberService.login( memberDto );
        if( result == null ){ return false;} // 서비스 결과가 null 이면 로그인 실패
        else{  HttpSession session = req.getSession(); // - 세션 호출
            session.setAttribute("loginDto" , result ); // 세션 객체내 새로운 속성 추가 , 로그인성공한 결과를 'loginDto' 라는 이름으로 저장.
            session.setMaxInactiveInterval( 60 * 10 ); // 세션 유지 시간[초] : 60*10 => 10분
            return true;


        } // 서비스 결과가 null 이 아니면 로그인 성공


    }
    @GetMapping("/logout")
    public boolean logout( HttpServletRequest request ){
        HttpSession session = request.getSession();// 1. 세션 호출
        if( session == null ) return false;
        //session.invalidate(); // 2. 세션내 전체 속성 초기화 한다.
        session.removeAttribute("loginDto"); // 2. 세션내 특정 속성만 초기화 한다.
        return true;
    } // f end
    @GetMapping("/info")
    public MemberDto info( HttpServletRequest request ) {
        HttpSession session = request.getSession();// 1. 세션호출
        if (session == null) {}
            return null; // 2. 만약에 세션이 존재하지 않으면 null 반환
    }

}
