package web.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import web.model.dto.MemberDto;
import web.model.mapper.MemberMapper;

@Service
@RequiredArgsConstructor // final 필드에 대해서 @Autowired 생략 가능하다.
public class MemberService {

    private final MemberMapper memberMapper;
    private final FileService fileService;//파일서비스(업로드,다운로드,파일삭제) 기능 포함

    public boolean signup(MemberDto memberDto){
        System.out.println("MemberService.singnup");
        System.out.println("memberDto = " + memberDto);
        try {
        //(1) 만약에 첨부파일(프로필업로드) 존재하는지 검사
        if(memberDto.getUploadfile()==null){//업로드가 존재하지 않으면
            
        }else{//업로드가 존재하면 파일서비스의 업로드 메소드 사용하기
            fileService.fileUpload(memberDto.getUploadfile());
            //(2) 파일서비스내 업로드 함수 이용하여 첨부파일 업로드하고 파일명 받기
            String fileName = fileService.fileUpload(memberDto.getUploadfile());
            //(3) 업로드된 파일명을  dto에 저장
            memberDto.setMimg(fileName);
        }



        boolean result = memberMapper.signup(memberDto);
        System.out.println("result = " + result);
        return result;
        } catch (Exception e) {
            return false;
        }
    }

    // [2] 로그인
    public MemberDto login( MemberDto memberDto ){
        System.out.println("MemberService.login");
        System.out.println("memberDto = " + memberDto);
        //return false;
        MemberDto result = memberMapper.login( memberDto );
        return result;
    }

}
