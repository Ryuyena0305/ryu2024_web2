package example.day04._실습.controller;

import example.day04._실습.model.dto.StudentDto;
import example.day04._실습.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/day04/student")  // /api/student로 요청을 받음
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping("")
    public int save(@RequestBody StudentDto studentDto) {
        System.out.println("StudentController.save");
        System.out.println("studentDto = " + studentDto);
        return studentService.save(studentDto);
    }

    @GetMapping("")
    public List<StudentDto> findAll() {
        return studentService.findAll();
    }
    @GetMapping("/view")
    public StudentDto find(@PathVariable int sno) {
        return studentService.find(sno);
    }

    @PutMapping("")
    public int update(@RequestBody StudentDto studentDto) {
        return studentService.update(studentDto);
    }

    @DeleteMapping("")
    public int delete(@RequestParam("sno") int sno) {
        return studentService.delete(sno);
    }
}
