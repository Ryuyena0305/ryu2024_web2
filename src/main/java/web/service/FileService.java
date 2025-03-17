package web.service;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.UUID;

@Service
public class FileService {
    //[*] 업로드된 파일을 저장할 폴더 경로 resources(폴더)
    //1. 현재 프로젝트 최상위 디렉토리(폴더) 경로찾기
    String baseDir = System.getProperty("user.dir");//현재 작업중인 최상위(프로젝트 절대경로) 폴더
    // src와 build 폴더 차이점 : src(실행전코드  : 개발자) vs build(실행후 코드 : 사용자)
    // * 개발자는 src에서 작업하고 항상 서버를 실행 하므로써 작업한 코드를 build로 반영한다(컴파일/빌드)
    // * 업로드는 개발자의 src에 업로드 하지 않고 배포/빌드 된 build 폴더에 업로드한다.
    //String uploadPath = "/src/resources/static/upload";
    String uploadPath = baseDir + "/build/resources/main/static/upload/";


    //[1] 업로드 : 스프링에서는 MultipartFile 인터페이스 지원하므로 파일 업로드 지원
    public String fileUpload(MultipartFile multipartFile){//(1) 매개변수로 'MultipartFile' 인터페이스 타입을 받는다.
        //(2) multipartFile 인터페이스내 다양한 메소드 제공한다.
        System.out.println(multipartFile.getContentType()); //첨부파일의 확장자 반환
        System.out.println(multipartFile.getSize()); //첨부파일의 용량(바이트)반환
        System.out.println(multipartFile.getOriginalFilename()); //첨부파일의 파일명 반환
        System.out.println(multipartFile.isEmpty()); //첨부파일이 있다true, 없다False 반환

        //(3) 업로드 할 경로 만들기
            //(+) 동일한 파일명으로 업로드할경우 식별이 불가능하다. 해결방안 : UUID, 식별자 생성(고유성보장)
        String uuid = UUID.randomUUID().toString();
        String fileName = uuid + "_" + multipartFile.getOriginalFilename().replaceAll("_","-");

        String filePath = uploadPath + fileName;

        //(4) File 클래스 : File 관련된 다양한 메소드 제공하는 클래스
        File file = new File(filePath); //new File(파일경로);

        //(5) 업로드 하기 , transferTo(file객체)
        try {
            multipartFile.transferTo(file);
        }catch (IOException e) {
            System.out.println(e); return null;
        }
        return fileName;
    }

    
    //[2] 다운로드
    public void fileDownload(String filename, HttpServletResponse response){//(1) 다운로드할파일명과 HTTP 응답객체 받는다.
        //(2) 다운로드 할 파일의 경로 조합
        String downloadPath = uploadPath+filename;
        System.out.println("downloadPath = " + downloadPath);
        //(3) 만일 다운로드할 파일이 존재하지 않으면 리턴
        File file = new File(downloadPath);
        if(!file.exists()){return;} //다운로드 취소/안함
        //(4) 업로드된 파일을 자바(바이트)로 가져오기
        try{
            //1. 파일 입력 스트림 객체 생성, new FileInputStream(파일객체) : 예외처리
            FileInputStream fin = new FileInputStream(downloadPath);
            //2. 해당하는 파일의 용량만큼 배열 선언
            long fileSize = file.length(); //파일의 용량 구하기
            byte[] bytes = new byte[(int)fileSize]; //파일의 용량만큼 배열 선언, 배열은 int타입으로 길이 설정
            //3. 파일 입력스트러머 객체로 파일 읽어오기 , .read(바이트배열)
            fin.read(bytes);
            System.out.println(Arrays.toString(bytes));

            //4. 파일 입력스트림 닫기 , .close()
            fin.close();


        }catch(Exception){
            System.out.println(e);
        }



    }
    
    //[3] 업로드된  파일삭제
    public boolean fileDelete(String filename){//(1) 삭제할 파일명을 매개변수로 받는다.
        String filePath = uploadPath +filename;  //(2) 업로드된 경로와 삭제할 파일명 연결한다.
        File file = new File(filePath);//(3) new File(파일경로)
        if(file.exists()){//(4) .exists() : 경로상의 파일이 존재하면 true 아니면 false 반환
            file.delete(); //(5) delete() : 경로상의 파일 삭제
            return true;
        }
        return false;
    }
    
}
