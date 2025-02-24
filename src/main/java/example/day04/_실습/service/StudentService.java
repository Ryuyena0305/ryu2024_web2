package example.day04._실습.service;

import example.day04._실습.model.dto.StudentDto;
import example.day04._실습.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;



    public int save(StudentDto studentDto) {
        System.out.println("StudentController.save");
        System.out.println("studentDto = " + studentDto);
        return studentMapper.save(studentDto);
    }


    public List<StudentDto> findAll() {
        return studentMapper.findAll();
    }

    public StudentDto find( int sno) {
        return studentMapper.find(sno);
    }

    public int update(StudentDto studentDto) {
        return studentMapper.update(studentDto);
    }


    public int delete(int sno) {
        return studentMapper.delete(sno);
    }
}
