package example.day04._실습.model.mapper;

import example.day04._실습.model.dto.StudentDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    // + SQL 매핑 하는 방법 : 1. .XML 파일에 작성된 sql 매핑 지원  2.@SQL어노테이션 매핑 지원

    @Insert(" insert into student( name, kor , math ) values( #{ name } , #{ kor }, #{math} ) ") // [4] 어노테이션 SQL 매핑
    int save(StudentDto studentDto );// [4] .xml 파일의 SQL 매핑 ( 복잡한 쿼리 관리 편리성 )

    @Select(" select * from student ")
    public abstract List< StudentDto > findAll();

    @Select(" select * from student where sno = #{ sno }")
    public StudentDto find(int sno );

    @Update(" update student set name = #{ name } , kor = #{ kor }, math = #{math} where sno = #{ sno } ")
    int update(  StudentDto studentDto );

    @Delete(" delete from student where sno = #{ sno }" )
    int delete(  int sno );
}
