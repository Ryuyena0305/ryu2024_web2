package example.day05.controller;



import example.day05.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/day05/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    //[1] 등록
    @PostMapping
    public int save(@RequestBody HashMap<String,Object> map){
        System.out.println("StudentController.save");
        return  studentService.save( map );
    }
    //[2] 전체조회
    @GetMapping
    public List<Map<String,Object>> findAll(){
        System.out.println("StudentController.findAll");
        return studentService.findAll();
    }
    //[3] 수정
    @PutMapping("")
    public int update( @RequestBody HashMap<String,Object> map){
        System.out.println("StudentController.update");
        System.out.println("map = " + map);
        return studentService.update( map );
    }
    @DeleteMapping
    public boolean delete(@RequestParam("sno") int  sno){
        System.out.println("StudentController.delete");
        System.out.println("sno = " + sno);
        return studentService.delete( sno );
    }

    // [5] 특정 점수 이상 학생 조회
    @GetMapping("/find/scores") // get , http://localhost:8080/day05/students/find/scores?minKor=70&minMath=70
    public List< Map<String,Object> > findStudentScores(
            @RequestParam int minKor ,
            @RequestParam int minMath ){
        System.out.println("StudentController.findStudentScores");
        System.out.println("minKor = " + minKor + ", minMath = " + minMath);
        return studentService.findStudentScores( minKor , minMath);
    }

    //[5] 여러명의 학생 등록하기
    @PostMapping("/save/all")
    public boolean saveAll(@RequestBody List<Map<String,Object>> List){
        System.out.println("StudentController.saveAll");
        System.out.println("List = " + List);
        return false;
    }
}
