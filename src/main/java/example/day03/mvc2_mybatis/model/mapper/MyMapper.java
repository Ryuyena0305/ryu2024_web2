package example.day03.mvc2_mybatis.model.mapper;

import example.day03.mvc2_mybatis.model.dto.MyDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyMapper {
    //[1] 등록 SQL 처리하는 매퍼 추상메소드
    int save (MyDto myDto);
    //[2] 전체조회 SQL 처리하는 매퍼
    List<MyDto> findAll();
    //[3] 개별조회 SQL 처리하는 매퍼
    MyDto find(int id);
    //[4] 수정 SQL 처리하는 매퍼
    int update(MyDto myDto);
    //[5] 개별 삭제 SQL 처리하는 매퍼
    int delete(int id);
}
