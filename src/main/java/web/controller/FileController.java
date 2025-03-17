package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import web.service.FileService;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    //[1] 업로드
    @PostMapping("/upload")
    public String fileUpload(MultipartFile multipartFile){
        System.out.println("FileController.fileUpload");
        System.out.println("multipartFile = " + multipartFile);
        String result = fileService.fileUpload(multipartFile);
        return result;
    }

    //[2] 업로드된 파일 다운로드

    //[3] 업로드된 파일삭제
    // [3] 업로드된 파일삭제
    @GetMapping("/delete")
    public void fileDelete(@RequestParam String filename ){
        System.out.println("FileController.fileDelete");
        System.out.println("filename = " + filename);
        fileService.fileDelete( filename );
    }
}
