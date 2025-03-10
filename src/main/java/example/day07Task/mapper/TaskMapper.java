package example.day07Task.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface TaskMapper {
    //인터페이스란? 공통된 메소드들을 추상화해서 각 사용할 클래스에서 구체화(재정의)한다.
    //추상메소드란? 추상메소드 : 메소드의 구현부를 빼고 선언만 존재하는 메소드
    //-> 여러개 곳에서 사용할 메소드를 반환타입, 매개변수, 함수명 만 정의하고 각 사용처에서 구현한다.

    @Insert("insert into phone(name, phone)values(#{name}, #{phone})")
    int onPost (Map<Object,String> Map);

    // @Select("select * from student") //native 쿼리 제공 : 순수한 SQL 작성
    @Select( "<script> select * from phone </script> ")      // 동적 쿼리 제공 : 순수한 SQL에 mybatis의 추가적인 쿼리 제공 // XML형식
    List< Map<Object,String> > onFindAll();



}
