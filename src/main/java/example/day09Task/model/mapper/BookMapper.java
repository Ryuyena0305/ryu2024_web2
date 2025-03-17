package example.day09Task.model.mapper;

import example.day09Task.model.dto.BookDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    @Insert("insert into book(writer,name,comment,pwd) values(#{writer}, #{name}, #{comment}, #{pwd})")
    int onPost( BookDto bookDto);

    @Select("select * from book")
    public List<BookDto> onGet();
    @Select("select * from book where id = #{id}")
    public BookDto onGetbyid(int id);

    @Update("update book set writer = #{writer}, name = #{name}, comment = #{comment} where id = #{id}")
    public int onUpdate(BookDto bookDto);

    @Delete("delete from book where id = #{id}")
    public int onDelete( int id);


}
