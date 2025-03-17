package web.controller;

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
}
