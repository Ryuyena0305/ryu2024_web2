package web.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.model.dto.MemberDto;
import web.model.mapper.MemberMapper;

@Service
@RequiredArgsConstructor // final 필드에 대해서 @Autowired 생략 가능하다.
public class MemberService {

    private final MemberMapper memberMapper;

    public boolean signup(MemberDto memberDto){
        System.out.println("MemberService.singnup");
        System.out.println("memberDto = " + memberDto);
        return memberMapper.signup(memberDto);
    }
}
