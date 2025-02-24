package example.day04._실습.model.mapper;

import example.day04._실습.model.dto.StudentDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {

    // + SQL 매핑 하는 방법 : 1. .XML 파일에 작성된 sql 매핑 지원  2.@SQL어노테이션 매핑 지원

    @Insert(" insert into student( name, kor, math )values( #{ name }, #{ kor }, #{ math } )")
    int save(StudentDto studentDto);

    @Select(" select * from student")
    public List<StudentDto> findAll();
    @Select(" select * from student where sno = #{ sno }")
    public StudentDto find( int sno );

    @Update(" update student set name = #{ name } , kor = #{ kor } , math = #{ math } where sno = #{ sno }")
    public int update( StudentDto studentDto );

    @Delete(" delete from student where sno = #{ sno }")
    public int delete( int id );
}
